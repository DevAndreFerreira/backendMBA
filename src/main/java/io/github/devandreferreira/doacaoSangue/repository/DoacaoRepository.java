package io.github.devandreferreira.doacaoSangue.repository;

import io.github.devandreferreira.doacaoSangue.entity.Doacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DoacaoRepository extends JpaRepository<Doacao, String> {

    @Query(value = "SELECT * FROM Doacao WHERE status = :status ", nativeQuery = true)
    Page<Doacao> listaDoacaoPorStatus(@Param("status") String status, Pageable pageable);

    @Query(value = "SELECT * FROM Doacao WHERE id_solicitante = :solicitante ", nativeQuery = true)
    Page<Doacao> listaSolicitacoesPorPessoa(@Param("solicitante") String id_solicitante, Pageable pageable);

    @Query(value = "SELECT * FROM Doacao WHERE id_doador = :doador ", nativeQuery = true)
    Page<Doacao> listaDoacoesPorDoador(@Param("doador") String id_doador, Pageable pageable);

}
