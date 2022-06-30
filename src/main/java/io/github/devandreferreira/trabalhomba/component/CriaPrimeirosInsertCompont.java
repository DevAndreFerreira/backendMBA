package io.github.devandreferreira.trabalhomba.component;

import io.github.devandreferreira.trabalhomba.model.Usuario;
import io.github.devandreferreira.trabalhomba.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CriaPrimeirosInsertCompont {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void primeiraInsercao() {
        Usuario usuario = new Usuario();
        usuario.setId_usuario(1);
        usuario.setNome("Admin");
        usuario.setSenha("123");
        usuario.setEmail("admin@admin.com");
        usuarioRepository.save(usuario);
    }


}
