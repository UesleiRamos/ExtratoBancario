package com.uesleiramos.extratobancario.presenter

import android.content.Context
import com.google.gson.Gson
import com.uesleiramos.extratobancario.data.response.model.Login
import com.uesleiramos.extratobancario.presenter.ipresenter.IUsuarioPresenter

class UsuarioPresenter : IUsuarioPresenter {
    var PREFS_LOGIN_DADOS: String = "prefs_usuario_dados"

    override fun consultarUsuario(context: Context): Login? {
        val prefs = context.getSharedPreferences(null, Context.MODE_PRIVATE)
        val json = prefs.getString(PREFS_LOGIN_DADOS, "")
        return Gson().fromJson(json, Login::class.java)
    }
}