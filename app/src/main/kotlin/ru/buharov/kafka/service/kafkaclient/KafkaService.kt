package ru.buharov.kafka.service.kafkaclient

interface KafkaService {
	fun sendMessage(topic: String, message: String)
}
