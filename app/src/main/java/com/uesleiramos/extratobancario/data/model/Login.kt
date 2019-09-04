package com.uesleiramos.extratobancario.data.response.model

import java.io.Serializable

class Login : Serializable  {
    constructor(userId: Int?, name: String?, bankAccount: String?, agency: String?, balance: Float?) {
        this.userId = userId
        this.name = name
        this.bankAccount = bankAccount
        this.agency = agency
        this.balance = balance
    }

    var userId: Int? = null
    var name: String? = null
    var bankAccount: String? = null
    var agency: String? = null
    var balance: Float? = null
}