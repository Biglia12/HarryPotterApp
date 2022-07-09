package com.kotlin.harrypotterapp

import android.app.Activity
import android.content.Context

class SharedPreferences {

    fun setFullNameUserLoged(context: Activity, userName: String) {
        val sharedPref =
            context.application.getSharedPreferences("user_pass_login", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("userNamePref", userName)
        editor.apply()
    }


    fun setCloseActivity(context: Activity, boolean: Boolean) {
        val sharedPref =
            context.application.getSharedPreferences("boolean_login", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("booleanLogin", boolean)
        editor.commit();
    }


    fun getCloseActivity(context: Activity): Boolean {
        val sharedPref = context.application.getSharedPreferences("boolean_login", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("booleanLogin",false)
    }


}