package com.kotlin.harrypotterapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CharactersResponse { // se crea para obtenerlos del servicio es un model que sera identilo a lo que nos pasa el JSON

    @SerializedName("hechizos") // el SerializaedName nada es para que nosotros podamos poner el nombre a la varibale que querramos sin ser necesaria el mismo nombre que nos viene por servicio
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