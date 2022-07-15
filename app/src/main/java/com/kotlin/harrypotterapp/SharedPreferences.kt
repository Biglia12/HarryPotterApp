package com.kotlin.harrypotterapp

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import java.io.ByteArrayOutputStream


class SharedPreferences {
    private lateinit var decodedByte: ByteArray

    //TODO esta clase contendra todas las sharedpreferences que son para guardar datos en el telefono que tienen una clave-valor para que pasaremos el parametro que queremos que se guarde y tambien para obtenerlo

    fun setFullNameUserLoged(
        context: Activity,
        userName: String
    ) { //preferencia para guardar el nombre de usuario
        val sharedPref =
            context.application.getSharedPreferences("App", 0)
        val editor = sharedPref.edit()
        editor.putString("userNamePref", userName)
        editor.apply()
    }

    fun getFullNameUserLoged(context: Activity): String? {
        val sharedPref = context.application.getSharedPreferences("App", 0)
        return sharedPref.getString("userNamePref", null)
    }


    fun setBooleanPrefLogin(
        context: Activity,
        boolean: Boolean
    ) { //preferencia para que la actividad no vuevla a mostrarse. por ejemplo el loginActivity no vuelva a mostrarse una vez que el usuario se inicia sesion
        val sharedPref = context.application.getSharedPreferences("App", 0)
        val editor = sharedPref.edit()
        editor.putBoolean("booleanPrefLogin", boolean)
        editor.commit();
    }


    fun getBooleanPreImage(context: Activity): Boolean {
        val sharedPref = context.application.getSharedPreferences("App", 0)
        return sharedPref.getBoolean("booleanPrefImage", false)
    }

    fun setBooleanPrefImage(
        context: Activity,
        boolean: Boolean
    ) {
        val sharedPref = context.application.getSharedPreferences("App", 0)
        val editor = sharedPref.edit()
        editor.putBoolean("booleanPrefImage", boolean)
        editor.commit();
    }


    fun getBooleanPrefLogin(context: Activity): Boolean { //obtendremos la preferencia en la actividad para saber que tipo de boolean tenemos para seguir en la activity o pasar a la siguiente
        val sharedPref = context.application.getSharedPreferences("App", 0)
        return sharedPref.getBoolean("booleanPrefLogin", false)
    }

    fun saveColorBackground(context: Activity, color: Int) { // para guardar color
        val sharedPref = context.application.getSharedPreferences("App", 0)
        val editor = sharedPref.edit()
        editor.putInt("colorBackgroundPref", color)
        editor.commit()
    }

    fun getColorBackground(context: Activity): Int { // para obtnere color
        val sharedPref = context.application.getSharedPreferences("App", 0)
        return sharedPref.getInt("colorBackgroundPref", 0)
    }


    fun setBitmapImage(context: Activity, image: Bitmap) { // para guardar imagen
        val sharedPref = context.application.getSharedPreferences("App", 0)
        val editor = sharedPref.edit()
        editor.putString("bitmapImagePref", encodeToBase64(image))
        editor.commit()
    }

    fun getBitmapImage(context: Activity): Bitmap { // para obtener imagen
        val sharedPref = context.application.getSharedPreferences("App", 0)
        val imageS: String? = sharedPref.getString("bitmapImagePref", "")
        if (imageS != null && imageS.isNotEmpty()) {
                decodedByte = Base64.decode(imageS, 0)
        }

        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.size)
    }

    private fun encodeToBase64(image: Bitmap): String { // para codificar el bitmap en cadena 64

        val byteArrayOutputStream = ByteArrayOutputStream()
        image.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
        val b: ByteArray = byteArrayOutputStream.toByteArray()
        val imageEncoded: String = Base64.encodeToString(b, Base64.DEFAULT)
        return imageEncoded

    }


}