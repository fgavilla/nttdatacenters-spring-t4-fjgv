package com.example.nttdatacentersspringt4fjgv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entidades.Cliente;
import services.ClienteService;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import entidades.ClienteI;


@SpringBootApplication
public class NttdatacentersSpringT4FjgvApplication implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(NttdatacentersSpringT4FjgvApplication.class);
	@Autowired
	ClienteService clienteService;
	
	public static void main(String[] args) {
		SpringApplication.run(NttdatacentersSpringT4FjgvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//clienteService.crearDatosDummy();
		//clienteService.mostrarTodos();

		List<Cliente> clientes = clienteService.buscarNombreCompleto("Francisco", "Garcia","Villalon");
		logger.debug(clientes.get(0).toString());
		
	}

}
