package com.uesleiramos.extratobancario.presentation.dados

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uesleiramos.extratobancario.R
import com.uesleiramos.extratobancario.data.response.model.Login
import com.uesleiramos.extratobancario.presentation.login.LoginActivity
import com.uesleiramos.extratobancario.util.Util
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        btnLogout.setOnClickListener { logout() }
        showProgress()
        init()
    }

    fun init() {
        val login = intent.extras.getSerializable(EXTRA_USER) as Login
        val viewModel: DadosViewModel = ViewModelProviders.of(this).get(DadosViewModel::class.java)

        viewModel.loginLiveDate.observe(this, Observer {
            txtnome.text = it.name
            txtConta.text = Util.formatAccountAgency(it?.bankAccount, it?.agency)
            txtSaldo.text = Util.formatMoeda(it.balance)
        })
        viewModel.getUsuario(login)

        viewModel.dadosLiveDate.observe(this, Observer {
            it?.let { dados ->
                with(recyclerDados) {
                    layoutManager = LinearLayoutManager(
                        this@DetailsActivity,
                        RecyclerView.VERTICAL,
                        false
                    )
                    setHasFixedSize(true)
                    adapter = DetailsAdapter(dados)
                }
            }
        })
        viewModel.getDados()
        hideProgress()
    }

    companion object {
        private const val EXTRA_USER = "USER"
        fun getStartIntent(context: Context, login: Login): Intent {
            return Intent(context, DetailsActivity::class.java).apply {
                putExtra(EXTRA_USER, login)
            }
        }
    }

    fun logout() {
        startActivity(LoginActivity.getStartIntent(this@DetailsActivity))
        finish()
    }

    fun showProgress() {
        recyclerDados.visibility = View.GONE
        detalhe_progress_bar.visibility = View.VISIBLE
    }

    fun hideProgress() {
        recyclerDados.visibility = View.VISIBLE
        detalhe_progress_bar.visibility = View.GONE
    }
}