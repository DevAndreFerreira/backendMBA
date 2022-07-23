package io.github.devandreferreira.doacaoSangue.controller;

import io.github.devandreferreira.doacaoSangue.dto.*;
import io.github.devandreferreira.doacaoSangue.entity.Doacao;
import io.github.devandreferreira.doacaoSangue.entity.Usuario;
import io.github.devandreferreira.doacaoSangue.service.CadastraUsuarioService;
import io.github.devandreferreira.doacaoSangue.service.DoacaoService;
import io.github.devandreferreira.doacaoSangue.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public ResponseEntity<Object> listaDoacao(@RequestParam(name = "page", defaultValue = "1") String page, @RequestParam(name = "size", defaultValue = "1") String size) {
        Page<Doacao> doacaos = doacaoService.listaDoacaoAbertas(Integer.valueOf(page), Integer.valueOf(size));
        if(doacaos.isEmpty()) {
            return new ResponseEntity<>(new AvisosDto("Nenhuma doacao encontrada"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(doacaos, HttpStatus.OK);
    }

    @GetMapping("/listaDoacaoComDoador")
    public ResponseEntity<Object> listaDoacaoComDoador(@RequestParam(name = "page", defaultValue = "1") String page, @RequestParam(name = "size", defaultValue = "1") String size) {
        Page<Doacao> doacaos = doacaoService.listaDoacaoComDoador(Integer.valueOf(page), Integer.valueOf(size));
        if(doacaos.isEmpty()) {
            return new ResponseEntity<>(new AvisosDto("Nenhuma doacao encontrada"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(doacaos, HttpStatus.OK);
    }

    @GetMapping("/lista")
    public ResponseEntity<Object> listaTudo(@RequestParam(name = "page", defaultValue = "1") String page, @RequestParam(name = "size", defaultValue = "1") String size) {
        Page<Doacao> doacaos = doacaoService.lista(Integer.valueOf(page), Integer.valueOf(size));
        if(doacaos.isEmpty()) {
            return new ResponseEntity<>(new AvisosDto("Nenhuma doacao encontrada"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(doacaos, HttpStatus.OK);
    }

    @PutMapping("/atualizaDoacao/{id_doacao}")
    public ResponseEntity<Object> atualizaDoacao(@PathVariable String id_doacao, @RequestBody DoadorDto doadorDto) {
        Doacao doacao = doacaoService.atualizaDoacao(id_doacao, doadorDto);
        if(doacao == null) {
            return new ResponseEntity<>(new AvisosDto("Doacao ou Doador inválidos"), HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return new ResponseEntity<>(doacao, HttpStatus.OK);
    }

    @GetMapping("/historicoSolicitacao")
    public ResponseEntity<Object> listaDoacoesPorSolicitante(@RequestParam(name = "idSolicitante", required = true) String id,
                                                             @RequestParam(name = "page", defaultValue = "1") String page,
                                                             @RequestParam(name = "size", defaultValue = "1") String size) {
        Page<Doacao> doacaos = doacaoService.listaSolicitacoesPorNomePessoa(id, Integer.valueOf(page), Integer.valueOf(size));
        if(doacaos.isEmpty()) {
            return new ResponseEntity<>(new AvisosDto("Nenhuma doacao encontrada"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(doacaos, HttpStatus.OK);
    }

    @GetMapping("/historicoDoador")
    public ResponseEntity<Object> listaDoacoesPorDoador(@RequestParam(name = "idDoador", required = true) String id,
                                                        @RequestParam(name = "page", defaultValue = "1") String page,
                                                        @RequestParam(name = "size", defaultValue = "1") String size) {
        Page<Doacao> doacaos = doacaoService.listaDoadoresPorNomeDoador(id, Integer.valueOf(page), Integer.valueOf(size));
        if(doacaos.isEmpty()) {
            return new ResponseEntity<>(new AvisosDto("Nenhuma doacao encontrada"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(doacaos, HttpStatus.OK);
    }

}



