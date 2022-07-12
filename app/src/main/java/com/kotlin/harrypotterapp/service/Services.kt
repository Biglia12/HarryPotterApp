package com.kotlin.harrypotterapp.service

import com.kotlin.harrypotterapp.model.CharactersResponse
import retrofit2.Response
import retrofit2.http.GET

interface Services {

    @GET("db")
    suspend fun getCharacters(): Response<CharactersResponse>

}