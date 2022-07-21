package io.github.devandreferreira.doacaoSangue.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Getter
@Setter
@Entity
public class Usuario {

    @Id
    private String id_usuario;

    @NotBlank(message = "Campo obrigatorio")
    private String nome;
    @NotBlank(message = "Campo obrigatorio")
    private String sobrenome;
    @NotBlank(message = "Campo obrigatorio")
    private String login;

    @NotBlank(message = "Campo obrigatorio")
    @Size(min = 8, message = "Campo precisa ser maior do que 8 caracteres")
    private String senha;

    @Email(message = "Campo invalido")
    @NotBlank(message = "Campo obrigatorio")
    private String email;

    @Size(max = 3, message = "Campo invalido")
    @NotBlank(message = "Campo obrigatorio")
    private String tipoSangue;

    @Size(min = 11, max = 11, message = "Cpf invalido")
    @NotBlank(message = "Campo obrigatorio")
    private String cpf;

    public Usuario() {
    }

}
