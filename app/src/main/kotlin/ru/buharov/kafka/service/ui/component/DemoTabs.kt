package ru.buharov.kafka.service.ui.component

import com.vaadin.flow.component.Text
import com.vaadin.flow.component.html.Div
import com.vaadin.flow.component.tabs.TabSheet
import ru.buharov.kafka.service.kafkaclient.KafkaService
import ru.buharov.kafka.service.ui.demo.ProviderAndConsumerDemo

class DemoTabs(kafkaService: KafkaService) : Div() {
	init {
		setSizeFull()
		val tabSheet = TabSheet()
		val providerAndConsumerDemo = ProviderAndConsumerDemo(kafkaService)
		tabSheet.add(providerAndConsumerDemo.getLabel(), providerAndConsumerDemo)
		add(tabSheet)
	}

}

enum class Demo {
	DEMO1
}