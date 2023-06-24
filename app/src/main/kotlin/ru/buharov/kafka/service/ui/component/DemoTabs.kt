package ru.buharov.kafka.service.ui.component

import com.vaadin.flow.component.Text
import com.vaadin.flow.component.html.Div
import com.vaadin.flow.component.tabs.TabSheet

class DemoTabs : Div() {
	init {
		setSizeFull()
		val tabSheet = TabSheet()
		tabSheet.add(Demo.DEMO1.name, Div(Text("This is the Dashboard tab content")))
		add(tabSheet)
	}
}

enum class Demo {
	DEMO1
}