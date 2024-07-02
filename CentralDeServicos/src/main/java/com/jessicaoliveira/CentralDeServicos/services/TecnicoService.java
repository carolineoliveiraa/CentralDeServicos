package com.jessicaoliveira.CentralDeServicos.services;

import com.jessicaoliveira.CentralDeServicos.domain.Tecnico;
import com.jessicaoliveira.CentralDeServicos.dtos.TecnicoDTO;
import com.jessicaoliveira.CentralDeServicos.services.exceptions.DataIntegratyViolationException;
import com.jessicaoliveira.CentralDeServicos.services.exceptions.ObjectNotFoundException;
import com.jessicaoliveira.CentralDeServicos.repositories.TecnicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository repository;

    public Tecnico findById(Integer id) {
        Optional<Tecnico> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException
                ("Objeto não encontrado! Id: " + id + ", Tipo: " + Tecnico.class.getName()));
    }

    public List<Tecnico> findAll() {
        return repository.findAll();
    }

    public Tecnico create(TecnicoDTO objDTO){
        if (findByCPF(objDTO) != null){
            throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
        }

        return repository.save(new Tecnico(null, objDTO.getNome(), objDTO.getCpf(), objDTO.getTelefone()));
    }

    public Tecnico update(Integer id, @Valid TecnicoDTO objDTO) {
        Tecnico oldObj = findById(id);

        if (findByCPF(objDTO) != null && findByCPF(objDTO).getId() != id){
            throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
        }

        oldObj.setNome(objDTO.getNome());
        oldObj.setCpf(objDTO.getCpf());
        oldObj.setTelefone(objDTO.getTelefone());
        return repository.save(oldObj);
    }

    private Tecnico findByCPF(TecnicoDTO objDTO){
        Tecnico obj = repository.findByCPF(objDTO.getCpf());
        if (obj != null){
            return obj;
        }
        return null;
    }


}
