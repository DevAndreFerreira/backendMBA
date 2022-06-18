package io.github.devandreferreira.trabalhomba.repository;

import io.github.devandreferreira.trabalhomba.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>  {


}
