package com.example.demoapplication.data.api

import com.example.demoapplication.data.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UserApi {

    @GET("users")
    suspend fun getAllUsers(@Query("page") page: String, @Query("per_page") perPage: String = "10"): Response<MutableList<User>?>

    @POST("users")
    suspend fun createUser(@Body user: User): Response<User?>
}