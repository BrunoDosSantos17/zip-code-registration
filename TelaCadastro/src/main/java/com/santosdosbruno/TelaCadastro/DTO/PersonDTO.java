package com.santosdosbruno.TelaCadastro.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
public class PersonDTO {

    @NotBlank
    private String name;
    private String phone;
    @CPF
    private String cpf;
    private String address;
    @Positive
    private String number;
    private String complement;
    private String zipCode;
    private String district;
    private String city;
    private String state;
}
