package io.github.devandreferreira.doacaoSangue.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Doacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_LocalDoacao")
    private LocalDoacao localDoacao;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Doacao() {}


}
