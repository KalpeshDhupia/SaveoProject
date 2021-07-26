package com.example.movielist.RecyclerViewHorizontal

import com.example.movielist.model.ResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("search/shows?q=god")
    fun getMovies(@Query("q") str: String): Call<List<ResponseModel>>
}