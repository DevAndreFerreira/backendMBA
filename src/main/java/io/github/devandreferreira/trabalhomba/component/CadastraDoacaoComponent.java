package io.github.devandreferreira.trabalhomba.component;

import io.github.devandreferreira.trabalhomba.dto.DoacaoDto;
import io.github.devandreferreira.trabalhomba.dto.MarcaDoacaoDto;
import io.github.devandreferreira.trabalhomba.model.Doacao;
import io.github.devandreferreira.trabalhomba.model.LocalDoacao;
import io.github.devandreferreira.trabalhomba.model.Usuario;
import io.github.devandreferreira.trabalhomba.repository.DoacaoRepository;
import io.github.devandreferreira.trabalhomba.repository.LocalDoacaoRepository;
import io.github.devandreferreira.trabalhomba.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastraDoacaoComponent {

    @Autowired
    private LocalDoacaoRepository localDoacaoRepository;

    @Autowired
    private DoacaoRepository doacaorepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public DoacaoDto cadastraDoacao(MarcaDoacaoDto marcacaoDto) {

        if(localDoacaoRepository.findById(marcacaoDto.getId_localdoacao()).isPresent()
                && usuarioRepository.findById(marcacaoDto.getId_usuario()).isPresent()) {
            LocalDoacao localDoacao = localDoacaoRepository.findById(marcacaoDto.getId_localdoacao()).get();
            Usuario usuario = usuarioRepository.findById(marcacaoDto.getId_usuario()).get();
            Doacao doacao = new Doacao();
            doacao.setLocalDoacao(localDoacao);
            doacao.setUsuario(usuario);
            doacaorepository.save(doacao);
            return new DoacaoDto(localDoacao);
        }
        return new DoacaoDto(Boolean.FALSE);
    }


}
