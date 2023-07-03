package ru.buharov.kafka.service.ui.component

import com.vaadin.flow.component.html.Div
import com.vaadin.flow.component.tabs.TabSheet
import ru.buharov.kafka.service.demo.ProviderAndConsumerDemo

class DemoTabs(demo1: ProviderAndConsumerDemo) : Div() {
	init {
		setSizeFull()
		val tabSheet = TabSheet()
		val demo1UI = demo1.createUI()
		tabSheet.add(demo1UI.getLabel(), demo1UI)
		add(tabSheet)
	}

}
