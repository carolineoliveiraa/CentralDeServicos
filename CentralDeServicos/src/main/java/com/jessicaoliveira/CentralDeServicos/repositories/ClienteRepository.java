package com.jessicaoliveira.CentralDeServicos.repositories;

import com.jessicaoliveira.CentralDeServicos.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
