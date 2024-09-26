package com.santosdosbruno.TelaCadastro.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@Builder
@ToString
public class PersonaRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String phone;

    @CPF
    @NotBlank
    private String cpf;

    @NotNull
    private Address address;
}
