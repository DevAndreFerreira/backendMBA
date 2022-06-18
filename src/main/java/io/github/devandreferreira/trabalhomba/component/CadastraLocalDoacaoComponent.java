package io.github.devandreferreira.trabalhomba.component;

import io.github.devandreferreira.trabalhomba.model.LocalDoacao;
import io.github.devandreferreira.trabalhomba.repository.LocalDoacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastraLocalDoacaoComponent {

    @Autowired
    private LocalDoacaoRepository localDoacaoRepository;

    public LocalDoacao cadastraLocalDoacao(LocalDoacao localDoacao) {
        return localDoacaoRepository.save(localDoacao);
    }

}
