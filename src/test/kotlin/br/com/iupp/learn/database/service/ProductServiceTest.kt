package br.com.iupp.learn.database.service

import br.com.iupp.learn.core.model.Produto
import br.com.iupp.learn.database.entity.ProdutoEntity
import br.com.iupp.learn.database.repository.ProdutoRepository
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.math.BigDecimal
import java.util.*

@MicronautTest
class ProductServiceTest : AnnotationSpec(){

    val service = mockk<ProdutoRepository>()
    val produtoService = ProductService(service)

    companion object{
        val produtoEntity = ProdutoEntity(UUID.randomUUID().toString(),"produto1","descricao", BigDecimal.ZERO,"teste@teste.com")
    }

    @Test
    fun `deve criar um produto`(){

        every{service.create(any()) } answers {}
        val result = produtoService.create(produtoEntity)

        result shouldBe Unit
    }

    @Test
    fun `deve atualizar um produto`(){

        every{service.update(any()) } answers {}
        val result = produtoService.update(produtoEntity)

        result shouldBe Unit
    }

    @Test
    fun `deve deletar um produto`(){

        every{service.delete(any()) } answers {}
        val result = produtoService.delete(UUID.randomUUID())

        result shouldBe Unit
    }
}