package br.com.iupp.learn.core.service

import br.com.iupp.learn.core.model.Produto

import br.com.iupp.learn.core.mapper.ProdutoConverter
import br.com.iupp.learn.core.port.ProdutoRepositoryPort
import br.com.iupp.learn.core.port.ProdutoServicePort
import org.slf4j.LoggerFactory
import java.util.*
import javax.inject.Singleton

@Singleton
class ProdutoService(private val produtoRepositoryPort: ProdutoRepositoryPort): ProdutoServicePort {

    override fun create(produto: Produto) {
        produtoRepositoryPort.create(ProdutoConverter.produtoToProdutoEntity(produto))
    }

    override fun delete(id:UUID) {
        produtoRepositoryPort.delete(id)
    }

    override fun update(produto: Produto) {
        produtoRepositoryPort.update(ProdutoConverter.produtoToProdutoEntity(produto))
    }
}
