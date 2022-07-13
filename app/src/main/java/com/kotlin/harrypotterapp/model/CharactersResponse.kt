package com.kotlin.harrypotterapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CharactersResponse {

    @SerializedName("hechizos")
    @Expose
    val hechizos: List<HechizoModel>? = null

    @SerializedName("info")
    @Expose
    val info: List<InfoModel>? = null

    @SerializedName("personajes")
    @Expose
    val personajes: List<CharactersModel>? = null

    @SerializedName("libros")
    @Expose
    val libros: List<BookModel>? = null

}