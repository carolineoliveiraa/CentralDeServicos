package com.jessicaoliveira.CentralDeServicos.repositories;

import com.jessicaoliveira.CentralDeServicos.domain.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {
}
