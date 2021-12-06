package hn.edu.ujcv.repository.UsuarioRepository;

import hn.edu.ujcv.entity.Usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository{// extends JpaRepository<Usuario,Long> {
    Optional<Usuario> finByCodigo(String codigo);
}
