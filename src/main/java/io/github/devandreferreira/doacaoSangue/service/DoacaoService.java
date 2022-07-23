package io.github.devandreferreira.doacaoSangue.service;

import io.github.devandreferreira.doacaoSangue.component.AtualizaDoacaoComponent;
import io.github.devandreferreira.doacaoSangue.component.CadastraDoacaoComponent;
import io.github.devandreferreira.doacaoSangue.component.ListaDoacaoComponent;
import io.github.devandreferreira.doacaoSangue.component.ValidaUsuarioSistemaComponent;
import io.github.devandreferreira.doacaoSangue.dto.DoadorDto;
import io.github.devandreferreira.doacaoSangue.entity.Doacao;
import io.github.devandreferreira.doacaoSangue.enumeration.UtilEnum;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class DoacaoService {

    @Autowired
    private CadastraDoacaoComponent cadastraDoacao;

    @Autowired
    private ListaDoacaoComponent listaDoacaoComponent;

    @Autowired
    private ValidaUsuarioSistemaComponent validaUsuarioSistema;

    @Autowired
    private AtualizaDoacaoComponent atualizaDoacao;

    public Doacao cadastraDoacao(Doacao doacao) {
        if (validaUsuarioSistema.validaUsuario(doacao.getId_solicitante())) {
            doacao.setId(RandomStringUtils.randomAlphanumeric(20, 20));
            doacao.setStatus(UtilEnum.AGUARDANDO_DOADOR.toString());
            doacao.setTimestamp(LocalDateTime.now());
            return cadastraDoacao.cadastraDoacao(doacao);
        }
        return null;
    }

    public Page<Doacao> listaDoacaoAbertas(Integer page, Integer size) {
        return listaDoacaoComponent.listaDoacao(UtilEnum.AGUARDANDO_DOADOR.toString(), page, size);
    }

    public Page<Doacao> listaDoacaoComDoador(Integer page, Integer size) {
        return listaDoacaoComponent.listaDoacao(UtilEnum.DOADOR_ENCONTRADO.toString(), page, size);
    }

    public Page<Doacao> lista(Integer page, Integer size) {
        return listaDoacaoComponent.lista(page, size);
    }

    public Page<Doacao> listaSolicitacoesPorNomePessoa(String id_solicitante, Integer page, Integer size) {
        return listaDoacaoComponent.listaSolicitacoes(id_solicitante, page, size);
    }

    public Page<Doacao> listaDoadoresPorNomeDoador(String id_doador, Integer page, Integer size) {
        return listaDoacaoComponent.listaDoador(id_doador, page, size);
    }

    public Doacao atualizaDoacao(String idDoacao, DoadorDto doadorDto) {
        return atualizaDoacao.atualizaDoacaoComDoador(idDoacao, doadorDto);
    }

}
