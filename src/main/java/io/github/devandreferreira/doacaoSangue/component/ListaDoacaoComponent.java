package io.github.devandreferreira.doacaoSangue.component;

import io.github.devandreferreira.doacaoSangue.entity.Doacao;
import io.github.devandreferreira.doacaoSangue.repository.DoacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class ListaDoacaoComponent {

    @Autowired
    private DoacaoRepository doacaoRepository;

    public Page<Doacao> listaDoacao(String status, Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "timestamp");
        return doacaoRepository.listaDoacaoPorStatus(status, pageRequest);
    }

    public Page<Doacao> lista(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "timestamp");
        return doacaoRepository.findAll(pageRequest);
    }

    public Page<Doacao> listaSolicitacoes(String id_solicitante, Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "timestamp");
        return doacaoRepository.listaSolicitacoesPorPessoa(id_solicitante, pageRequest);
    }

    public Page<Doacao> listaDoador(String id_doador, Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "timestamp");
        return doacaoRepository.listaDoacoesPorDoador(id_doador, pageRequest);
    }
}
