package com.example.virtualtourist.ui.utils

import com.example.virtualtourist.data.sources.network.model.UserRoute

private fun russianDeclension(n: Int, variants: List<String>): String {
    return "$n " + if (n.mod(10) == 1 && n.mod(100) != 11) variants[0]
    else if (n.mod(10) in 2..4 && (n.mod(100) < 10 || n.mod(100) >= 20)) variants[1]
    else variants[2]
}

fun UserRoute.timeString(): String {
    return if (this.time < 60) russianDeclension(
        this.time,
        listOf("минута", "минуты", "минут")
    )
    else if (this.time.mod(60) == 0) russianDeclension(
        this.time / 60,
        listOf("час", "часа", "часов")
    )
    else russianDeclension(
        this.time / 60,
        listOf("час", "часа", "часов")
    ) + " " + russianDeclension(
        this.time.mod(60),
        listOf("минута", "минуты", "минут")
    )
}