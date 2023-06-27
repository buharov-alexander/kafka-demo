package ru.buharov.kafka.service.ui.component

import com.vaadin.flow.component.Text
import com.vaadin.flow.component.html.Div
import com.vaadin.flow.component.messages.MessageInput
import com.vaadin.flow.component.messages.MessageInput.SubmitEvent
import java.util.function.Consumer


class MessageProvider(label: String, handler: Consumer<String>) : Div() {

	init {
		add(Text(label))
		val input = MessageInput()
		input.addSubmitListener { submitEvent: SubmitEvent ->
			handler.accept(submitEvent.value)
		}
		add(input)
	}
}