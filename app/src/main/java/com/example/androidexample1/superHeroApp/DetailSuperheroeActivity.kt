package com.example.androidexample1.superHeroApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import com.example.androidexample1.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailSuperheroeActivity : AppCompatActivity() {
    companion object{
        const val ID_SH = "id_Superheroe"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_superheroe)
        val id:String = intent.extras!!.getString(ID_SH,"No hay id")
        getSuperheroeInfo(id)
    }

    private fun getSuperheroeInfo(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse: Response<SuperheroeItemResponse> = getRetrofit().create(ApiService::class.java).getSuperheroeInfo(id)
            if (myResponse.isSuccessful) {
                Log.i("Aylin", "funciona")
//                val response: SuperheroeDetailResponse  ? = myResponse.body()
//                if (response != null) {
//                    Log.i("Aylin", response.toString())
////                    runOnUiThread {
////                        adapter.updateList(response.results)
//                    }
//                }
            } else {
                Log.i("Aylin", "NO funciona")
            }
        }

    }

    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}