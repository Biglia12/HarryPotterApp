package com.kotlin.harrypotterapp.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class BookModel {

    @SerializedName("id")
    @Expose
    val id: Int? = null

    @SerializedName("libro")
    @Expose
    val libro: String? = null

    @SerializedName("titulo_original")
    @Expose
    val tituloOriginal: String? = null

    @SerializedName("fecha_de_lanzamiento")
    @Expose
    val fechaDeLanzamiento: String? = null

    @SerializedName("autora")
    @Expose
    val autora: String? = null

    @SerializedName("descripcion")
    @Expose
    val descripcion: String? = null

}