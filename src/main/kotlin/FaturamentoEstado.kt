package com.github.marcosnathan

fun main(){
    val sp = 67836.43
    val rj = 36678.66
    val mg = 29229.88
    val es = 27165.48
    val outros = 19849.53
    val total = sp + rj + mg + es + outros
    println("O valor total é R$${"%.2f".format(total)}")
    println("SP = %.2f".format((sp / total) * 100) + "%")
    println("RJ = %.2f".format((rj / total) * 100) + "%")
    println("MG = %.2f".format((mg / total) * 100) + "%")
    println("ES = %.2f".format((es / total) * 100) + "%")
    println("Outros = %.2f".format((outros / total) * 100) + "%")
}