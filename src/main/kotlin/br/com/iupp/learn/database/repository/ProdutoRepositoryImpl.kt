package br.com.iupp.learn.database.repository

import br.com.iupp.learn.database.entity.ProdutoEntity
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import java.util.*
import javax.inject.Singleton

@Singleton
class ProdutoRepositoryImpl(private val cqlSession: CqlSession) : ProdutoRepository {

    override fun create(produtoEntity: ProdutoEntity) {
        val result = cqlSession.execute(SimpleStatement.newInstance(
            "INSERT INTO mykeyspace.produto(id, descricao, emailDono, nome, preco) values (?,?,?,?,?)",
                UUID.randomUUID(),
                produtoEntity.descricao,
                produtoEntity.emailDono,
                produtoEntity.nome,
                produtoEntity.preco
            )
        )
    }

    override fun delete(id: UUID) {
        cqlSession.execute(SimpleStatement.newInstance(
            "DELETE FROM mykeyspace.produto WHERE id = ?", id)
        )
    }

    override fun update(produtoEntity: ProdutoEntity) {
        cqlSession.execute(SimpleStatement.newInstance(
            "UPDATE mykeyspace.produto " +
                    "SET " +
                    "nome = '${produtoEntity.nome}', " +
                    "descricao = '${produtoEntity.descricao}', " +
                    "preco = ${produtoEntity.preco}, " +
                    "emailDono = '${produtoEntity.emailDono}' " +
                    "WHERE id = ${produtoEntity.id}"
            )
        )
    }
}
