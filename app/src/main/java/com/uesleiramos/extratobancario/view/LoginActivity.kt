package com.uesleiramos.extratobancario.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.uesleiramos.extratobancario.R
import com.uesleiramos.extratobancario.presentation.dados.DetailsActivity
import com.uesleiramos.extratobancario.presentation.dados.LoginViewModel
import com.uesleiramos.extratobancario.util.Util

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLogar.setOnClickListener { btnLogar() }
    }

    private fun btnLogar() {
        //if (!Util.validaUs(editUser, this)) return
        //if (!Util.validaSenha(editPassword, this)) return

        val viewModel: LoginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        viewModel.logar(editUser.toString(), editPassword.toString())
        viewModel.loginLiveDate.observe(this, Observer {
            it?.let { login ->

                val intent = Intent(this, DetailsActivity::class.java)
                intent.putExtra("usuario", login)
                startActivity(intent)
            }
        })
    }
}
