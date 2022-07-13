package com.kotlin.harrypotterapp.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class CharactersModel {

    @SerializedName("id")
    @Expose
    val id: Int? = null

    @SerializedName("personaje")
    @Expose
    val personaje: String? = null

    @SerializedName("apodo")
    @Expose
    val apodo: String? = null

    @SerializedName("estudianteDeHogwarts")
    @Expose
    val estudianteDeHogwarts: Boolean? = null

    @SerializedName("casaDeHogwarts")
    @Expose
    val casaDeHogwarts: String? = null

    @SerializedName("interpretado_por")
    @Expose
    val interpretadoPor: String? = null

    @SerializedName("hijos")
    @Expose
    val hijos: List<String>? = null

    @SerializedName("imagen")
    @Expose
    val imagen: String? = null

}