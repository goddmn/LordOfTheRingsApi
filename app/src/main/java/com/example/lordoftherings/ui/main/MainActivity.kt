package com.example.lordoftherings.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lordoftherings.App
import com.example.lordoftherings.R
import com.example.lordoftherings.model.LotrModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val service = App().getAppInstance(this).getRetrofitService()
        val call = service?.getMovie()
        call?.enqueue(object : Callback<LotrModel> {
            override fun onFailure(call: Call<LotrModel>, t: Throwable) {}

            override fun onResponse(call: Call<LotrModel>, response: Response<LotrModel>) {

            }
        })
    }
}