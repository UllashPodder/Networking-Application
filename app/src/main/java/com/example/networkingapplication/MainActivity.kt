package com.example.networkingapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.networkingapplication.APIclient.ApiClient
import com.example.networkingapplication.model.PostManResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var responseView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        responseView = findViewById(R.id.responseView)
        responseView.text = "loading..."
        executeCall()
    }
    private fun executeCall() {
        val call: Call<PostManResponseModel> = ApiClient.apiService
            .getPostResponse("dummy param value")

        call.enqueue(object : Callback<PostManResponseModel?> {
            override fun onResponse(
                call: Call<PostManResponseModel?>,
                response: Response<PostManResponseModel?>
            ) {
                val responseObj = response.body()
                responseView.setText(responseObj!!.json.param1)
            }

            override fun onFailure(call: Call<PostManResponseModel?>, t: Throwable) {
                responseView.setText("Responnse failed")
            }
        })

//        launch(Dispatchers.Main) {
//            try {
//                val response = ApiClient.apiService.getPostResponse("dummy param value")
//
//                if (response.isSuccessful && response.body() != null) {
//                    val content = response.body()
//                    //do something
//                } else {
//                    Toast.makeText(
//                        this@MainActivity,
//                        "Error Occurred: ${response.message()}",
//                        Toast.LENGTH_LONG
//                    ).show()
//                }
//
//            } catch (e: Exception) {
//                Toast.makeText(
//                    this@MainActivity,
//                    "Error Occurred: ${e.message}",
//                    Toast.LENGTH_LONG
//                ).show()
//            }
//        }
    }
}