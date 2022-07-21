package io.github.devandreferreira.doacaoSangue.dto;

import io.github.devandreferreira.doacaoSangue.entity.LocalDoacao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoacaoDto {

    private LocalDoacaoDto localDoacaoDto;
    private Boolean statusMarcacaoDoacao;

    public DoacaoDto(Boolean status) {
        this.statusMarcacaoDoacao = status;
    }

    public DoacaoDto(LocalDoacao localDoacao) {
        this.localDoacaoDto = new LocalDoacaoDto(localDoacao);
        this.statusMarcacaoDoacao = Boolean.TRUE;
    }
}
