package com.kotlin.harrypotterapp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.harrypotterapp.SharedPreferences
import com.kotlin.harrypotterapp.databinding.ActivityLoginBinding
import com.kotlin.harrypotterapp.model.User

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var user: User
    private var sharedPreferences : SharedPreferences = SharedPreferences()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        
        checkPreference()

        initialiceUser()

    }

    private fun checkPreference() {
        if (sharedPreferences.getCloseActivity(this)) {
            sendToMainActivity()
            finish()
        }
    }

    private fun initialiceUser() {
        user = User()
        user.userName = "jose12"
        user.passWord = "1234"

        btnClick(user)
    }

    private fun btnClick(user: User) {

        binding.buttonLogin.setOnClickListener {

            val userString: String= binding.editTextUser.text.toString()
            val passString: String=  binding.editTextPass.text.toString()

            sharedPreferences.setFullNameUserLoged(this,userString)
            sharedPreferences.setCloseActivity(this,true)

            if (userString == user.userName && passString == user.passWord) {
               sendToMainActivity()
            }else if (userString.isEmpty() || passString.isEmpty()){
                Toast.makeText(this, "Campos vacios", Toast.LENGTH_SHORT)
                    .show()
            }else
                Toast.makeText(this, "Credenciales Invalidas, intente de nuevo", Toast.LENGTH_SHORT)
                    .show()
        }
    }

    private fun sendToMainActivity() {
        //Toast.makeText(this, "Bienvenido:${user.userName}", Toast.LENGTH_SHORT).show()
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}