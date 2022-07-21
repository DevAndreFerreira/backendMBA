package io.github.devandreferreira.doacaoSangue.service;

import io.github.devandreferreira.doacaoSangue.component.CadastraUsuarioComponent;
import io.github.devandreferreira.doacaoSangue.entity.Usuario;
import io.github.devandreferreira.doacaoSangue.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.RandomStringUtils;

@Service
public class CadastraUsuarioService {

    @Autowired
    private CadastraUsuarioComponent cadastraUsuario;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario cadastraUsuario(Usuario usuario) {
        if(usuarioRepository.capturaUsuarioESenha(usuario.getLogin(), usuario.getSenha()) != null) {
            return null;
        }
        usuario.setId_usuario(RandomStringUtils.randomAlphanumeric(20, 20));
        return cadastraUsuario.cadastraUsuario(usuario);
    }

}
