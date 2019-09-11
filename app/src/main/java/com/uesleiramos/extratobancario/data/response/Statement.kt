package com.uesleiramos.extratobancario.data.response

data class Statement(
    val title: String,
    val desc: String,
    val date: String,
    val value: Float
)