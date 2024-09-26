package com.santosdosbruno.TelaCadastro.service;


import com.santosdosbruno.TelaCadastro.entities.PersonaResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonService {
    Page<PersonaResponse> list(Pageable pageable);
    void requestReport();
    String getReport();
    String getStatus();
    void setStatus(String status);
    void fetchReport();
    PersonaResponse find(Integer id);
    PersonaResponse register(PersonaResponse PersonaResponse);
    PersonaResponse update(Integer id, PersonaResponse PersonaResponse);
    void deleteById(Integer id);
}
