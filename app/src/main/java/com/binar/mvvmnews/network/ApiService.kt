package com.binar.mvvmnews.network

import com.binar.mvvmnews.model.GetAllNewsResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("news/")
    fun getAllNews() : Call<List<GetAllNewsResponse>>
}