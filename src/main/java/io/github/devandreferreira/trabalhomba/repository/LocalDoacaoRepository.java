package io.github.devandreferreira.trabalhomba.repository;

import io.github.devandreferreira.trabalhomba.entity.LocalDoacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalDoacaoRepository  extends JpaRepository<LocalDoacao, Integer> {
}
