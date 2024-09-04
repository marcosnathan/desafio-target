package com.github.marcosnathan


fun main() {
    val entrada = readlnOrNull()?.toIntOrNull() ?: 0
    var base1 = 0
    var base2 = 1
    var sequencia = base1.toString()
    for (i in 1 ..< entrada) run {
        val tmpBase1 = base1
        base1 = base2
        base2 += tmpBase1
        if( base1 == entrada){
            println("$entrada pertence a sequência de fibonacci")
        }
        sequencia += " $base1"

    }
    println(sequencia)
}