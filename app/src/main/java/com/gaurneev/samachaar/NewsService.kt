package com.gaurneev.samachaar

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//https://newsapi.org/v2/top-headlines?country=in&apiKey=730147897b9241d68eb47358f0476272
//https://newsapi.org/v2/everything?q=apple&from=2023-04-03&to=2023-04-03&sortBy=popularity&apiKey=730147897b9241d68eb47358f0476272

const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "730147897b9241d68eb47358f0476272"
interface NewsInterface{

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadlines(@Query("country") country: String, @Query("page") Page: Int) : Call<news>
}

object NewsService {
    val newsInstance: NewsInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}