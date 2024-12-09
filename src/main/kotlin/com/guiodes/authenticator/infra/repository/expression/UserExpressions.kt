package com.guiodes.authenticator.infra.repository.expression

object UserExpressions {

    const val INSERT = """
        INSERT INTO TB_USER (
            ID,
            USERNAME,
            PASSWORD,
            EMAIL,
            CREATED_AT,
            UPDATED_AT
        ) VALUES (
            :id,
            :username,
            :password,
            :email,
            :createdAt,
            :updatedAt
        )
    """

    const val SELECT = """
        SELECT
            ID,
            USERNAME,
            PASSWORD,
            EMAIL,
            CREATED_AT,
            UPDATED_AT
        FROM TB_USER
    """

    const val UPDATE_PASSWORD = """
        UPDATE TB_USER
        SET
            PASSWORD = :password,
            UPDATED_AT = :updatedAt
        WHERE ID = :id
    """

    const val USERNAME = "username = :username"
}