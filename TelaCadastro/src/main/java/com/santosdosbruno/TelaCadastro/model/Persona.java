package com.santosdosbruno.TelaCadastro.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "person_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String phone;
    private String cpf;
    private String address;
    private String number;
    private String complement;
    private String zipCode;
    private String district;
    private String city;
    private String state;

}