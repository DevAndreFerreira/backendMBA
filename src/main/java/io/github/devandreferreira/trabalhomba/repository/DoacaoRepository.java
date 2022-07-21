package io.github.devandreferreira.trabalhomba.repository;

import io.github.devandreferreira.trabalhomba.entity.Doacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoacaoRepository extends JpaRepository<Doacao, Integer> {

}
