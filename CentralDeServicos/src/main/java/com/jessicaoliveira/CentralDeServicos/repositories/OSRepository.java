package com.jessicaoliveira.CentralDeServicos.repositories;

import com.jessicaoliveira.CentralDeServicos.domain.OS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OSRepository extends JpaRepository<OS, Integer> {
}
