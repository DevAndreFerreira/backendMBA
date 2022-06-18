package io.github.devandreferreira.trabalhomba.model;

import io.github.devandreferreira.trabalhomba.dto.UsuarioDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_usuario;
    private String nome;
    private String senha;
    private String email;
    private String tipoSangue;

    public Usuario() {
    }

    public Usuario(UsuarioDto usuarioDto) {
        this.nome = usuarioDto.getNome();
        this.senha = usuarioDto.getSenha();
        this.email = usuarioDto.getEmail();
        this.tipoSangue = usuarioDto.getTipoSangue();
    }
}
