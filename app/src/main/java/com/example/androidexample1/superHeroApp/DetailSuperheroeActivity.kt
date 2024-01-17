package com.example.androidexample1.superHeroApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import androidx.core.view.isVisible
import com.example.androidexample1.R
import com.example.androidexample1.databinding.ActivityDetailSuperheroeBinding
import com.example.androidexample1.databinding.ActivitySuperHeroListBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type
import kotlin.math.roundToInt

class DetailSuperheroeActivity : AppCompatActivity() {
    companion object {
        const val ID_SH = "id_Superheroe"
    }

    private lateinit var binding: ActivityDetailSuperheroeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSuperheroeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id: String = intent.extras!!.getString(ID_SH, "No hay id")
        getSuperheroeInfo(id)
    }

    private fun getSuperheroeInfo(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse: Response<SuperheroeItemResponse> =
                getRetrofit().create(ApiService::class.java).getSuperheroeInfo(id)
            if (myResponse.body() != null) {
                runOnUiThread {
                    createUI(myResponse.body()!!)
                }
            }
        }

    }

    private fun createUI(body: SuperheroeItemResponse) {
        Picasso.get().load(body.image.url).into(binding.imDetailSuperheroeImage)
        binding.tvSuperheroeNameD.text = body.name
        binding.tvSuperheroeFullName.text = body.biography.fullName
        binding.tvPublisher.text = body.biography.publisher
        binding.tvSuperheroeAlignment.text = body.biography.alignment
        updateHeightPowerStats(binding.vStatIntelligence, body.powerstats.intelligence)
        updateHeightPowerStats(binding.vStatStrength, body.powerstats.strength)
        updateHeightPowerStats(binding.vStatSpeed, body.powerstats.speed)
        updateHeightPowerStats(binding.vStatDurability, body.powerstats.durability)
        updateHeightPowerStats(binding.vStatPower, body.powerstats.power)
        updateHeightPowerStats(binding.vStatCombat, body.powerstats.combat)
    }

    private fun updateHeightPowerStats(view: View, stat: String) {
        val params = view.layoutParams
        params.height = pxToDp(stat.toFloat())
        view.layoutParams = params
    }

    private fun pxToDp(px: Float): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, resources.displayMetrics).roundToInt()
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}