package io.github.devandreferreira.doacaoSangue.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
public class Doacao {

    @Id
    private String id;

    @NotBlank(message = "Campo obrigatorio")
    private String id_solicitante;

    @NotBlank(message = "Campo obrigatorio")
    private String nomeSolicitante;

    @NotBlank(message = "Campo obrigatorio")
    private String nomeLocalDoacao;

    @NotBlank(message = "Campo obrigatorio")
    private String tipoSangue;

    @NotBlank(message = "Campo obrigatorio")
    private String descricao;

    private String status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id_doador;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nomeDoador;

    public Doacao() {}


}
