package io.github.devandreferreira.trabalhomba.component;

import io.github.devandreferreira.trabalhomba.entity.Usuario;
import io.github.devandreferreira.trabalhomba.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidaLoginSistemaComponent {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario validaLogin(String usuario, String senha) {
        return usuarioRepository.capturaUsuarioESenha(usuario, senha);
    }
}
