package io.github.devandreferreira.trabalhomba.component;

import io.github.devandreferreira.trabalhomba.model.Usuario;
import io.github.devandreferreira.trabalhomba.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastraUsuarioComponent {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario cadastraUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }


}
