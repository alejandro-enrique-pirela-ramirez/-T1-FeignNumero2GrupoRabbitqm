package com.example.demo.service;

import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.example.demo.dto.NumerosMensaje;
import com.example.demo.rabbitmq.NumerosProductor;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NumerosService {

	private final NumerosProductor productor;

	public String enviarNumeros(String cadenaNumeros) {
		Integer[] numeros = Stream.of(cadenaNumeros.split(";"))
				.map(String::trim)
				.map(Integer::parseInt)
				.toArray(Integer[]::new);

		NumerosMensaje mensaje = new NumerosMensaje(numeros);

		productor.enviarNumerosARabbitMQ(mensaje);
		return "Lista enviada a RabbitMQ correctamente";
	}

}