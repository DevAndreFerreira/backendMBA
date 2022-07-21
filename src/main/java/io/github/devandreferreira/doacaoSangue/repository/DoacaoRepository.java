package io.github.devandreferreira.doacaoSangue.repository;

import io.github.devandreferreira.doacaoSangue.entity.Doacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoacaoRepository extends JpaRepository<Doacao, String> {

    @Query(value = "SELECT * FROM Doacao WHERE status = :status ", nativeQuery = true)
    List<Doacao> listaDoacaoPorStatus(@Param("status") String status);

}
