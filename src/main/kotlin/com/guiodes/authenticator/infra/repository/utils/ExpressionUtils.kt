package com.guiodes.authenticator.infra.repository.utils

fun String.addCondition(sql: String): String {
    val lowerCaseQueryString = this.lowercase()

    return lowerCaseQueryString.takeIf {
        it.contains("where", ignoreCase = true)
    }?.let { "$this AND $sql" } ?: "$this WHERE $sql"
}
