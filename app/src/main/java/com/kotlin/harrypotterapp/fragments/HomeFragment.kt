package com.kotlin.harrypotterapp.fragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.kotlin.harrypotterapp.Constants
import com.kotlin.harrypotterapp.databinding.FragmentHomeBinding
import com.kotlin.harrypotterapp.model.Characters
import com.kotlin.harrypotterapp.service.Services
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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
                if (call.isSuccessful){
                    Toast.makeText(context, "aaadasdsa", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(context, "Its a toast!", Toast.LENGTH_SHORT).show()
                }
            }
        }

        /*val retrofit = Retrofit.Builder()
            .baseUrl(Constants.URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(Services::class.java)
        api.getCharacters().enqueue(object : Callback<Any> {
            override fun onResponse(
                call: Call<Any>,
                response: Response<Any>
            ) {
                if (response.isSuccessful) {
                    Toast.makeText(context, "aaadasdsa", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
                Toast.makeText(context, "Its a toast!", Toast.LENGTH_SHORT).show()
            }

        })*/

    }


}