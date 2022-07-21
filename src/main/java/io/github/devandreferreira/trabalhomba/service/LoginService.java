package io.github.devandreferreira.trabalhomba.service;

import io.github.devandreferreira.trabalhomba.component.ValidaLoginSistemaComponent;
import io.github.devandreferreira.trabalhomba.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private ValidaLoginSistemaComponent validaLoginSistema;

    public Usuario validaLoginSistema(String nome, String senha) {
        if (nome == null || senha == null) {
            return null;
        }
        return validaLoginSistema.validaLogin(nome, senha);
    }
}
