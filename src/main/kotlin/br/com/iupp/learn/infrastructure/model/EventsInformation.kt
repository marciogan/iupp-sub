package br.com.iupp.learn.infrastructure.model

import io.micronaut.core.annotation.Introspected

@Introspected
data class EventsInformation(
    val events: Events,
    val productEvent: ProductEvent
)