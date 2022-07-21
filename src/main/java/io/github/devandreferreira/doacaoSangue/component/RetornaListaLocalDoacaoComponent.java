package io.github.devandreferreira.doacaoSangue.component;

import io.github.devandreferreira.doacaoSangue.entity.LocalDoacao;
import io.github.devandreferreira.doacaoSangue.repository.LocalDoacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RetornaListaLocalDoacaoComponent {

    @Autowired
    private LocalDoacaoRepository localDoacaoRepository;

    public List<LocalDoacao> retornaLocaisDoacao() {
        return localDoacaoRepository.findAll();
    }

}
