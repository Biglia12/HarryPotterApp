package com.kotlin.harrypotterapp.fragments

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.kotlin.harrypotterapp.R
import com.kotlin.harrypotterapp.activities.LoginActivity
import com.kotlin.harrypotterapp.databinding.FragmentSettingsBinding


class SettingsFragment : Fragment() {


    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    private lateinit var sharedPreferences: com.kotlin.harrypotterapp.SharedPreferences
    private var selectedColorIndex: Int = 0
    private val colors = arrayOf("Rojo", "Verde", "Amarillo", "Azul")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)

        sharedPreferences = com.kotlin.harrypotterapp.SharedPreferences()

        getNameUserPref()
        getColorPref()
        listeners()


        return binding.root

    }

    private fun getNameUserPref() {
        binding.textViewNameUser.text = activity?.let { sharedPreferences.getFullNameUserLoged(it) }
    }

    private fun getColorPref() {
        binding.constraintLayoutBackground.setBackgroundColor(sharedPreferences.getColorBackground(requireActivity()))
    }

    private fun listeners() { // metodo para los listener de los botones

        binding.buttonLogOut.setOnClickListener {
            alertDialogLogOut() // metodo para  cerrar sesion
        }

        binding.buttonChangeColor.setOnClickListener {
            changeColor() // cambiar color del constrain
        }

        binding.buttonHelp.setOnClickListener { // para enviar a un email externo
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

    }

    private fun changeColor() {
        var selectedColor = colors[selectedColorIndex]
        AlertDialog.Builder(context)
            .setTitle("Elige el color de tu casa favorita")  // dialogo que para elegir color de fonode
            .setSingleChoiceItems(colors, selectedColorIndex) { dialog_, which ->
                selectedColor = colors[which]
            }
            .setPositiveButton("Ok") { dialog, which ->
                changeColorBackground(selectedColor)
            }
            .setNegativeButton("Cancel") { dialog, which ->
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

        Toast.makeText(context, "$selectedColor Selected", Toast.LENGTH_SHORT)
            .show()
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
