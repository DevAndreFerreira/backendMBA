package io.github.devandreferreira.trabalhomba.component;

import io.github.devandreferreira.trabalhomba.model.Usuario;
import io.github.devandreferreira.trabalhomba.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidaLoginSistemaComponent {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CriaPrimeirosInsertCompont criaPrimeirosInsertCompont;

    public Integer validaLogin(String usuario, String senha) {

        Integer id = null;
        criaPrimeirosInsertCompont.primeiraInsercao();

        List<Usuario> listaUsuario = usuarioRepository.findAll();
        for (Usuario user: listaUsuario) {
            if(user.getNome().equals(usuario) && user.getSenha().equals(senha)) {
                id = user.getId_usuario();
                break;
            }
        }
        return id;
    }

}
