package ru.buharov.kafka.service.ui.demo

import com.vaadin.flow.component.html.Div
import org.springframework.beans.factory.annotation.Value
import ru.buharov.kafka.service.kafkaclient.KafkaService
import ru.buharov.kafka.service.ui.component.MessageConsumer
import ru.buharov.kafka.service.ui.component.MessageProvider

class ProviderAndConsumerDemo(kafkaService: KafkaService) : Div() {

	init {
		val topic = kafkaService.getKafkaTopicDemo1Name()
		add(MessageProvider("Provider 1") { value: String -> kafkaService.sendMessage(topic, value) })
		val messageConsumer = MessageConsumer("Consumer 1")
		add(messageConsumer)

		kafkaService.registerMessageHandler(topic) { message: String ->
			messageHandler(
				message,
				messageConsumer
			)
		}
	}

	private fun messageHandler(message: String, messageConsumer: MessageConsumer) {
		ui.ifPresent { ui ->
			ui.access { messageConsumer.addMessage(message) }
		}
	}


	fun getLabel(): String {
		return "Demo 1"
	}
}