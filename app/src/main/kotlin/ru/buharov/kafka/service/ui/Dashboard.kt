package ru.buharov.kafka.service.ui

import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.component.textfield.TextArea
import com.vaadin.flow.router.Route
import ru.buharov.kafka.service.kafkaclient.KafkaService
import ru.buharov.kafka.service.ui.component.DemoTabs


@Route("")
class Dashboard(kafkaService: KafkaService) : VerticalLayout() {
	private val messageDisplay = MessageDisplay()
	private val demoTabs = DemoTabs(kafkaService)

	init {
		add(messageDisplay)
		add(demoTabs)

		kafkaService.registerMessageHandler("test") { message: String -> messageHandler(message) }
	}

	private fun messageHandler(message: String) {
		ui.ifPresent { ui ->
			ui.access { messageDisplay.addMessage(message) }
		}
	}
}

class MessageDisplay : TextArea() {

	init {
		setSizeFull()
		label = "Messages"
	}

	fun addMessage(message: String) {
		value = when {
			value.isNullOrEmpty() -> message
			else -> "$value<br/>$message"
		}
	}
}