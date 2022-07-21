package io.github.devandreferreira.doacaoSangue.repository;

import io.github.devandreferreira.doacaoSangue.entity.LocalDoacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalDoacaoRepository  extends JpaRepository<LocalDoacao, Integer> {
}
