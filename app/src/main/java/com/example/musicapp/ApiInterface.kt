package com.example.musicapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {
   @Headers("X-RapidAPI-Key: 212846886cmshf8f3b1e22940c14p1372dfjsn769195f279cd","X-RapidAPI-Host: deezerdevs-deezer.p.rapidapi.com")
    @GET("search")
    fun getData(@Query("q") query: String):Call<DeezerData>

}