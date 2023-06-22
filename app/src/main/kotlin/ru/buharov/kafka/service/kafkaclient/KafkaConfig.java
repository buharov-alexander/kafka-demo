/***************       BEGIN-STANDARD-COPYRIGHT      ***************

 Copyright (c) 2009-2023, Spirent Communications.

 All rights reserved. Proprietary and confidential information of Spirent Communications.
 ***************        END-STANDARD-COPYRIGHT       ***************/
package ru.buharov.kafka.service.kafkaclient;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

	@Value("${kafka.topic.demo1.name}")
	private String kafkaTopicDemo1Name;

	@Bean
	public NewTopic kafkaDemo1Topic() {
		return new NewTopic(kafkaTopicDemo1Name, 1, (short) 1);
	}
}
