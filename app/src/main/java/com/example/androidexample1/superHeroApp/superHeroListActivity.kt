package com.example.androidexample1.superHeroApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidexample1.R
import com.example.androidexample1.databinding.ActivitySuperHeroListBinding
import com.example.androidexample1.superHeroApp.DetailSuperheroeActivity.Companion.ID_SH
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class superHeroListActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySuperHeroListBinding
    private lateinit var retrofit: Retrofit
    private lateinit var adapter: SuperheroeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuperHeroListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit = getRetrofit()
        initUI()
    }

    private fun initUI() {
        binding.svSearch.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchName(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(p0: String?) = false
        })
        adapter = SuperheroeAdapter(){idSuperheroe->getInfoSuperheroe(idSuperheroe)}
        binding.rvSuperheroes.setHasFixedSize(true)
        binding.rvSuperheroes.layoutManager = LinearLayoutManager(this)
        binding.rvSuperheroes.adapter = adapter


    }

        private fun searchName(query: String) {
        binding.progressBar.isVisible = true
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse = retrofit.create(ApiService::class.java).getSuperheroes(query)
            if (myResponse.isSuccessful) {
                Log.i("Aylin", "funciona")
                val response: SuperheroeDataResponse? = myResponse.body()
                if (response != null) {
                    Log.i("Aylin", response.toString())
                    runOnUiThread {
                        adapter.updateList(response.results)
                        binding.progressBar.isVisible = false
                    }

                }
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

    private fun getInfoSuperheroe(id: String){
        val intent= Intent(this,DetailSuperheroeActivity::class.java)
        intent.putExtra(ID_SH,id)
        startActivity(intent)
    }
}


