package com.kotlin.harrypotterapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.kotlin.harrypotterapp.R
import com.kotlin.harrypotterapp.SharedPreferences
import com.kotlin.harrypotterapp.databinding.ActivityMainBinding
import com.kotlin.harrypotterapp.fragments.HomeFragment
import com.kotlin.harrypotterapp.fragments.SettingsFragment
import com.kotlin.harrypotterapp.fragments.WebFragment

class MainActivity : AppCompatActivity() {

    val sharedPreferences: SharedPreferences = SharedPreferences()
    private lateinit var binding: ActivityMainBinding

    private lateinit var homeFragment : HomeFragment
    private lateinit var webFragment : WebFragment
    private lateinit var settingsFragment : SettingsFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        initializations() //metodo donde iniciallizaremos los fragments

        bottomNavigationListener()


    }

    private fun initializations() {
        homeFragment = HomeFragment()
        webFragment = WebFragment()
        settingsFragment = SettingsFragment()

        loadFragment(homeFragment) //metodo para cargar el fragment. Le pasamos el homefragment para que inicie primero

    }

    private fun bottomNavigationListener() {
        binding.bottomNavigation.setOnItemSelectedListener { //seleccionaremos los fragments con este listener del bottom
            when(it.itemId){
                R.id.menu_home -> loadFragment(homeFragment)
                R.id.menu_video -> loadFragment(webFragment)
                R.id.menu_setting -> loadFragment(settingsFragment)
            }
            true
        }
    }

    private fun loadFragment(fragment : Fragment) { //este metodo pondra el fragmento que mandamo por parametro
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.containerFragment, fragment)
            commit() //
        }
    }



}