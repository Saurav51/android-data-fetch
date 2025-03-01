package com.example.androiddatafetch

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddatafetch.client.ItemAdapter
import com.example.androiddatafetch.client.RetrofitClient
import com.example.androiddatafetch.data.Item
import com.example.androiddatafetch.utils.ItemProcessor.processItems
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchData()
    }

    private fun fetchData() {
        RetrofitClient.instance.getItems().enqueue(object : Callback<List<Item>> {
            override fun onResponse(call: Call<List<Item>>, response: Response<List<Item>>) {
                if (response.isSuccessful) {
                    val groupedItems = processItems(response.body())
                    adapter = ItemAdapter(groupedItems)
                    recyclerView.adapter = adapter
                } else {
                    Log.e("MainActivity", "API Response Failed")
                }
            }

            override fun onFailure(call: Call<List<Item>>, t: Throwable) {
                Log.e("MainActivity", "Error fetching data", t)
            }
        })
    }
}
