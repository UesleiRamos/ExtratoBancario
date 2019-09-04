package com.uesleiramos.extratobancario.util

import android.content.Context
import android.widget.EditText
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.uesleiramos.extratobancario.R

object Util {
    @Throws(Exception::class)
    fun validaUs(edt: TextInputEditText, context: Context): Boolean {
        if (edt.text.toString().isEmpty()) {
            edt.error = context.resources.getString(R.string.valida_us)
            return false
        }
        val regexNumber = "^[0-9]+\$"

        if((regexNumber.toRegex().matches(edt.text.toString())
                    && edt.text.toString().length == 11)){
            return true
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(edt.text.toString()).matches()) {
            edt.error = context.resources.getString(R.string.preencha_cpf_email)
            return false
        }

        return true
    }

    /**
     * Validando senha
     */
    fun validaSenha(edt: TextInputEditText, context: Context): Boolean {
        if(edt.text.toString().isEmpty()) {
            edt.error = context.resources.getString(R.string.valida_senha)
            return false
        }

        val expSenha = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%]).{6,20})" //FORMATAÇÃO

        if(!expSenha.toRegex().matches(edt.text.toString())) {
            edt.error = context.resources.getString(R.string.valida_senha_format)
            return false
        }

        return true
    }

}