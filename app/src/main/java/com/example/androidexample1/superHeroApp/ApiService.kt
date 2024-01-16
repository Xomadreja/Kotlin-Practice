package com.example.androidexample1.superHeroApp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET ("/api/6755639911213240/search/{name}")
    suspend fun getSuperheroes(@Path("name") SuperheroeName: String): Response<SuperheroeDataResponse>
    @GET ("/api/6755639911213240/{id}")
    suspend fun getSuperheroeInfo(@Path("id") Superheroeid: String): Response<SuperheroeItemResponse>
}