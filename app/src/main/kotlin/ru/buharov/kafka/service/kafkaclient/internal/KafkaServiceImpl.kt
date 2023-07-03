package ru.buharov.kafka.service.kafkaclient.internal

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.core.KafkaAdmin
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.handler.annotation.Header
import org.springframework.stereotype.Service
import ru.buharov.kafka.service.kafkaclient.KafkaService

@Service
private class KafkaServiceImpl(
	private val kafkaTemplate: KafkaTemplate<String, String>,
) : KafkaService {

	override fun sendMessage(topic: String, message: String) {
		kafkaTemplate.send(topic, message)
	}
}