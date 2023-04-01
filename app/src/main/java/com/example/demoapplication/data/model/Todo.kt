package com.example.demoapplication.data.model


import com.google.gson.annotations.SerializedName

data class Todo(
    @SerializedName("due_on")
    var dueOn: String, // 2023-04-29T00:00:00.000+05:30
    @SerializedName("id")
    var id: Int, // 4846
    @SerializedName("status")
    var status: String, // pending
    @SerializedName("title")
    var title: String, // Dolores textor virtus sonitus vorago.
    @SerializedName("user_id")
    var userId: Int // 641696
)