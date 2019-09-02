package com.uesleiramos.extratobancario.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import android.content.Intent
import com.uesleiramos.extratobancario.R
import com.uesleiramos.extratobancario.presenter.UsuarioPresenter

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLogar.setOnClickListener { btnLogar() }
    }

    private fun btnLogar() {
//        val usuario = UsuarioPresenter().consultarUsuario(this)
//        if (usuario != null) {
            val intent = Intent(this, DetailsActivity::class.java)
            startActivity(intent)
       // }
    }
}
