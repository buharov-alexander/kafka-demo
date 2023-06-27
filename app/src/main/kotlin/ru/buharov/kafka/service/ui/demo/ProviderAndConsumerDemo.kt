package ru.buharov.kafka.service.ui.demo

import com.vaadin.flow.component.html.Div
import org.springframework.beans.factory.annotation.Value
import ru.buharov.kafka.service.kafkaclient.KafkaService
import ru.buharov.kafka.service.ui.component.MessageProvider

class ProviderAndConsumerDemo(kafkaService: KafkaService) : Div() {

	@Value("\${kafka.topic.demo1.name}")
	private val kafkaTopicDemo1Name: String = ""

	init {
		add(MessageProvider("Provider 1") { value: String -> kafkaService.sendMessage(kafkaTopicDemo1Name, value)})
		add(MessageProvider("Provider 2") { value: String -> kafkaService.sendMessage(kafkaTopicDemo1Name, value)})
	}

	fun getLabel() : String {
		return "Demo 1"
	}
}