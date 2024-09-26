package com.santosdosbruno.TelaCadastro.repository;

import com.santosdosbruno.TelaCadastro.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    Persona findByCpf(String cpf);
}
