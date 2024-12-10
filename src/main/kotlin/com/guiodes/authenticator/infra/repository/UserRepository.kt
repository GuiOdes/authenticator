package com.guiodes.authenticator.infra.repository

import com.guiodes.authenticator.application.gateway.UserGateway
import com.guiodes.authenticator.domain.model.User
import com.guiodes.authenticator.infra.repository.expression.UserExpressions
import com.guiodes.authenticator.infra.repository.expression.UserExpressions.SELECT
import com.guiodes.authenticator.infra.repository.expression.UserExpressions.USERNAME
import com.guiodes.authenticator.infra.repository.utils.addCondition
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import java.sql.ResultSet
import java.util.UUID

@Repository
class UserRepository(
    private val template: NamedParameterJdbcTemplate
) : UserGateway {

    override fun save(user: User) {

        val parameters = MapSqlParameterSource()
            .addValue("id", user.id)
            .addValue("username", user.username)
            .addValue("email", user.email)
            .addValue("createdAt", user.createdAt)
            .addValue("updatedAt", user.updatedAt)

        template.update(
            UserExpressions.INSERT,
            parameters
        )
    }

    fun findByUsername(username: String): User? {
        val parameters = MapSqlParameterSource()
            .addValue("username", username)

        return template.query(
            SELECT.addCondition(USERNAME),
            parameters,
            rowMapper()
        ).firstOrNull()
    }

    private fun rowMapper() = { rs: ResultSet, _: Int ->
        User(
            id = UUID.fromString(rs.getString("id")),
            username = rs.getString("username"),
            email = rs.getString("email"),
            createdAt = rs.getTimestamp("created_at").toLocalDateTime(),
            updatedAt = rs.getTimestamp("updated_at").toLocalDateTime()
        )
    }
}
