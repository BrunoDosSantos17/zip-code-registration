package com.santosdosbruno.TelaCadastro.entities;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class Address {
    @NotBlank
    private String number;

    private String complement;

    @NotBlank
    private String zipCode;

    @NotBlank
    private String district;

    @NotBlank
    private String city;

    @NotBlank
    private String state;
}
