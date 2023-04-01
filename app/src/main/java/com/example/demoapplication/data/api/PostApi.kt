package com.example.demoapplication.data.api

import com.example.demoapplication.data.model.Post
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface PostApi {
    @GET("posts")
    suspend fun getAllPosts(
        @Query("page") page: String,
        @Query("per_page") perPage: String = "10"
    ): Response<MutableList<Post>?>

    @GET("users/{id}/posts")
    suspend fun getUserPosts(
        @Path("id") id: String,
        @Query("page") page: String,
        @Query("per_page") perPage: String = "10"
    ): Response<MutableList<Post>?>

    @POST("users/{id}/posts")
    suspend fun createNewUserPost(
        @Path("id") id: String,
        @Body post: Post
    ): Response<Post?>
}