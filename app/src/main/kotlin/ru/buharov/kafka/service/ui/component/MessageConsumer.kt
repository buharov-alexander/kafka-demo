package ru.buharov.kafka.service.ui.component

import com.vaadin.flow.component.Text
import com.vaadin.flow.component.html.Div
import com.vaadin.flow.component.textfield.TextArea

class MessageConsumer(label: String) : Div() {
	private val textArea = TextArea()
	init {
		setSizeFull()
		textArea.setSizeFull()
		add(Text(label))
		add(textArea)
	}

	fun addMessage(message: String) {
		textArea.value = when {
			textArea.value.isNullOrEmpty() -> message
			else -> "${textArea.value}\n$message"
		}
	}
}