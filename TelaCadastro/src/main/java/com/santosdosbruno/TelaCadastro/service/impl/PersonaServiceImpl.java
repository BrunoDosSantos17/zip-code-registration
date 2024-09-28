package com.santosdosbruno.TelaCadastro.service.impl;

import com.santosdosbruno.TelaCadastro.DTO.PersonDTO;
import com.santosdosbruno.TelaCadastro.model.Persona;
import com.santosdosbruno.TelaCadastro.repository.PersonaRepository;
import com.santosdosbruno.TelaCadastro.service.PersonServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.modelmapper.ModelMapper;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonServiceInterface {

    private final PersonaRepository personaRepository;

    private final ModelMapper modelMapper;

    public void creationPerson(PersonDTO dto) {
        Persona person = new Persona();

        person.setName(dto.getName());
        person.setPhone(dto.getPhone());
        person.setCpf(dto.getCpf());
        person.setAddress(dto.getAddress());
        person.setNumber(dto.getNumber());
        person.setComplement(dto.getComplement());
        person.setZipCode(dto.getZipCode());
        person.setDistrict(dto.getDistrict());
        person.setDistrict(dto.getDistrict());
        person.setCity(dto.getCity());
        person.setState(dto.getState());

        personaRepository.save(person);
    }


    public List<PersonDTO> findAll() {
        return personaRepository.findAll().stream().map(p -> modelMapper.map(p, PersonDTO.class)).collect(Collectors.toList());
    }
}
