package ru.buharov.kafka.service.demo

import com.vaadin.flow.component.html.Div
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import ru.buharov.kafka.service.ui.component.MessageConsumer
import ru.buharov.kafka.service.ui.component.MessageProvider
import java.util.function.Consumer


class ProviderAndConsumerDemoUI(sendMessage: Consumer<String>) : Div() {

	private val messageConsumer: MessageConsumer
	init {
		val layout = HorizontalLayout()
		layout.isPadding = true

		layout.add(MessageProvider("Provider 1", sendMessage))
		messageConsumer = MessageConsumer("Consumer 1")
		layout.add(messageConsumer)

		add(layout)
	}

	fun addMessage(message: String) {
		ui.ifPresent { ui ->
			ui.access { messageConsumer.addMessage(message) }
		}
	}


	fun getLabel(): String {
		return "Demo 1"
	}
}