package com.kotlin.harrypotterapp.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class InfoModel {

    @SerializedName("id")
    @Expose
    private val id: Int? = null

    @SerializedName("tipo")
    @Expose
    private val tipo: String? = null

    @SerializedName("contenido")
    @Expose
    private val contenido: String? = null

}