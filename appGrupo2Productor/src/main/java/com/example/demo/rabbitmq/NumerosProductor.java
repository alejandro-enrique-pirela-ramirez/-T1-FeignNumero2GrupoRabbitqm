package com.example.demo.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.config.RabbitMqConfig;
import com.example.demo.dto.NumerosMensaje;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class NumerosProductor {

	private final RabbitTemplate rabbitTemplate;

	public void enviarNumerosARabbitMQ(NumerosMensaje mensaje) {
		rabbitTemplate.convertAndSend(
				RabbitMqConfig.EXCHANGE,
				RabbitMqConfig.ROUTING_KEY, mensaje);
				log.info("enviando numeros a rabbitmq: {}", mensaje);
	}

}