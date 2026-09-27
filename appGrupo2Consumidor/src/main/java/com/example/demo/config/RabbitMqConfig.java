package com.example.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

	public static final String EXCHANGE = "Grupo2Exchange";
	public static final String QUEUE = "Grupo2Queue";
	public static final String ROUTING_KEY = "Grupo2Routing";

	@Bean
	public DirectExchange grupo2Exchange() {
		return new DirectExchange(EXCHANGE);
	}

	@Bean
	public Queue grupo2Queue() {
		return new Queue(QUEUE, true);
	}

	@Bean
	public Binding grupo1Binding(Queue grupo2Queue, DirectExchange grupo2Exchange) {
		return BindingBuilder.bind(grupo2Queue)
				.to(grupo2Exchange)
				.with(ROUTING_KEY);
	}
}