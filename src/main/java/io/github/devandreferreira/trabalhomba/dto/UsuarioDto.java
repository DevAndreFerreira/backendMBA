package io.github.devandreferreira.trabalhomba.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDto {

    private String nome;
    private String senha;
    private String email;
    private String tipoSangue;

}
