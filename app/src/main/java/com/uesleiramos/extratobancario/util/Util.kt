package com.uesleiramos.extratobancario.util

import android.content.Context
import java.util.*
import java.text.DecimalFormat
import com.uesleiramos.extratobancario.R
import com.google.android.material.textfield.TextInputEditText

object Util {
    @Throws(Exception::class)
    fun validaUs(edt: TextInputEditText, context: Context): Boolean {
        if (edt.text.toString().isEmpty()) {
            edt.error = context.resources.getString(R.string.valida_us)
            return false
        }
        val regexNumber = "^[0-9]+\$"

        if ((regexNumber.toRegex().matches(edt.text.toString())
                    && edt.text.toString().length == 11)
        ) {
            return true
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(edt.text.toString()).matches()) {
            edt.error = context.resources.getString(R.string.preencha_cpf_email)
            return false
        }

        return true
    }

    fun validaSenha(edt: TextInputEditText, context: Context): Boolean {
        if (edt.text.toString().isEmpty()) {
            edt.error = context.resources.getString(R.string.valida_senha)
            return false
        }

        val expSenha = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%]).{6,20})"

        if (!expSenha.toRegex().matches(edt.text.toString())) {
            edt.error = context.resources.getString(R.string.valida_senha_format)
            return false
        }

        return true
    }

    fun formatMoeda(valor: Float?): String {
        val formatBr = DecimalFormat.getCurrencyInstance(Locale("pt", "br"))
        return formatBr.format(valor)
    }

    fun formatDate(date: String): String {
        val a_date = date.split("-".toRegex()).dropLastWhile({ it.isEmpty() }).toTypedArray()
        return a_date[2] + "/" + a_date[1] + "/" + a_date[0]
    }

    fun formatAccountAgency(account: String?, agency: String?): String {
        val contaFormatada =
            agency?.substring(0, 2) + '.'.toString() +
                    agency?.substring(2, 7) + '-'.toString() +
                    agency?.substring(8, 9)
        return "$account / $contaFormatada"

    }
}