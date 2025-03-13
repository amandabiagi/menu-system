package com.biagi.menu_system.model;

import com.biagi.menu_system.enums.UserRoleEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Establishment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O nome do estabelecimento não pode ser nulo")
    @Size(min = 1, max = 100, message = "O nome do estabelecimento deve ter entre 1 e 100 caracteres")
    private String name;

    @NotEmpty(message = "O email do estabelecimento não pode ser nulo")
    @Email(message = "Email inválido")
    private String email;

    @NotNull(message = "O celular é obrigatório.")
    @Pattern(regexp = "^\\+?[1-9][0-9]{1,14}$", message = "O celular deve ser um número válido no formato internacional.")
    @Size(min = 10, max = 15, message = "O celular deve ter entre 10 e 15 dígitos.")
    private String cellPhone;

    private boolean hasWhatsApp;

    private String logo;

    @OneToMany(mappedBy = "establishment")
    private List<User> users;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
}
