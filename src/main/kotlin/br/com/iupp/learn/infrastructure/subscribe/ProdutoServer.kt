package br.com.iupp.learn.infrastructure.subscribe

import br.com.iupp.learn.core.mapper.ProdutoConverter
import br.com.iupp.learn.core.port.ProdutoServicePort
import br.com.iupp.learn.infrastructure.model.EventsInformation
import io.micronaut.nats.annotation.NatsListener
import io.micronaut.nats.annotation.Subject
import org.slf4j.LoggerFactory
import java.util.*

@NatsListener
class ProdutoServer(private val produtoService: ProdutoServicePort) {

    private val LOGGER = LoggerFactory.getLogger(this::class.java)

    @Subject("platform.produto.cadastro")
    fun listen(eventsInformation: EventsInformation) {

        LOGGER.info("\n Mensagem recebida do broker com sucesso \n $eventsInformation")

        if (eventsInformation.events.name.equals("SAVE_PRODUCT")) {
            produtoService.create(ProdutoConverter.produtoEventToProduto(eventsInformation.productEvent))
            LOGGER.info("\n Produto CRIADO com sucesso")
        }

        if (eventsInformation.events.name.equals("DELETE_PRODUCT")){
            produtoService.delete(UUID.fromString(eventsInformation.productEvent.id))
            LOGGER.info("\n Produto DELETADO com sucesso")
        }

        if (eventsInformation.events.name.equals("UPDATE_PRODUCT")){
            produtoService.update(ProdutoConverter.produtoEventToProduto(eventsInformation.productEvent))
            LOGGER.info("\n Produto ATUALIZADO com sucesso")
        }
    }
}