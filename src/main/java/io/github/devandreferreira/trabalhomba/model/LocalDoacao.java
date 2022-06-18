package io.github.devandreferreira.trabalhomba.model;

import io.github.devandreferreira.trabalhomba.dto.LocalDoacaoDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class LocalDoacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_LocalDoacao;
    private String nomeLocal;
    private String nomeRua;
    private String numeroEndereco;
    private String cep;
    private String bairro;
    private String complemento;
    private String cidade;
    private String estado;
    private String telefone;
    private String celular;
    private String email;

    public LocalDoacao() {
    }

    public LocalDoacao(LocalDoacaoDto localDoacaoDto) {
        this.nomeLocal = localDoacaoDto.getNomeLocal();
        this.nomeRua = localDoacaoDto.getNomeRua();
        this.numeroEndereco = localDoacaoDto.getNumeroEndereco();
        this.cep = localDoacaoDto.getCep();
        this.bairro = localDoacaoDto.getBairro();
        this.complemento = localDoacaoDto.getComplemento();
        this.cidade = localDoacaoDto.getCidade();
        this.estado = localDoacaoDto.getEstado();
        this.telefone = localDoacaoDto.getTelefone();
        this.celular = localDoacaoDto.getCelular();
        this.email = localDoacaoDto.getEmail();
    }
}
