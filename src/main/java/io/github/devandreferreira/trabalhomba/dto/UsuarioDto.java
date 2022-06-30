package io.github.devandreferreira.trabalhomba.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nome;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String senha;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String email;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String tipoSangue;

    public UsuarioDto() {}

    public UsuarioDto(Integer id) {
        this.id = id;
    }

}
