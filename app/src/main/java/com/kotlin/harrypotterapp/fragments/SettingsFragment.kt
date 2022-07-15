package com.kotlin.harrypotterapp.fragments

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.kotlin.harrypotterapp.R
import com.kotlin.harrypotterapp.activities.LoginActivity
import com.kotlin.harrypotterapp.databinding.FragmentSettingsBinding


class SettingsFragment : Fragment() {


    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    private lateinit var sharedPreferences: com.kotlin.harrypotterapp.SharedPreferences
    private var selectedColorIndex: Int = 0
    private val colors = arrayOf("Rojo", "Verde", "Amarillo", "Azul") //array para los colores
    private lateinit var selectedImage: Bitmap //para almacenar una imageview en esta variable

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)

        sharedPreferences = com.kotlin.harrypotterapp.SharedPreferences()

        getPrefs()
        listeners()


        return binding.root

    }

    private fun getPrefs() {
        binding.textViewNameUser.text = activity?.let { sharedPreferences.getFullNameUserLoged(it) }

        binding.constraintLayoutBackground.setBackgroundColor(
            sharedPreferences.getColorBackground(
                requireActivity()
            )
        )

        if (sharedPreferences.getBooleanPreImage(requireActivity())) { // validacion para que no haya crash. ya que si entra por primerza vez no tendra un bitmap por lo tanto la app crasheara. el boolean se mantendra qunue se destruya la app
            binding.imageProfile.setImageBitmap(sharedPreferences.getBitmapImage(requireContext() as Activity))
        }
    }



    private fun listeners() { // metodo para los listener de los botones

        binding.imageProfile.setOnClickListener {

            selectImgProfileDialog()

        }

        binding.buttonLogOut.setOnClickListener {
            alertDialogLogOut() // metodo para  cerrar sesion
        }

        binding.buttonChangeColor.setOnClickListener {
            changeColor() // cambiar color del constrain
        }

        binding.buttonHelp.setOnClickListener { // para enviar a un email externo
            sendToEmail()
        }

    }


    private fun selectImgProfileDialog() {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.selecte_image_house)
        dialog.show()

        val btnOk: Button = dialog.findViewById<View>(R.id.btnOk) as Button
        val btnCancel: Button = dialog.findViewById<View>(R.id.btnCancel) as Button

        val imgGryffindor: ImageView = dialog.findViewById<View>(R.id.imageGryffindor) as ImageView
        val imgSlytherin: ImageView = dialog.findViewById<View>(R.id.imageSlytherin) as ImageView
        val imgHufflepuff: ImageView = dialog.findViewById<View>(R.id.imageHuffelpuff) as ImageView
        val imgRavenclaw: ImageView = dialog.findViewById<View>(R.id.imageRavenclaw) as ImageView

        val images = arrayOf(imgGryffindor, imgSlytherin, imgHufflepuff, imgRavenclaw)


        imgGryffindor.setOnClickListener {

            selectImages(imgGryffindor, images)

            imgGryffindor.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.shape_select_image)
            imgSlytherin.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.shape_deselected_image)
            imgHufflepuff.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.shape_deselected_image)
            imgRavenclaw.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.shape_deselected_image)
        }

        imgSlytherin.setOnClickListener {
            selectImages(imgSlytherin, images)
            imgSlytherin.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.shape_select_image)
            imgGryffindor.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.shape_deselected_image)
            imgHufflepuff.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.shape_deselected_image)
            imgRavenclaw.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.shape_deselected_image)
        }

        imgHufflepuff.setOnClickListener {
            selectImages(imgHufflepuff, images)
            imgHufflepuff.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.shape_select_image)
            imgSlytherin.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.shape_deselected_image)
            imgGryffindor.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.shape_deselected_image)
            imgRavenclaw.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.shape_deselected_image)
        }

        imgRavenclaw.setOnClickListener {
            selectImages(imgRavenclaw, images)
            imgRavenclaw.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.shape_select_image)
            imgSlytherin.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.shape_deselected_image)
            imgGryffindor.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.shape_deselected_image)
            imgHufflepuff.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.shape_deselected_image)
        }


        btnOk.setOnClickListener {
            binding.imageProfile.setImageBitmap(selectedImage)
            sharedPreferences.setBooleanPrefImage(requireActivity(),true) // se pasa un true para que el bitmap "selectedImage" la primera vez q se entra a la app no tenga un null
            sharedPreferences.setBitmapImage(requireActivity(), selectedImage)
            dialog.dismiss()
        }

        btnCancel.setOnClickListener {
            dialog.dismiss()
        }

    }

    private fun selectImages(imgSelected: ImageView, images: Array<ImageView>) {
        for (i in images) { // for para recorrer el array de imageviews, que hara que si el imageview que se manda por parametro es igual al recorrido en el for se pasara a un bitmap y luego se lo pondra en la variable selectedImage para ser utilizada mas adelante
            if (i == imgSelected) {
                val bitmap = (imgSelected.drawable as BitmapDrawable).bitmap
                selectedImage = bitmap
                break
            }
        }
    }

    private fun changeColor() {
        var selectedColor = colors[selectedColorIndex]
        AlertDialog.Builder(context)
            .setTitle(resources.getString(R.string.choose_color))  // dialogo que para elegir color de fonode
            .setSingleChoiceItems(colors, selectedColorIndex) { dialog_, which ->
                selectedColor = colors[which]
            }
            .setPositiveButton("Ok") { dialog, which ->
                changeColorBackground(selectedColor)
            }
            .setNegativeButton("Cancelar") { dialog, which ->
                dialog.dismiss()
            }
            .show()
    }

    private fun changeColorBackground(selectedColor: String) {
        when (selectedColor) {
            "Rojo" -> {
                binding.constraintLayoutBackground.setBackgroundColor(resources.getColor(R.color.red))
                saveColorPref(resources.getColor(R.color.red))
            }
            "Azul" -> {
                binding.constraintLayoutBackground.setBackgroundColor(resources.getColor(R.color.blue))
                saveColorPref(resources.getColor(R.color.blue))
            }
            "Verde" -> {
                binding.constraintLayoutBackground.setBackgroundColor(resources.getColor(R.color.green))
                saveColorPref(resources.getColor(R.color.green))
            }
            "Amarillo" -> {
                binding.constraintLayoutBackground.setBackgroundColor(resources.getColor(R.color.yellow))
                saveColorPref(resources.getColor(R.color.yellow))
            }
            else -> {
                binding.constraintLayoutBackground.setBackgroundColor(resources.getColor(R.color.gray))
                saveColorPref(resources.getColor(R.color.gray))
            }
        }

    }

    private fun sendToEmail() {
        val emailIntent = Intent(
            Intent.ACTION_SENDTO,
            Uri.fromParts("mailto", "correoFicticio@gmail.com", null)
        )
        startActivity(
            Intent.createChooser(
                emailIntent,
                requireActivity().getString(R.string.send_email)
            )
        )
    }

    private fun saveColorPref(color: Int) {
        sharedPreferences.saveColorBackground(requireActivity(), color)
    }


    private fun alertDialogLogOut() {

        val alertDialog = AlertDialog.Builder(context)

        alertDialog.apply {
            setTitle(resources.getString(R.string.log_out))
            setMessage(resources.getString(R.string.message_log_out))
            setPositiveButton("Si") { _: DialogInterface?, _: Int ->
                deletePreferences()
                goBackLogin()
            }
            setNegativeButton("No") { _, _ ->
            }.create().show()

        }
    }

    private fun goBackLogin() {
        val intent = Intent(activity, LoginActivity::class.java)
        activity?.startActivity(intent)
    }

    private fun deletePreferences() {
        val settings: SharedPreferences =
            requireContext().getSharedPreferences("App", 0)
        settings.edit().clear().apply()
    }


}
