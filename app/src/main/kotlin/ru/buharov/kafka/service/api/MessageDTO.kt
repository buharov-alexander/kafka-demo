package ru.buharov.kafka.service.api

data class MessageDTO(
		val topic: String,
		val message: String
)