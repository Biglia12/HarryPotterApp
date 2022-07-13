package com.kotlin.harrypotterapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.harrypotterapp.R
import com.kotlin.harrypotterapp.databinding.ActivityDetailedCharacterBinding
import com.squareup.picasso.Picasso

class DetailedCharacterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailedCharacterBinding
    private lateinit var imgUrl: String
    private lateinit var stringNameCharacter: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailedCharacterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        imgUrl = intent.getStringExtra("IMAGE_URL").toString()
        stringNameCharacter = intent.getStringExtra("NAME_CHARACTER").toString()

        binding.txtDetailedName.text = stringNameCharacter
        picassoUrl(imgUrl)

    }

    private fun picassoUrl(imgUrl: String) {
        Picasso.get()
            .load(imgUrl)
            .placeholder(R.drawable.ic_icon_placeholder_harry)
            .into(binding.imageViewDetailed)
    }


}