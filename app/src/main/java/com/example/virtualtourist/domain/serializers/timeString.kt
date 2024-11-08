package com.example.virtualtourist.domain.serializers

fun Int.timeString(): String {
    return if (this < 60) russianDeclension(
        this,
        WordVariants("минута", "минуты", "минут")
    )
    else if (this.mod(60) == 0) russianDeclension(
        this / 60,
        WordVariants("час", "часа", "часов")
    )
    else russianDeclension(
        this / 60,
        WordVariants("час", "часа", "часов")
    ) + " " + russianDeclension(
        this.mod(60),
        WordVariants("минута", "минуты", "минут")
    )
}