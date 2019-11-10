package com.example.linacodingchallenge

import retrofit2.Call
import retrofit2.http.GET

interface APIService{
    @GET("/users")
    fun fetchAllUsers(): Call<List<User>>
}