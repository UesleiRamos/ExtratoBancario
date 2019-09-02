package com.uesleiramos.extratobancario.presenter.ipresenter

import android.content.Context
import com.uesleiramos.extratobancario.model.Usuario

interface IUsuarioPresenter {
    fun consultarUsuario(context: Context): Usuario?
}