package io.github.devandreferreira.doacaoSangue.dto;

import io.github.devandreferreira.doacaoSangue.entity.LocalDoacao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalDoacaoDto {

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

    public LocalDoacaoDto() {
    }

    public LocalDoacaoDto(LocalDoacao localDoacao) {
        this.nomeLocal = localDoacao.getNomeLocal();
        this.nomeRua = localDoacao.getNomeRua();
        this.numeroEndereco = localDoacao.getNumeroEndereco();
        this.cep = localDoacao.getCep();
        this.bairro = localDoacao.getBairro();
        this.complemento = localDoacao.getComplemento();
        this.cidade = localDoacao.getCidade();
        this.estado = localDoacao.getEstado();
        this.telefone = localDoacao.getTelefone();
        this.celular = localDoacao.getCelular();
        this.email = localDoacao.getEmail();
    }

}
