package io.github.devandreferreira.doacaoSangue.service;

import io.github.devandreferreira.doacaoSangue.component.CadastraDoacaoComponent;
import io.github.devandreferreira.doacaoSangue.component.ListaDoacaoComponent;
import io.github.devandreferreira.doacaoSangue.component.ValidaUsuarioSistemaComponent;
import io.github.devandreferreira.doacaoSangue.entity.Doacao;
import io.github.devandreferreira.doacaoSangue.enumeration.UtilEnum;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DoacaoService {

    @Autowired
    private CadastraDoacaoComponent cadastraDoacao;

    @Autowired
    private ListaDoacaoComponent listaDoacaoComponent;

    @Autowired
    private ValidaUsuarioSistemaComponent validaUsuarioSistema;

    public Doacao cadastraDoacao(Doacao doacao) {
        if (validaUsuarioSistema.validaUsuario(doacao.getId_solicitante())) {
            doacao.setId(RandomStringUtils.randomAlphanumeric(20, 20));
            doacao.setTipoDoacao(UtilEnum.SOLICITACAO_DOACAO.toString());
            doacao.setStatus(UtilEnum.AGUARDANDO_DOADOR.toString());
            return cadastraDoacao.cadastraDoacao(doacao);
        }
        return null;
    }

    public List<Doacao> listaDoacaoAbertas() {
        return listaDoacaoComponent.listaDoacao(UtilEnum.AGUARDANDO_DOADOR.toString());
    }

}
