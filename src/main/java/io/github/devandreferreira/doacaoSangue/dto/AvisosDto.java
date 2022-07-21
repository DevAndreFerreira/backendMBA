package io.github.devandreferreira.doacaoSangue.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvisosDto {

    private String avisos;

    public AvisosDto(String avisos) {
        this.avisos = avisos;
    }
}
