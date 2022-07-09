package com.kotlin.harrypotterapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.harrypotterapp.R
import com.kotlin.harrypotterapp.SharedPreferences

class MainActivity : AppCompatActivity() {

    val sharedPreferences: SharedPreferences = SharedPreferences()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }
}