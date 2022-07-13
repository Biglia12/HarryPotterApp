package com.kotlin.harrypotterapp.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class HechizoModel {
    @SerializedName("id")
    @Expose
    val id: Int? = null

    @SerializedName("hechizo")
    @Expose
    val hechizo: String? = null

    @SerializedName("uso")
    @Expose
    val uso: String? = null

}