package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.NumerosService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/productor")
@RequiredArgsConstructor
public class NumerosController {
/* http://localhost:8085/api/productor/numeros?numbers=1;2;15;8;60;55;65;78;87;98;90;12;34;35;37;31;22;21;24;23  */
	private final NumerosService numerosService;

	@GetMapping("/numeros")
	public String enviarNumeros(@RequestParam String numbers) {
		return numerosService.enviarNumeros(numbers);
	}

}