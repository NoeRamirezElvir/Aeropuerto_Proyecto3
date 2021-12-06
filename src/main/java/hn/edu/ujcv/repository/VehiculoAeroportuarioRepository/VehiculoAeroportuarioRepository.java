package hn.edu.ujcv.repository.VehiculoAeroportuarioRepository;

import hn.edu.ujcv.entity.VehiculoAeroportuario.VehiculoAeroportuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehiculoAeroportuarioRepository extends JpaRepository<VehiculoAeroportuario,Long> {
    Optional<VehiculoAeroportuario> findByCodigo(String codigo);
}
