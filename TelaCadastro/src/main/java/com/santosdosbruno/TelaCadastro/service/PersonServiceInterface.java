package com.santosdosbruno.TelaCadastro.service;


import com.santosdosbruno.TelaCadastro.DTO.PersonDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonServiceInterface {

    void creationPerson(PersonDTO dto);
    List<PersonDTO> findAll();
}
