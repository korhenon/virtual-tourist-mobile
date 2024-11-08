package com.example.virtualtourist.domain.serializers

data class WordVariants(
    val one: String,
    val two: String,
    val five: String
)

fun russianDeclension(n: Int, variants: WordVariants): String {
    return "$n " + if (n.mod(10) == 1 && n.mod(100) != 11) variants.one
    else if (n.mod(10) in 2..4 && (n.mod(100) < 10 || n.mod(100) >= 20)) variants.two
    else variants.five
}