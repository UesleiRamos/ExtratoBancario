package com.uesleiramos.extratobancario.presentation.dados

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.uesleiramos.extratobancario.data.ApiService
import com.uesleiramos.extratobancario.data.response.LoginResponse
import com.uesleiramos.extratobancario.data.response.model.Login
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {
    val loginLiveDate: MutableLiveData<Login> = MutableLiveData()

    fun logar(user: String, password: String) {
        ApiService.service.getUsuario(user, password).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val login: Login = Login(
                        userId = response.body()?.userId,
                        name = response.body()?.name,
                        bankAccount = response.body()?.bankAccount,
                        agency = response.body()?.agency,
                        balance = response.body()?.balance
                    )
                    loginLiveDate.value = login
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
            }
        })
    }
}