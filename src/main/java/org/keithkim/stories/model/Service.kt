package org.keithkim.stories.model

import java.time.Instant

data class Service (
    val id: String,
    val name: String,
    val twitterHandle: String,
    val subscribedEmail: String,

    val createdAt: Instant,
    val updatedAt: Instant
)
