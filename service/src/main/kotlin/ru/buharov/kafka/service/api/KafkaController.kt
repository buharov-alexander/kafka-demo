package ru.buharov.kafka.service.api

import org.springframework.web.bind.annotation.*
import ru.buharov.kafka.service.kafkaclient.KafkaService

@RestController
@RequestMapping("/kafka")
class KafkaController(private val kafkaService: KafkaService) {

	@PutMapping("/message")
	fun sendMessage(@RequestBody messageDto: MessageDTO) {
		kafkaService.sendMessage(messageDto.topic, messageDto.message)
	}

	@PostMapping("topic")
	fun createTopic(@RequestBody topicDto: TopicDTO) {
		kafkaService.createTopic(topicDto.topic)
	}
}