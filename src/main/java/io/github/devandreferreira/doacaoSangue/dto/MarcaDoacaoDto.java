package io.github.devandreferreira.doacaoSangue.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarcaDoacaoDto {

    @JsonProperty("localdoacao")
    private Integer id_localdoacao;

    @JsonProperty("codigo_usuario")
    private Integer id_usuario;

}
