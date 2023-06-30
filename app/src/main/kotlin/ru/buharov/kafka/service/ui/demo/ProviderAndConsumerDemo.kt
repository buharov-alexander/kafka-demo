package ru.buharov.kafka.service.ui.demo

import com.vaadin.flow.component.html.Div
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import ru.buharov.kafka.service.kafkaclient.KafkaService
import ru.buharov.kafka.service.ui.component.MessageConsumer
import ru.buharov.kafka.service.ui.component.MessageProvider


class ProviderAndConsumerDemo(kafkaService: KafkaService) : Div() {

	init {
		val layout = HorizontalLayout()
		layout.isPadding = true

		val topic = kafkaService.getKafkaTopicDemo1Name()
		layout.add(MessageProvider("Provider 1") { value: String -> kafkaService.sendMessage(topic, value) })
		val messageConsumer = MessageConsumer("Consumer 1")
		layout.add(messageConsumer)

		add(layout)
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