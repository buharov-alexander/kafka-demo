package ru.buharov.kafka.service.demo

import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.handler.annotation.Header
import ru.buharov.kafka.service.kafkaclient.KafkaService

class ProviderAndConsumerDemo(private val kafkaService: KafkaService) {

	@Value("\${kafka.topic.demo1.name}")
	private val kafkaTopicDemo1Name: String = ""
	private var ui = ProviderAndConsumerDemoUI {message -> message}

	fun createUI(): ProviderAndConsumerDemoUI {
		ui = ProviderAndConsumerDemoUI { message -> kafkaService.sendMessage(kafkaTopicDemo1Name, message) }
		return ui
	}

	@KafkaListener(topics = ["\${kafka.topic.demo1.name}"], groupId = "demo1-group")
	fun listenDemo1(
		content: String,
		@Header(KafkaHeaders.OFFSET) offset: String,
		@Header(KafkaHeaders.RECEIVED_PARTITION) partition: Int,
	) {
		ui.addMessage("Partition: $partition, Offset: $offset, Message: $content")
	}

}