package com.example.demoapplication.data.model


import com.google.gson.annotations.SerializedName

data class Comment(
    @SerializedName("body")
    var body: String, // Laborum qui in. Beatae libero consequatur. Alias perferendis adipisci. Qui quaerat unde.
    @SerializedName("email")
    var email: String, // bhooshit_bhattathiri@wuckert.net
    @SerializedName("id")
    var id: Int, // 5592
    @SerializedName("name")
    var name: String, // Bhooshit Bhattathiri
    @SerializedName("post_id")
    var postId: Int // 7385
)