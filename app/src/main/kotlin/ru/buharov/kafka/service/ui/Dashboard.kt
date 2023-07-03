package ru.buharov.kafka.service.ui

import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.Route
import ru.buharov.kafka.service.ui.component.DemoTabs
import ru.buharov.kafka.service.demo.ProviderAndConsumerDemo


@Route("")
class Dashboard(demo1: ProviderAndConsumerDemo) : VerticalLayout() {
	private val demoTabs = DemoTabs(demo1)

	init {
		add(demoTabs)
	}

}