package com.jessicaoliveira.CentralDeServicos.services;

import com.jessicaoliveira.CentralDeServicos.domain.OS;
import com.jessicaoliveira.CentralDeServicos.repositories.OSRepository;
import com.jessicaoliveira.CentralDeServicos.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OsService {

    @Autowired
    private OSRepository repository;

    public OS findById(Integer id ){
        Optional<OS> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException
                ("Objeto não encontrado! Id: " + id + ", Tipo: " + OS.class.getName()));
    }
}
