package com.kotlin.harrypotterapp

import android.app.Activity
import android.content.Context

class SharedPreferences {

    //TODO esta clase contendra todas las sharedpreferences que son para guardar datos en el telefono que tienen una clave-valor para que pasemos el parametro que queremos que se guarde y tambien para obtenerlo

    fun setFullNameUserLoged(context: Activity, userName: String) { //preferencia para guardar el nombre de usuario
        val sharedPref =
            context.application.getSharedPreferences("user_pass_login", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("userNamePref", userName)
        editor.apply()
    }

    fun getFullNameUserLoged(context: Activity, userName: String): String? {
        val sharedPref = context.application.getSharedPreferences("user_pass_login", Context.MODE_PRIVATE)
        return sharedPref.getString("userNamePref",null)
    }


    fun setCloseActivity(context: Activity, boolean: Boolean) { //preferencia para que la actividad no vuevla a mostrarse. por ejemplo el loginActivity no vuelva a mostrarse una vez que el usuario se inicia sesion
        val sharedPref = context.application.getSharedPreferences("boolean_login", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("booleanLogin", boolean)
        editor.commit();
    }


    fun getCloseActivity(context: Activity): Boolean { //obtendremos la preferencia en la actividad para saber que tipo de boolean tenemos para seguir en la activity o pasar a la siguiente
        val sharedPref = context.application.getSharedPreferences("boolean_login", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("booleanLogin",false)
    }


}