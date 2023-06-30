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
	private val kafkaAdmin: KafkaAdmin
) : KafkaService {

	@Value("\${kafka.topic.demo1.name}")
	private val kafkaTopicDemo1Name: String = ""

	private val handlerMap = mutableMapOf<String, (String) -> Unit>()

	override fun sendMessage(topic: String, message: String) {
		kafkaTemplate.send(topic, message)
	}

	override fun createTopic(topic: String) {
		val newTopic = NewTopic(topic, 1, 1)
		kafkaAdmin.createOrModifyTopics(newTopic)
	}

	override fun registerMessageHandler(topic: String, handler: (String) -> Unit) {
		handlerMap[topic] = handler
	}

	override fun getKafkaTopicDemo1Name(): String {
		return kafkaTopicDemo1Name
	}

	@KafkaListener(topicPattern = ".*", groupId = "all")
	fun listenAll(
		content: String,
		@Header(KafkaHeaders.RECEIVED_TOPIC) topic: String,
		@Header(KafkaHeaders.OFFSET) offset: String,
		@Header(KafkaHeaders.RECEIVED_PARTITION) partition: Int,
	) {
		val handler = handlerMap.getOrDefault(topic) { str -> str }
		handler("Partition: $partition, Offset: $offset, Message: $content")
	}
}