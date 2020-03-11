package com.uesleiramos.extratobancario.presentation.login

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import android.content.Intent
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.uesleiramos.extratobancario.R
import com.uesleiramos.extratobancario.presentation.dados.DetailsActivity
import com.uesleiramos.extratobancario.util.SharedPrefManager
import com.uesleiramos.extratobancario.util.Util

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val login = SharedPrefManager.getInstance(this).getUser()
        editUser.setText(login)
        btnLogar.setOnClickListener { btnLogar() }
    }

    private fun btnLogar() {
        showProgress()
        if (isValid()) {
            val viewModel: LoginViewModel =
                ViewModelProviders.of(this).get(LoginViewModel::class.java)

            viewModel.logar(editUser.text.toString(), editPassword.text.toString())
            viewModel.loginLiveDate.observe(this, Observer {
                if (it?.userId != null) {
                    SharedPrefManager.getInstance(this).saveUser(editUser.text.toString())
                    startActivity(
                        DetailsActivity.getStartIntent(this@LoginActivity,it)
                    )
                    finish()
                }
            })
        }
    }

    fun showProgress() {
        btnLogar.visibility = View.GONE
        login_progress_bar.visibility = View.VISIBLE
    }

    fun hideProgress() {
        btnLogar.visibility = View.VISIBLE
        login_progress_bar.visibility = View.GONE
    }

    fun isValid(): Boolean {
        if (!Util.validaUs(editUser, this) || !Util.validaSenha(editPassword, this)) {
            hideProgress()
            return false
        }
        return true
    }

    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }
}

