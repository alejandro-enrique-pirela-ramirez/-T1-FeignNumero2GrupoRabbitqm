package com.example.demo.dto;

public class NumerosMensaje {

	private Integer[] numeros;

	public NumerosMensaje() {
	}

	public NumerosMensaje(Integer[] numeros) {
		this.numeros = numeros;
	}

	public Integer[] getNumeros() {
		return numeros;
	}

	public void setNumeros(Integer[] numeros) {
		this.numeros = numeros;
	}
}