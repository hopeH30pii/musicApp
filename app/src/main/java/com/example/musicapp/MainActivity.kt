package com.example.musicapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var myRecyclerView:RecyclerView
    lateinit var myAdapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myRecyclerView=findViewById(R.id.recyclerView)
        val retrofitBuilder=Retrofit.Builder() //building my retrofit
            .baseUrl("https://deezerdevs-deezer.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)   //passing created api - interface
           val retrofitData=retrofitBuilder.getData("eminem")//value that holds the data
        //pick up data using enqueue method  ctr+shift+space
        retrofitData.enqueue(object : Callback<DeezerData?> {
            override fun onResponse(call: Call<DeezerData?>, response: Response<DeezerData?>) {
                //if API call is success then it is executed
                val dataList=response.body()?.data!!
                myAdapter= MyAdapter(this@MainActivity,dataList)
                myRecyclerView.adapter=myAdapter
                myRecyclerView.layoutManager=LinearLayoutManager(this@MainActivity)
                Log.d("TAG:onResponse ","onResponse: " + response.body())

            }

            override fun onFailure(call: Call<DeezerData?>, t: Throwable) {
                //if API call is a failure then it is not executed
                Log.d("TAG:onFailure ","onFailure: "+ t.message)

            }
        })
    }
}


