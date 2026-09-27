package com.example.demo.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.demo.config.RabbitMqConfig;
import com.example.demo.dto.NumerosMensaje;
import com.example.demo.service.MergeSortService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class NumerosConsumidor {

	private final MergeSortService mergeSortService;

	@RabbitListener(queues = RabbitMqConfig.QUEUE)
	public void recibirNumeros(NumerosMensaje mensaje) throws InterruptedException {
		log.info("mensaje recibido: {}", (Object) mensaje.getNumeros());

		Thread.sleep(20000);

		Integer[] ordenado = mergeSortService.sort(mensaje.getNumeros());

		log.info("lista ordenada: {}", (Object) ordenado);
		System.out.println("Lista ordenada: " + java.util.Arrays.toString(ordenado));
	}
}