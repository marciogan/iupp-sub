package br.com.iupp.learn.database.repository

import br.com.iupp.learn.database.entity.ProdutoEntity
import java.util.*

interface ProdutoRepository {
    fun create(produtoEntity: ProdutoEntity)
    fun delete(id: UUID)
    fun update(produtoEntity: ProdutoEntity)
}