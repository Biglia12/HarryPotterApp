package com.kotlin.harrypotterapp.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.kotlin.harrypotterapp.Constants
import com.kotlin.harrypotterapp.databinding.FragmentHomeBinding
import com.kotlin.harrypotterapp.service.Services
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)


        getRetrofit()

        callServiceHp()

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    private fun getRetrofit(): Retrofit {

        return Retrofit.Builder()
            .baseUrl(Constants.URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun callServiceHp(){

        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(Services::class.java).getCharacters()
            activity?.runOnUiThread {
                if (call.isSuccessful){ // si el servicio responde 200
                    Toast.makeText(context, "aaadasdsa", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(context, "Its a toast!", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }


}