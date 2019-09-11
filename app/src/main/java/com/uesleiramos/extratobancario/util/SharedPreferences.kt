package com.uesleiramos.extratobancario.util

import android.annotation.SuppressLint
import android.content.Context

class SharedPrefManager(var mCtx: Context) {
    val SHARED_PREF_USUARIO = "SHARED_PREF_USUARIO"
    val LOGIN = "login"

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var mInstance: SharedPrefManager

        fun getInstance(mCtx: Context): SharedPrefManager {
            mInstance = SharedPrefManager(mCtx)
            return mInstance
        }
    }

    fun saveUser(login: String) {
        val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_USUARIO, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(LOGIN, login)
        editor.apply()
    }

    fun getUser(): String? {
        val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_USUARIO, Context.MODE_PRIVATE)
        return sharedPreferences.getString(LOGIN, null)
    }
}