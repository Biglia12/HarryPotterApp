package com.kotlin.harrypotterapp.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class BookModel {

    @SerializedName("id")
    @Expose
    private val id: Int? = null

    @SerializedName("libro")
    @Expose
    private val libro: String? = null

    @SerializedName("titulo_original")
    @Expose
    private val tituloOriginal: String? = null

    @SerializedName("fecha_de_lanzamiento")
    @Expose
    private val fechaDeLanzamiento: String? = null

    @SerializedName("autora")
    @Expose
    private val autora: String? = null

    @SerializedName("descripcion")
    @Expose
    private val descripcion: String? = null

}