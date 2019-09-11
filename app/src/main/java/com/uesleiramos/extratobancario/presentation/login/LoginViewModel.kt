package com.uesleiramos.extratobancario.presentation.login

import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.uesleiramos.extratobancario.data.ApiService
import com.uesleiramos.extratobancario.data.response.model.Login
import com.uesleiramos.extratobancario.data.response.LoginResponse

class LoginViewModel : ViewModel() {
    val loginLiveDate: MutableLiveData<Login> = MutableLiveData()

    fun logar(user: String, password: String) {
        ApiService.service.getUsuario(user, password).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                val responseLogin = response.body()
                if (response.isSuccessful) {

                    val login = Login(
                        userId = responseLogin?.userAccount?.userId,
                        name = responseLogin?.userAccount?.name,
                        bankAccount = responseLogin?.userAccount?.bankAccount,
                        agency = responseLogin?.userAccount?.agency,
                        balance = responseLogin?.userAccount?.balance
                    )
                    loginLiveDate.value = login
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
            }
        })
    }
}