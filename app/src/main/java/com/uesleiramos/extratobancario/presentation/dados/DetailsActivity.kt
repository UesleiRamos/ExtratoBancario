package com.uesleiramos.extratobancario.presentation.dados

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uesleiramos.extratobancario.R
import com.uesleiramos.extratobancario.data.response.model.Login
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val login = getIntent().getExtras().getSerializable("usuario") as? Login

        val viewModel: DadosViewModel = ViewModelProviders.of(this).get(DadosViewModel::class.java)

        viewModel.dadosLiveDate.observe(this, Observer {
            it?.let { dados ->
                with(recyclerDados) {
                    layoutManager =
                        LinearLayoutManager(this@DetailsActivity,RecyclerView.VERTICAL,false
                    )
                    setHasFixedSize(true)
                    adapter = DetailsAdapter(dados)
                }
            }
        })
        viewModel.getDados()
    }
}