package com.kotlin.harrypotterapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CharactersResponse {

    @SerializedName("hechizos")
    @Expose
    private val hechizos: List<HechizoModel>? = null

    @SerializedName("info")
    @Expose
    private val info: List<InfoModel>? = null

    @SerializedName("personajes")
    @Expose
    private val personajes: List<CharactersModel>? = null

    @SerializedName("libros")
    @Expose
    private val libros: List<BookModel>? = null

}