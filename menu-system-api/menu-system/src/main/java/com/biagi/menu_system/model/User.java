package com.biagi.menu_system.model;

import com.biagi.menu_system.enums.UserRoleEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O nome do usuário não pode ser nulo")
    @Size(min = 2, max = 100, message = "O nome do usuário deve ter entre 2 e 100 caracteres")
    private String name;

    @NotEmpty(message = "O email do usuário não pode ser nulo")
    @Email(message = "Email inválido")
    private String email;

    @NotBlank(message = "A senha não pode ser em branco")
    @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres")
    private String password;

    @Past(message = "Data de nasciemnto inválida")
    private LocalDate birthDate;

    @NotNull(message = "O celular é obrigatório.")
    @Pattern(regexp = "^\\+?[1-9][0-9]{1,14}$", message = "O celular deve ser um número válido no formato internacional.")
    @Size(min = 10, max = 15, message = "O celular deve ter entre 10 e 15 dígitos.")
    private String cellPhone;

    private boolean hasWhatsApp;

    private String profilePicture;

    private UserRoleEnum role;

    @ManyToOne
    @JoinColumn(name = "establishment_id", nullable = true)
    private Establishment establishment;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = true)
    private Address address;
}
