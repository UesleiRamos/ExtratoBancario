package com.uesleiramos.extratobancario.presenter.ipresenter

import android.content.Context
import com.uesleiramos.extratobancario.data.response.model.Login

interface IUsuarioPresenter {
    fun consultarUsuario(context: Context): Login?
}