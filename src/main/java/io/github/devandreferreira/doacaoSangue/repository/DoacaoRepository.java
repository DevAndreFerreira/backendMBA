package io.github.devandreferreira.doacaoSangue.repository;

import io.github.devandreferreira.doacaoSangue.entity.Doacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoacaoRepository extends JpaRepository<Doacao, Integer> {

}
