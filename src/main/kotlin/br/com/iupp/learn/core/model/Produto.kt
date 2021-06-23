package br.com.iupp.learn.core.model

import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

import javax.validation.constraints.NotNull

data class Produto (
    val id: String = "",
    val nome: String = "",
    val descricao: String= "",
    val preco: BigDecimal = BigDecimal.ZERO,
    val emailDono: String = ""
    )
