package io.github.devandreferreira.doacaoSangue.component;

import io.github.devandreferreira.doacaoSangue.entity.LocalDoacao;
import io.github.devandreferreira.doacaoSangue.repository.LocalDoacaoRepository;
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
