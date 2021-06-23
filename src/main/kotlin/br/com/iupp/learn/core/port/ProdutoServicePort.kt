package br.com.iupp.learn.core.port

import br.com.iupp.learn.core.model.Produto
import java.util.*
import javax.inject.Singleton

@Singleton
interface ProdutoServicePort {
    fun create(produto: Produto)
    fun delete(id: UUID)
    fun update(produto: Produto)
}