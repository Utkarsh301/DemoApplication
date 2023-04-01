package com.example.demoapplication.data.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("email")
    var email: String,
    @SerializedName("gender")
    var gender: String,
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("status")
    var status: String
)