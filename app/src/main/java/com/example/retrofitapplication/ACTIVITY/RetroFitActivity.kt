package com.example.retrofitapplication.ACTIVITY

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitapplication.INTREFACE.ProductIntreface
import com.example.retrofitapplication.OBJECT.RetrofitHelper
import com.example.retrofitapplication.ADAPTER.RetrofitAdapter
import com.example.retrofitapplication.databinding.ActivityRetroFitBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RetroFitActivity : AppCompatActivity() {
    lateinit var binding: ActivityRetroFitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRetroFitBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initview()
    }

    private fun initview() {


        binding.btnClick.setOnClickListener {

            val Procuteapi = RetrofitHelper.getInstance().create(ProductIntreface::class.java)
            // launching a new coroutine
            GlobalScope.launch {
                val result = Procuteapi.getProduct()
                if (result != null) {
                    // Checking the results
                    Log.e("TAG", "initview data: " + result)
                }


                runOnUiThread {


                    var adapter = RetrofitAdapter(
                        this@RetroFitActivity,
                        result,
                        onclick = { id, title, albumId ->
                            val i = Intent(this@RetroFitActivity, MainActivity::class.java)
                            i.putExtra("id", id)
                            i.putExtra("title", title)
                            i.putExtra("albumId", albumId)

                            startActivity(i)


                        })

                    var manager =
                        LinearLayoutManager(this@RetroFitActivity, RecyclerView.VERTICAL, false)
                    binding.rcv.adapter = adapter
                    binding.rcv.layoutManager = manager


                }


            }

        }

    }
}

