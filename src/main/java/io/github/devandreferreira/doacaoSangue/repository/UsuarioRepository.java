package io.github.devandreferreira.doacaoSangue.repository;

import io.github.devandreferreira.doacaoSangue.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>  {

    @Query(value = "SELECT * FROM Usuario WHERE login = :login AND senha = :senha", nativeQuery = true)
    Usuario capturaUsuarioESenha(@Param("login") String login, @Param("senha") String senha);

}
