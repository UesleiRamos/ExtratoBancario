package com.uesleiramos.extratobancario.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uesleiramos.extratobancario.R
import com.uesleiramos.extratobancario.model.Dados
import kotlinx.android.synthetic.main.activity_details.*
import java.text.NumberFormat

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        with(recyclerDados) {
            layoutManager = LinearLayoutManager(this@DetailsActivity, RecyclerView.VERTICAL, false)
            setHasFixedSize(true)
            adapter = DetailsAdapter(getDados())
        }
    }

    fun getDados(): List<Dados> {
        return listOf(
                Dados("Pagamento 1", "Conta de Luz", "10/10/2010", 1000F),
                Dados("Pagamento 2", "Conta de Água", "10/10/2011", 1000F),
                Dados("Pagamento 3", "Conta de Gás", "10/10/2012", 1000F),
                Dados("Pagamento 4", "Conta de Gás", "10/10/2012", 1000F),
                Dados("Pagamento 5", "Conta de Gás", "10/10/2012", 1000F),
                Dados("Pagamento 6", "Conta de Gás", "10/10/2012", 1000F),
                Dados("Pagamento 7", "Conta de Gás", "10/10/2012", 1000F),
                Dados("Pagamento 8", "Conta de Gás", "10/10/2012", 1000F),
                Dados("Pagamento 9", "Conta de Gás", "10/10/2012", 1000F),
                Dados("Pagamento 10", "Conta de Gás", "10/10/2012", 1000F)
        )
    }
}