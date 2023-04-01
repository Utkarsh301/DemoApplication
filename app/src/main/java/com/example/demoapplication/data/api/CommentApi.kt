package com.example.demoapplication.data.api

import com.example.demoapplication.data.model.Comment
import com.example.demoapplication.data.model.Post
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface CommentApi {
    @GET("posts")
    suspend fun getAllComments(
        @Query("page") page: String,
        @Query("per_page") perPage: String = "10"
    ): Response<MutableList<Comment>?>

    @GET("users/{id}/posts")
    suspend fun getUserComments(
        @Path("id") id: String,
        @Query("page") page: String,
        @Query("per_page") perPage: String = "10"
    ): Response<MutableList<Comment>?>

    @POST("users/{id}/posts")
    suspend fun createNewUserComment(
        @Path("id") id: String,
        @Body comment: Comment
    ): Response<Comment?>
}