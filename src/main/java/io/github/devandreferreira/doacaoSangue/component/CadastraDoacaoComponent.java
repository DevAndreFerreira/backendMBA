package io.github.devandreferreira.doacaoSangue.component;
import io.github.devandreferreira.doacaoSangue.entity.Doacao;
import io.github.devandreferreira.doacaoSangue.repository.DoacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastraDoacaoComponent {

    @Autowired
    private DoacaoRepository doacaoRepository;

    public Doacao cadastraDoacao(Doacao doacao) {
         return doacaoRepository.save(doacao);
    }

}
