package io.github.devandreferreira.trabalhomba.repository;

import io.github.devandreferreira.trabalhomba.model.Doacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Doacaorepository extends JpaRepository<Doacao, Integer> {

}
