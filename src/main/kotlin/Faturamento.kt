package com.github.marcosnathan

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json


//Classe que define cada item do array do JSON
@Serializable
data class Movimentacao(
    val dia: Int,
    val valor: Double,
)

fun main() {
    // pega o arquivo dentro da pasta resources do projeto
     val inputStream = Thread
         .currentThread()
         .contextClassLoader
         .getResourceAsStream("dados.json")

    // converte o InputStrem para um BufferedReader
    val bufferedReader = inputStream!!.bufferedReader(Charsets.UTF_8)

    // ler o arquivo e converte em um array de Movimentacao
    var faturamentos: Array<Movimentacao> = bufferedReader
        .readLines()
        .joinToString("\n")
        .let {
            Json.decodeFromString<Array<Movimentacao>>(it)
        }

    // remove dias que não houve faturamento e pega o mínimo
    val menorMovimentacao = faturamentos
        .filter { it.valor.toInt() != 0 }
        .minBy { it.valor }

    println("O dia de menor faturamento foi: Dia ${menorMovimentacao.dia} R$${"%.2f".format(menorMovimentacao.valor)}")

    // remove dias que não houve faturamento e pega o máximo
    val maiorMovimentacao = faturamentos
        .filter { it.valor.toInt() != 0 }
        .maxBy { it.valor }

    println("O dia de maior faturamento foi: Dia ${maiorMovimentacao.dia} R$${"%.2f".format(maiorMovimentacao.valor)}")

    //remove os dias que não houve faturamento
    faturamentos = faturamentos
        .filter { it.valor.toInt() != 0 }
        .toTypedArray()

    val totalFaturamento = faturamentos
        .sumOf { it.valor }
    println("Total faturamento: R$${"%.2f".format(totalFaturamento)}")

    val quantidadeDias = faturamentos.size
    println("Quantidade de dias com faturamento: $quantidadeDias")

    val mediaFaturamento = totalFaturamento / quantidadeDias
    println("Média de faturamento: R$${"%.2f".format(mediaFaturamento)}")

    val diasFaturamentoAcima = faturamentos
        .count { it.valor >= mediaFaturamento }

    println("Quantidade de dias faturamento acima da média: $diasFaturamentoAcima")

}