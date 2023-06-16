package ru.buharov.kafka.service.kafkaclient.internal

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.core.KafkaAdmin
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import ru.buharov.kafka.service.kafkaclient.KafkaService

@Service
class KafkaServiceImpl(
		private val kafkaTemplate: KafkaTemplate<String, String>,
		private val kafkaAdmin: KafkaAdmin) : KafkaService {

	override fun sendMessage(topic: String, message: String) {
		kafkaTemplate.send(topic, message)
	}

	override fun createTopic(topic: String) {
		val newTopic = NewTopic(topic, 1, 1)
		kafkaAdmin.createOrModifyTopics(newTopic)
	}

	@KafkaListener(topicPattern = ".*", groupId = "all")
	fun listenAll(content: String?) {
		println(content)
	}
}