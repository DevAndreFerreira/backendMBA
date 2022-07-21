package io.github.devandreferreira.doacaoSangue.component;

import io.github.devandreferreira.doacaoSangue.dto.DoadorDto;
import io.github.devandreferreira.doacaoSangue.entity.Doacao;
import io.github.devandreferreira.doacaoSangue.enumeration.UtilEnum;
import io.github.devandreferreira.doacaoSangue.repository.DoacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AtualizaDoacaoComponent {

    @Autowired
    private ValidaUsuarioSistemaComponent validaUsuarioSistema;

    @Autowired
    private CadastraDoacaoComponent cadastraDoacao;

    @Autowired
    private DoacaoRepository doacaoRepository;

    public Doacao atualizaDoacaoComDoador(String idDoacao, DoadorDto doadorDto) {
        if(validaUsuarioSistema.validaUsuario(doadorDto.getIdDoador())) {
            Optional<Doacao> doacaoById = doacaoRepository.findById(idDoacao);
            if (doacaoById.isPresent()) {
                Doacao doacao = doacaoById.get();
                doacao.setStatus(UtilEnum.DOADOR_ENCONTRADO.toString());
                doacao.setId_doador(doadorDto.getIdDoador());
                doacao.setNomeDoador(doadorDto.getNomeDoador());
                return doacaoRepository.save(doacao);
            }
        }
        return null;
    }

}
