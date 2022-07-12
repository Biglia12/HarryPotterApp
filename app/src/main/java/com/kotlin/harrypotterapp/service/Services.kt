package com.kotlin.harrypotterapp.service

import retrofit2.Response
import retrofit2.http.GET

interface Services {

    @GET("db")
    suspend fun getCharacters(): Response<Any>

}