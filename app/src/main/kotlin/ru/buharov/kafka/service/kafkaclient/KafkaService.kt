package ru.buharov.kafka.service.kafkaclient

interface KafkaService {
	fun sendMessage(topic: String, message: String)
	fun createTopic(topic: String)
	fun registerMessageHandler(topic: String, handler: (String) -> Unit)
}
