package ru.buharov.kafka.service.ui

import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.Route
import ru.buharov.kafka.service.kafkaclient.KafkaService
import ru.buharov.kafka.service.ui.component.DemoTabs


@Route("")
class Dashboard(kafkaService: KafkaService) : VerticalLayout() {
	private val demoTabs = DemoTabs(kafkaService)

	init {
		add(demoTabs)
	}

}