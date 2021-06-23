package br.com.iupp.learn.core.service

import br.com.iupp.learn.core.model.Produto
import br.com.iupp.learn.core.port.ProdutoRepositoryPort
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.math.BigDecimal
import java.util.*

@MicronautTest
class ProdutoServiceTest : AnnotationSpec() {

    val service = mockk<ProdutoRepositoryPort>()
    val produtoService = ProdutoService(service)

    companion object{
        val produto = Produto(UUID.randomUUID().toString(), "produto 1", "descricao 1", BigDecimal.ZERO, "teste@teste.com")
    }

    @Test
    fun `deve criar um produto`() {

        every { service.create(any()) } answers {}
        val result = produtoService.create(produto)

        result shouldBe Unit
    }

    @Test
    fun `deve deletar um produto`() {

        every { service.delete(any()) } answers {}
        val result = produtoService.delete(UUID.randomUUID())

        result shouldBe Unit
    }

    @Test
    fun `deve atualizar um produto`() {

        every { service.update(any()) } answers {}
        val result = produtoService.update(produto)

        result shouldBe Unit
    }

}