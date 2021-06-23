package br.com.iupp.learn.infrastructure.subscribe

import br.com.iupp.learn.core.mapper.ProdutoConverter
import br.com.iupp.learn.core.model.Produto
import br.com.iupp.learn.core.port.ProdutoServicePort
import br.com.iupp.learn.database.entity.ProdutoEntity
import br.com.iupp.learn.infrastructure.model.Events
import br.com.iupp.learn.infrastructure.model.EventsInformation
import br.com.iupp.learn.infrastructure.model.ProductEvent
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.math.BigDecimal
import java.util.*

@MicronautTest
class ProdutoServerTest: AnnotationSpec(){

    val service = mockk<ProdutoServicePort>()
    val produtoServer = ProdutoServer(service)

    companion object{
        val productEvent = ProductEvent(id = UUID.randomUUID().toString(), nome = "produto 1", preco = BigDecimal.ZERO, descricao = "descricao 1", emailDono = "teste@teste.com")
    }

    @Test
    fun `deve criar um produto`(){

        val eventsInformation = EventsInformation(Events.SAVE_PRODUCT, productEvent)

        every{service.create(any()) } answers {}
        val result = produtoServer.listen(eventsInformation)

        result shouldBe Unit
    }

    @Test
    fun `deve atualizar um produto`(){

        val eventsInformation = EventsInformation(Events.UPDATE_PRODUCT, productEvent)

        every{service.update(any()) } answers {}
        val result = produtoServer.listen(eventsInformation)

        result shouldBe Unit
    }

    @Test
    fun `deve deletar um produto`(){

        val eventsInformation = EventsInformation(Events.DELETE_PRODUCT, ProductEvent(UUID.randomUUID().toString()))

        every{service.delete(any()) } answers {}
        val result = produtoServer.listen(eventsInformation)

        result shouldBe Unit
    }

}