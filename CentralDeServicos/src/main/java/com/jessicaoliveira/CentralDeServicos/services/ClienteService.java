package com.jessicaoliveira.CentralDeServicos.services;

import com.jessicaoliveira.CentralDeServicos.domain.Pessoa;
import com.jessicaoliveira.CentralDeServicos.domain.Cliente;
import com.jessicaoliveira.CentralDeServicos.dtos.ClienteDTO;
import com.jessicaoliveira.CentralDeServicos.repositories.PessoaRepository;
import com.jessicaoliveira.CentralDeServicos.repositories.ClienteRepository;
import com.jessicaoliveira.CentralDeServicos.services.exceptions.DataIntegratyViolationException;
import com.jessicaoliveira.CentralDeServicos.services.exceptions.ObjectNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Cliente findById(Integer id) {
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException
                ("Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    // Cria um cliente
    public Cliente create(ClienteDTO objDTO){
        if (findByCPF(objDTO) != null){
            throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
        }

        return repository.save(new Cliente(null, objDTO.getNome(), objDTO.getCpf(), objDTO.getTelefone()));
    }

    // Atualiza um cliente
    public Cliente update(Integer id, @Valid ClienteDTO objDTO) {
        Cliente oldObj = findById(id);

        if (findByCPF(objDTO) != null && findByCPF(objDTO).getId() != id){
            throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
        }

        oldObj.setNome(objDTO.getNome());
        oldObj.setCpf(objDTO.getCpf());
        oldObj.setTelefone(objDTO.getTelefone());
        return repository.save(oldObj);
    }


    // Deleta um cliente
    public void delete(Integer id) {
        Cliente obj = findById(id);
        if (obj.getList().size() > 0 ){
            throw new DataIntegratyViolationException("Pessoa possui Ordens de Serviço, não pode ser deletado!");
        }
        repository.deleteById(id);

    }

    // Busca um cliente pelo CPF
    private Pessoa findByCPF(ClienteDTO objDTO){
        Pessoa obj = pessoaRepository.findByCPF(objDTO.getCpf());
        if (obj != null){
            return obj;
        }
        return null;
    }

}
