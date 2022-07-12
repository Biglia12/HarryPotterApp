package com.kotlin.harrypotterapp.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class HechizoModel {
    @SerializedName("id")
    @Expose
    private val id: Int? = null

    @SerializedName("hechizo")
    @Expose
    private val hechizo: String? = null

    @SerializedName("uso")
    @Expose
    private val uso: String? = null

}