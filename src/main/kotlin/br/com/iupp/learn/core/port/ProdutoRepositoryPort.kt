package br.com.iupp.learn.core.port

import br.com.iupp.learn.database.entity.ProdutoEntity
import java.util.*
import javax.inject.Singleton

@Singleton
interface  ProdutoRepositoryPort {
    fun create(produtoEntity: ProdutoEntity)
    fun delete(id: UUID)
    fun update(produtoEntity: ProdutoEntity)
}