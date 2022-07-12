package com.kotlin.harrypotterapp.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class CharactersModel {

    @SerializedName("id")
    @Expose
    private val id: Int? = null

    @SerializedName("personaje")
    @Expose
    private val personaje: String? = null

    @SerializedName("apodo")
    @Expose
    private val apodo: String? = null

    @SerializedName("estudianteDeHogwarts")
    @Expose
    private val estudianteDeHogwarts: Boolean? = null

    @SerializedName("casaDeHogwarts")
    @Expose
    private val casaDeHogwarts: String? = null

    @SerializedName("interpretado_por")
    @Expose
    private val interpretadoPor: String? = null

    @SerializedName("hijos")
    @Expose
    private val hijos: List<String>? = null

    @SerializedName("imagen")
    @Expose
    private val imagen: String? = null

}