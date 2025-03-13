package com.biagi.menu_system.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "A rua não pode ser nulo")
    @Size(min = 2, max = 100, message = "O nome da rua deve ter entre 2 e 100 caracteres")
    private String street;

    private String number;

    private String complement;

    @NotEmpty(message = "O bairro não pode ser nulo")
    @Size(min = 2, max = 100, message = "O nome do bairro deve ter entre 2 e 100 caracteres")
    private String neighborhood;

    @NotEmpty(message = "A cidade não pode ser nulo")
    @Size(min = 2, max = 100, message = "O nome da cidade ter entre 2 e 100 caracteres")
    private String city;

    @NotEmpty(message = "O estado não pode ser nulo")
    @Size(min = 2, max = 100, message = "O nome do estado deve ter entre 2 e 100 caracteres")
    private String state;

    @NotEmpty(message = "O CEP não pode ser nulo")
    @Size(min = 8, max = 8, message = "O número do CEP deve ter 8 dígitos")
    private Long zipCode;

    @OneToMany(mappedBy = "address")
    private List<User> users;

    @OneToOne(mappedBy = "address")
    private Establishment establishment;
}
