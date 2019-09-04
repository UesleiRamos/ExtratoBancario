package com.uesleiramos.extratobancario.presentation.dados

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.uesleiramos.extratobancario.data.ApiService
import com.uesleiramos.extratobancario.data.response.StatementsResponse
import com.uesleiramos.extratobancario.data.response.model.Dados
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DadosViewModel : ViewModel() {

    val dadosLiveDate: MutableLiveData<List<Dados>> = MutableLiveData()

    fun getDados() {
        //dadosLiveDate.value = createFakeDados()
        ApiService.service.getDados().enqueue(object : Callback<StatementsResponse> {
            override fun onResponse(
                call: Call<StatementsResponse>,
                response: Response<StatementsResponse>
            ) {
                if (response.isSuccessful) {
                    val dados: MutableList<Dados> = mutableListOf()
                    response.body()?.let { StatementsResponse ->
                        for (result in StatementsResponse.statementList) {
                            val dado: Dados = Dados(
                                title = result.title,
                                desc = result.desc,
                                date = result.date,
                                value = result.value
                            )
                            dados.add(dado)
                        }
                        dadosLiveDate.value = dados
                    }
                }
            }

            override fun onFailure(call: Call<StatementsResponse>, t: Throwable) {

            }
        })
    }
}