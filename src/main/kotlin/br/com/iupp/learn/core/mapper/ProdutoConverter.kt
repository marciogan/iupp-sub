package br.com.iupp.learn.core.mapper

import br.com.iupp.learn.core.model.Produto
import br.com.iupp.learn.database.entity.ProdutoEntity
import br.com.iupp.learn.infrastructure.model.ProductEvent
import javax.inject.Singleton

@Singleton
class ProdutoConverter {

    companion object{

        fun produtoToProdutoEntity(produto: Produto) =
            ProdutoEntity(produto.id, produto.nome, produto.descricao, produto.preco, produto.emailDono)

        fun produtoEventToProduto(produtoEvent: ProductEvent) =
            Produto(produtoEvent.id, produtoEvent.nome,produtoEvent.descricao,produtoEvent.preco,produtoEvent.emailDono)
    }
}