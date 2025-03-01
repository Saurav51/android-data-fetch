package com.example.androiddatafetch.api
import com.example.androiddatafetch.data.Item
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("hiring.json")
    fun getItems(): Call<List<Item>>
}
