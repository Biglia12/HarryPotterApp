package com.kotlin.harrypotterapp.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.kotlin.harrypotterapp.Constants
import com.kotlin.harrypotterapp.activities.DetailedCharacterActivity
import com.kotlin.harrypotterapp.adapters.CharacterAdapter
import com.kotlin.harrypotterapp.adapters.OnItemCharacterClickListener
import com.kotlin.harrypotterapp.databinding.FragmentHomeBinding
import com.kotlin.harrypotterapp.model.CharactersModel
import com.kotlin.harrypotterapp.service.Services
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class HomeFragment : Fragment(), OnItemCharacterClickListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: CharacterAdapter
    private val listCharacter = mutableListOf<CharactersModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)


        initRecyclerView()
        getRetrofit()
        callServiceHp()

        return binding.root
    }

    private fun initRecyclerView() {
        adapter = CharacterAdapter(requireContext(), listCharacter, this)
        binding.recyclerHome.layoutManager = LinearLayoutManager(requireActivity())
        binding.recyclerHome.adapter = adapter

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

    private fun callServiceHp() {
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(Services::class.java).getCharacters()
            val body = call.body()
            activity?.runOnUiThread {
                if (call.isSuccessful) { // si el servicio responde 200
                    binding.progressBar.visibility = View.GONE
                    val characters = body?.personajes ?: emptyList()
                    listCharacter.clear()
                    listCharacter.addAll(characters)
                    adapter.notifyDataSetChanged() // para decirle al adapter que hubo cambios
                } else { // si el servicio no funciona
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(context, "Error para traer informacion", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }

    }

    override fun onItemClick(item: CharactersModel, position: Int) {
        val intent = Intent(context, DetailedCharacterActivity :: class.java)
        intent.putExtra("IMAGE_URL", item.imagen)
        intent.putExtra("NAME_CHARACTER", item.personaje)
        startActivity(intent)

    }

}