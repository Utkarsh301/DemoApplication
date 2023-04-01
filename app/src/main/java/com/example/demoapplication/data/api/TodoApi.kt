package com.example.demoapplication.data.api

import com.example.demoapplication.data.model.Comment
import com.example.demoapplication.data.model.Post
import com.example.demoapplication.data.model.Todo
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface TodoApi {
    @GET("posts")
    suspend fun getAllTodos(
        @Query("page") page: String,
        @Query("per_page") perPage: String = "10"
    ): Response<MutableList<Todo>?>

    @GET("users/{id}/posts")
    suspend fun getUserTodos(
        @Path("id") id: String,
        @Query("page") page: String,
        @Query("per_page") perPage: String = "10"
    ): Response<MutableList<Todo>?>

    @POST("users/{id}/posts")
    suspend fun createNewUserTodo(
        @Path("id") id: String,
        @Body todo: Todo
    ): Response<Todo?>
}