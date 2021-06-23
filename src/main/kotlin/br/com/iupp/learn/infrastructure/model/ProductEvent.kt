package br.com.iupp.learn.infrastructure.model

import java.math.BigDecimal

data class ProductEvent(
    var id: String = "",
    var nome: String = "",
    var descricao: String = "",
    var preco: BigDecimal = BigDecimal.ZERO,
    var emailDono: String = ""
)
