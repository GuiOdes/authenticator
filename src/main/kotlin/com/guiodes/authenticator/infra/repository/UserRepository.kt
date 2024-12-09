package com.guiodes.authenticator.infra.repository

import com.guiodes.authenticator.domain.model.User
import com.guiodes.authenticator.infra.api.request.CreateUserRequest
import com.guiodes.authenticator.infra.repository.expression.UserExpressions
import com.guiodes.authenticator.infra.repository.expression.UserExpressions.SELECT
import com.guiodes.authenticator.infra.repository.expression.UserExpressions.USERNAME
import com.guiodes.authenticator.infra.repository.utils.addCondition
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import java.sql.ResultSet
import java.time.LocalDateTime
import java.util.UUID

@Repository
class UserRepository(
    private val template: NamedParameterJdbcTemplate
) {

    fun save(request: CreateUserRequest) {
        val id = UUID.randomUUID()
        val now = LocalDateTime.now()

        val parameters = MapSqlParameterSource()
            .addValue("id", id)
            .addValue("username", request.username)
            .addValue("password", request.password)
            .addValue("email", request.email)
            .addValue("createdAt", now)
            .addValue("updatedAt", now)

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
            password = rs.getString("password"),
            email = rs.getString("email"),
            createdAt = rs.getTimestamp("created_at").toLocalDateTime(),
            updatedAt = rs.getTimestamp("updated_at").toLocalDateTime()
        )
    }
}
