package com.santosdosbruno.TelaCadastro.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonaReport {
    private Integer id;
    private String name;
    private String phone;
    private String cpf;
    private String number;
    private String complement;
    private String zipCode;
    private String district;
    private String city;
    private String state;
}
