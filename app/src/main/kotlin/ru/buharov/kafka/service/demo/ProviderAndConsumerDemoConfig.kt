package ru.buharov.kafka.service.demo

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.handler.annotation.Header
import ru.buharov.kafka.service.kafkaclient.KafkaService

@Configuration
class ProviderAndConsumerDemoConfig {

	@Value("\${kafka.topic.demo1.name}")
	private val kafkaTopicDemo1Name: String = ""

	@Bean
	fun kafkaDemo1Topic(): NewTopic {
		return NewTopic(kafkaTopicDemo1Name, 1, 1.toShort())
	}

	@Bean
	fun kafkaDemo1(kafkaService: KafkaService): ProviderAndConsumerDemo {
		return ProviderAndConsumerDemo(kafkaService)
	}
}