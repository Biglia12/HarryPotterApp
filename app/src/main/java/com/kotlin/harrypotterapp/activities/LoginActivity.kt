package com.kotlin.harrypotterapp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.harrypotterapp.R
import com.kotlin.harrypotterapp.SharedPreferences
import com.kotlin.harrypotterapp.databinding.ActivityLoginBinding
import com.kotlin.harrypotterapp.model.User

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var user: User
    private var sharedPreferences: SharedPreferences = SharedPreferences()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        checkPreference() // metodo para las preferencias

        initialiceUser()

    }

    private fun checkPreference() {
        if (sharedPreferences.getCloseActivity(this)) { //Esta validacion es para que esta actividad no se vuelva a mostrar una vez que el usuario inicio sesion ya que esto guarda localmente la persistencia de datos en el telefono
            sendToMainActivity()// pasamos a la siguiente activity
        }
    }

    private fun initialiceUser() {
        user = User() // Creamos el objeto usuario
        user.userName = "jose12"
        user.passWord = "1234"

        btnClick(user) // metodo para el boton en el cual le pasaremos el usuario
    }

    private fun btnClick(user: User) {

        binding.buttonLogin.setOnClickListener {

            val userString: String =
                binding.editTextUser.text.toString() // se crean estas variable de tipo string para los editext que se pasan a string
            val passString: String = binding.editTextPass.text.toString()

            if (userString == user.userName && passString == user.passWord) { // validacion para que

                sharedPreferences.setFullNameUserLoged(this, userString)
                sharedPreferences.setCloseActivity(this, true)
                sendToMainActivity()

            } else if (userString.isEmpty() || passString.isEmpty()) {
                Toast.makeText(this, resources.getString(R.string.empty_fields), Toast.LENGTH_SHORT)
                    .show()
            } else
                Toast.makeText(this, resources.getString(R.string.wrong_user), Toast.LENGTH_SHORT)
                    .show()
        }
    }

    private fun sendToMainActivity() {
        //Toast.makeText(this, "Bienvenido:${user.userName}", Toast.LENGTH_SHORT).show()
        startActivity(Intent(this, MainActivity::class.java))
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        finish()
    }
}