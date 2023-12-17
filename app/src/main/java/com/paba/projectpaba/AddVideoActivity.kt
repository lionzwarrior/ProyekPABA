package com.paba.projectpaba

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
import com.paba.projectpaba.getyoutubevideo.YoutubeApiService
import com.paba.projectpaba.getyoutubevideo.YoutubeResponse
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URL
import java.util.Timer
import java.util.TimerTask


class AddVideoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_video)
        val inputYoutubeVideoId = findViewById<EditText>(R.id.input_youtube_video_id)
        val submitVideoButton = findViewById<Button>(R.id.submit_video_button)

        submitVideoButton.setOnClickListener {
            if (inputYoutubeVideoId.text.isNotBlank()) {
                getVideoInfo(inputYoutubeVideoId.text.toString())
                Toast.makeText(this@AddVideoActivity, "Input Data Successfull", Toast.LENGTH_SHORT).show()
                runBlocking {
                    launch {
                        delay(3000)
                        val intent = Intent(this@AddVideoActivity, MainActivity::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        startActivity(intent)
                    }
                }

            } else {
                Toast.makeText(
                    this@AddVideoActivity,
                    "Youtube Video Id is empty",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    object apiClientYoutube {
        const val BASE_URL = "https://www.googleapis.com/youtube/v3/"

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService: YoutubeApiService = retrofit.create(YoutubeApiService::class.java)
    }

    private fun getVideoInfo(
        id: String
    ) {
        val call = apiClientYoutube.apiService.getVideoDetails(
            id,
            "AIzaSyA2bKoEV5-fNaI8ENenDhOMhiNcV8LjZRg",
            "snippet,statistics",
            "items(id,snippet,statistics)"
        )
        call.enqueue(object : Callback<YoutubeResponse> {
            override fun onResponse(
                call: Call<YoutubeResponse>,
                response: Response<YoutubeResponse>
            ) {
                if (response.isSuccessful){
                    val title = response.body()?.items?.get(0)?.snippet?.title
                    val image = response.body()?.items?.get(0)?.snippet?.thumbnails?.medium?.url
                    val description = response.body()?.items?.get(0)?.snippet?.description
                    MainActivity.videoArrayList.add(Video(title!!, image!!, description!!, id))
                }
            }
            override fun onFailure(call: Call<YoutubeResponse>, t: Throwable) {
                Log.d("DATA", t.printStackTrace().toString())
            }
        })
    }

}