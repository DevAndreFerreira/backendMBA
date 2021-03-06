package io.github.devandreferreira.doacaoSangue.service;

import io.github.devandreferreira.doacaoSangue.component.ValidaUsuarioSistemaComponent;
import io.github.devandreferreira.doacaoSangue.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private ValidaUsuarioSistemaComponent validaLoginSistema;

    public Usuario validaLoginSistema(String nome, String senha) {
        if (nome == null || senha == null) {
            return null;
        }
        return validaLoginSistema.validaLogin(nome, senha);
    }
}
