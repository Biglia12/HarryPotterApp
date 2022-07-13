package com.kotlin.harrypotterapp.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class InfoModel {

    @SerializedName("id")
    @Expose
    val id: Int? = null

    @SerializedName("tipo")
    @Expose
    val tipo: String? = null

    @SerializedName("contenido")
    @Expose
    val contenido: String? = null

}