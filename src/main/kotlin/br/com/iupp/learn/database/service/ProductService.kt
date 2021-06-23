package br.com.iupp.learn.database.service

import br.com.iupp.learn.core.port.ProdutoRepositoryPort
import br.com.iupp.learn.database.entity.ProdutoEntity
import br.com.iupp.learn.database.repository.ProdutoRepository
import java.util.*
import javax.inject.Singleton

@Singleton
class ProductService(private val produtoRepository: ProdutoRepository) : ProdutoRepositoryPort {

    override fun create(produtoEntity: ProdutoEntity) {
        produtoRepository.create(produtoEntity)
    }

    override fun delete(id: UUID) {
        produtoRepository.delete(id)
    }

    override fun update(produtoEntity: ProdutoEntity) {
        produtoRepository.update(produtoEntity)
    }
}
