package com.example.linacodingchallenge

import android.app.IntentService
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.util.Log.d
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab.setOnClickListener { view ->
            addDevice()
            Snackbar.make(
                view,
                "An exciting message!",
                Snackbar.LENGTH_LONG

            ).setAction("Action", null).show()

            //val intent = Intent(this,AddDevice::class.java)
            //startActivity(intent)
        }


        val retrofit = Retrofit.Builder()
            //.baseUrl("http://private-1cc0f-devicecheckout.apiary-mock.com")
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(APIService::class.java)
        //println(api)
        api.fetchAllUsers().enqueue(object : Callback<List<User>> {

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                //d("Lina","onResponse: ${response.body()!![0].device}")
                showData(response.body())


            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                d("Lina", "Response error!!")

            }


        })


    }

    private fun addDevice() {
        val intent = Intent(this,AddDevice::class.java)
        startActivity(intent)
    }

    private fun showData(users: List<User>?) {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = UsersAdapter(users!!)


        }




    }
}