package com.uesleiramos.extratobancario.data

import com.uesleiramos.extratobancario.data.response.LoginResponse
import com.uesleiramos.extratobancario.data.response.StatementsResponse
import retrofit2.Call
import retrofit2.http.*

interface EBServices {
    @GET("statements/1")
    fun getDados(): Call<StatementsResponse>

    @FormUrlEncoded
    @POST("login")
    fun getUsuario(
        @Field("user") user: String,
        @Field("password") password: String
    ): Call<LoginResponse>
}