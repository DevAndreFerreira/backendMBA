package io.github.devandreferreira.doacaoSangue.component;

import io.github.devandreferreira.doacaoSangue.entity.Doacao;
import io.github.devandreferreira.doacaoSangue.repository.DoacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListaDoacaoComponent {

    @Autowired
    private DoacaoRepository doacaoRepository;

    public List<Doacao> listaDoacao(String status) {
        return doacaoRepository.listaDoacaoPorStatus(status);
    }

}
