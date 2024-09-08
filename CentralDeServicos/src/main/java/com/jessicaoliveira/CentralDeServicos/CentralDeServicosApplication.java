package com.jessicaoliveira.CentralDeServicos;

import com.jessicaoliveira.CentralDeServicos.domain.Cliente;
import com.jessicaoliveira.CentralDeServicos.domain.OS;
import com.jessicaoliveira.CentralDeServicos.domain.Tecnico;
import com.jessicaoliveira.CentralDeServicos.domain.enums.Prioridade;
import com.jessicaoliveira.CentralDeServicos.domain.enums.Status;
import com.jessicaoliveira.CentralDeServicos.repositories.ClienteRepository;
import com.jessicaoliveira.CentralDeServicos.repositories.OSRepository;
import com.jessicaoliveira.CentralDeServicos.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CentralDeServicosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CentralDeServicosApplication.class, args);
	}
};