package io.github.devandreferreira.trabalhomba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarcaDoacaoDto {

    @JsonProperty("localretirada")
    private Integer id_localRetirada;

    @JsonProperty("codigo_usuario")
    private Integer id_usuario;

}
