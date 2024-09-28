package com.santosdosbruno.TelaCadastro.repository;

import com.santosdosbruno.TelaCadastro.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, UUID> {
}
