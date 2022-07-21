package io.github.devandreferreira.doacaoSangue.controller;

import io.github.devandreferreira.doacaoSangue.component.CadastraDoacaoComponent;
import io.github.devandreferreira.doacaoSangue.dto.*;
import io.github.devandreferreira.doacaoSangue.entity.Doacao;
import io.github.devandreferreira.doacaoSangue.entity.Usuario;
import io.github.devandreferreira.doacaoSangue.service.CadastraUsuarioService;
import io.github.devandreferreira.doacaoSangue.service.DoacaoService;
import io.github.devandreferreira.doacaoSangue.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/trabalho")
public class DoacaoSangueController {

    @Autowired
    private LoginService login;

    @Autowired
    private CadastraUsuarioService cadastraUsuario;

    @Autowired
    private DoacaoService doacaoService;

    @GetMapping("/login")
    public ResponseEntity<Object> logaNoSistema(@RequestBody UsuarioDto usuarioDto) {
        Usuario usuario = login.validaLoginSistema(usuarioDto.getLogin(), usuarioDto.getSenha());
        if(usuario == null) {
            return new ResponseEntity<>(new AvisosDto("Usuario ou Senha incorretos!"),HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(new UsuarioDto(usuarioDto.getLogin(), usuario.getId_usuario()), HttpStatus.OK);
    }

   @PostMapping("/criaUsuario")
   public ResponseEntity<Object> cadastraUsuario(@RequestBody @Valid Usuario usuario) {
       usuario = cadastraUsuario.cadastraUsuario(usuario);
       if(usuario == null) {
           return new ResponseEntity<>(new AvisosDto("Usuario já cadastrado!"), HttpStatus.UNPROCESSABLE_ENTITY);
       }
       return new ResponseEntity<>(new AvisosDto("Cadastro realizado com sucesso!"), HttpStatus.CREATED);
   }

    @PostMapping("/criaDoacao")
    public ResponseEntity<Object> cadastraDoacao(@RequestBody @Valid Doacao novaDoacao) {
        Doacao doacao = doacaoService.cadastraDoacao(novaDoacao);
        if(doacao == null) {
            return new ResponseEntity<>(new AvisosDto("Solicitante não encontrado!"), HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return new ResponseEntity<>(new AvisosDto("Cadastro realizado com sucesso!"), HttpStatus.CREATED);
    }

    @GetMapping("/listaDoacao")
    public ResponseEntity<Object> listaDoacao() {
        List<Doacao> doacaos = doacaoService.listaDoacaoAbertas();
        if(doacaos.isEmpty()) {
            return new ResponseEntity<>(new AvisosDto("Nenhuma doacao encontrada"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(doacaos, HttpStatus.OK);
    }
}



