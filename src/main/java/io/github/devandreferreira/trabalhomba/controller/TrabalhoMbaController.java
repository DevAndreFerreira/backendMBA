package io.github.devandreferreira.trabalhomba.controller;

import io.github.devandreferreira.trabalhomba.component.*;
import io.github.devandreferreira.trabalhomba.dto.*;
import io.github.devandreferreira.trabalhomba.model.LocalDoacao;
import io.github.devandreferreira.trabalhomba.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trabalho")
public class TrabalhoMbaController {

    @Autowired
    private CadastraLocalDoacaoComponent cadastraLocalDoacao;

    @Autowired
    private CadastraUsuarioComponent cadastraUsuario;

    @Autowired
    private RetornaListaLocalDoacaoComponent retornaListaLocalDoacao;

    @Autowired
    private CadastraDoacaoComponent cadastraDoacao;

    @Autowired
    private ValidaLoginSistemaComponent validaLoginSistema;

    @GetMapping("/login")
    public ResponseEntity<Object> logaNoSistema(@RequestBody UsuarioDto usuarioDto) {
        Integer idUsuario = validaLoginSistema.validaLogin(usuarioDto.getNome(), usuarioDto.getSenha());
        if(null != idUsuario) {
            return new ResponseEntity<>(new UsuarioDto(idUsuario), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/criaUsuario")
    public ResponseEntity<Usuario> cadastraUsuario(@RequestBody UsuarioDto usuarioDto) {
        return new ResponseEntity<>(cadastraUsuario.cadastraUsuario(new Usuario(usuarioDto)), HttpStatus.OK);
    }

    @GetMapping("/listaLocais")
    public ResponseEntity<List<LocalDoacao>> pegaLocaisDoacao() {
        return new ResponseEntity<>(retornaListaLocalDoacao.retornaLocaisDoacao(), HttpStatus.OK);
    }

    @PostMapping("/criaLocalDoacao")
    public ResponseEntity<LocalDoacao> cadastraLocalDoacao(@RequestBody LocalDoacaoDto localDoacaoDto) {
        return new ResponseEntity<>(cadastraLocalDoacao.cadastraLocalDoacao(new LocalDoacao(localDoacaoDto)), HttpStatus.OK);
    }

    @PostMapping("/criaDoacao")
    public ResponseEntity<?> criaDoacao(@RequestBody MarcaDoacaoDto marcaDoacaoDto) {
        DoacaoDto doacaoDto = cadastraDoacao.cadastraDoacao(marcaDoacaoDto);
        if(doacaoDto.getStatusMarcacaoDoacao() == Boolean.TRUE) {
            return new ResponseEntity<>(doacaoDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(new AvisosDto("Não foi possível realizar cadastramento de doação"),HttpStatus.UNPROCESSABLE_ENTITY);
    }

}
