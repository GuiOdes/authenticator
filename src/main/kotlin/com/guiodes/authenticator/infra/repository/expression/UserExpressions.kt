package com.guiodes.authenticator.infra.repository.expression

object UserExpressions {

    const val INSERT = """
        INSERT INTO TB_USER (
            ID,
            USERNAME,
            EMAIL,
            CREATED_AT,
            UPDATED_AT
        ) VALUES (
            :id,
            :username,
            :email,
            :createdAt,
            :updatedAt
        )
    """

    const val SELECT = """
        SELECT
            ID,
            USERNAME,
            EMAIL,
            CREATED_AT,
            UPDATED_AT
        FROM TB_USER
    """

    const val USERNAME = "username = :username"
}
