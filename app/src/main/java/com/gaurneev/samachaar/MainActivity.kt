package com.gaurneev.samachaar

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var adapter: newsAdapter
    private var pageNum = 1
    var totalResults = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getNews()
    }

    private fun getNews() {
        val news = NewsService.newsInstance.getHeadlines("in",pageNum)
        news.enqueue(object: Callback<news>{
            override fun onResponse(call: Call<news>, response: Response<news>) {
                val news = response.body()
                if (news !=null){
                    Log.d("neevgaur", news.toString())
                    adapter = newsAdapter(this@MainActivity, news.articles)
                    newsList.adapter = adapter
                    newsList.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }

            override fun onFailure(call: Call<news>, t: Throwable) {
                Log.d("neevgaur","Loading news failure",t)
            }
        })
    }
}