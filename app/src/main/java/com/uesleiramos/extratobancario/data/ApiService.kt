package com.uesleiramos.extratobancario.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
    private fun iniRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://bank-app-test.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val service = iniRetrofit().create(EBServices::class.java)
}