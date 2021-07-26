package com.example.movielist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movielist.RecyclerViewHorizontal.ApiClient
import com.example.movielist.RecyclerViewHorizontal.HorizontalAdapter
import com.example.movielist.RecyclerViewHorizontal.Network
import com.example.movielist.model.ResponseModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val listOfMovies = mutableListOf<ResponseModel>()
    val str = "god"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        callApi()
    }

    private fun callApi() {
        val apiClient = Network.getInstance().create(ApiClient::class.java)
        val call = apiClient.getMovies(str)
        call.enqueue(object : Callback<List<ResponseModel>> {
            override fun onResponse(
                call: Call<List<ResponseModel>>,
                response: Response<List<ResponseModel>>
            ) {
                if (response.body() != null) {
                    response.body()?.let {
                        buildData(it)
                    }
                }
            }

            override fun onFailure(call: Call<List<ResponseModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun buildData(list: List<ResponseModel>) {
        val layoutManager = GridLayoutManager(this@MainActivity, 3)
        rvHorizontal.layoutManager = layoutManager
        val horizontalAdapter = HorizontalAdapter(list)
        rvHorizontal.adapter = horizontalAdapter

    }
}
