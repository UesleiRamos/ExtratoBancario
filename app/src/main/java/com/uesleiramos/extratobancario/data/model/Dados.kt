package com.uesleiramos.extratobancario.data.response.model

import java.io.Serializable

class Dados : Serializable {
    constructor(title: String?, desc: String?, date: String?, value: Float?) {
        this.title = title
        this.desc = desc
        this.date = date
        this.value = value
    }

    var title: String? = null
    var desc: String? = null
    var date: String? = null
    var value: Float? = null

}