package com.uesleiramos.extratobancario.data.response

data class LoginResponse (
    val userId: Int?,
    val name: String?,
    val bankAccount: String?,
    val agency: String,
    val balance: Float?
)
