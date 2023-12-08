package com.example.retrofitapplication.ACTIVITY

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.retrofitapplication.R
import com.example.retrofitapplication.RESPONSE.RetrofitResponseItem
import com.example.retrofitapplication.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {
    lateinit var Binding: ActivityMainBinding
    var id: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        Binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(Binding.root)
        intview()
    }

    private fun intview() {
        if(intent!== null)
        {
            var id = intent.getStringExtra("id").toString()
            var title = intent.getStringExtra("title").toString()
            var albumId = intent.getStringExtra("albumId").toString()


            Binding.txtId.text=id
            Binding.txtuserId.text=albumId
            Binding.txtTitle.text=title

        }
    }
}