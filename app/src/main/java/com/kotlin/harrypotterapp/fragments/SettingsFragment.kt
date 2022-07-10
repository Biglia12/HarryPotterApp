package com.kotlin.harrypotterapp.fragments

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kotlin.harrypotterapp.R
import com.kotlin.harrypotterapp.activities.LoginActivity
import com.kotlin.harrypotterapp.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {


    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)

        binding.buttonLogOut.setOnClickListener {
            deletePreferences()
            alertDialogLogOut()
        }

        return binding.root

    }

    private fun alertDialogLogOut() {

        val alertDialog = AlertDialog.Builder(context)

        alertDialog.apply {
            setTitle(resources.getString(R.string.log_out))
            setMessage(resources.getString(R.string.message_log_out))
            setPositiveButton("Si") { _: DialogInterface?, _: Int ->
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
            requireContext().getSharedPreferences("boolean_login", Context.MODE_PRIVATE)
        settings.edit().clear().apply()
    }


}
