package io.github.devandreferreira.trabalhomba.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
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
