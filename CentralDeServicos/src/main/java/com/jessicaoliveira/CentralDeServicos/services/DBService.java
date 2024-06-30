package com.jessicaoliveira.CentralDeServicos.services;

import com.jessicaoliveira.CentralDeServicos.domain.Cliente;
import com.jessicaoliveira.CentralDeServicos.domain.OS;
import com.jessicaoliveira.CentralDeServicos.domain.Tecnico;
import com.jessicaoliveira.CentralDeServicos.domain.enums.Prioridade;
import com.jessicaoliveira.CentralDeServicos.domain.enums.Status;
import com.jessicaoliveira.CentralDeServicos.repositories.ClienteRepository;
import com.jessicaoliveira.CentralDeServicos.repositories.OSRepository;
import com.jessicaoliveira.CentralDeServicos.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

        @Autowired
        private TecnicoRepository tecnicoRepository;

        @Autowired
        private ClienteRepository clienteRepository;

        @Autowired
        private OSRepository osRepository;


        public void instanciaDB(){
            Tecnico t1 = new Tecnico(null, "Valdir Cezar", "592.864.340-30", "(98)98698-1896");
            Tecnico t2 = new Tecnico(null, "Jessica Caroline", "127.257.124-67", "(81) 99183-8278");
            Cliente c1 = new Cliente(null, "Betina Campos", "842.464.790-47","(74)99154-1907");

            OS os1 = new OS(null, Prioridade.ALTA, "Teste Create OS", Status.ANDAMENTO, t1, c1);

            t1.getList().add(os1);
            c1.getList().add(os1);

            tecnicoRepository.saveAll(Arrays.asList(t1, t2));
            clienteRepository.saveAll(Arrays.asList(c1));
            osRepository.saveAll(Arrays.asList(os1));
        }
    }
