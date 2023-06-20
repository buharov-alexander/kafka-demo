package ru.buharov.kafka.service.api

import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter
import ru.buharov.kafka.service.kafkaclient.KafkaService

@RestController
@RequestMapping("/kafka")
class KafkaController(private val kafkaService: KafkaService) {

	@PutMapping("/message")
	fun sendMessage(@RequestBody messageDto: MessageDTO) {
		kafkaService.sendMessage(messageDto.topic, messageDto.message)
	}

	@PostMapping("/topic")
	fun createTopic(@RequestBody topicDto: TopicDTO) {
		kafkaService.createTopic(topicDto.topic)
	}

	@GetMapping("/{topic}/messages")
	fun getMessages(@PathVariable topic: String): SseEmitter {
		val sseEmitter = SseEmitter(-1L)
		val handler = { message: String -> sseEmitter.send(message) }
		kafkaService.registerMessageHandler(topic, handler)
		return sseEmitter;
	}
}