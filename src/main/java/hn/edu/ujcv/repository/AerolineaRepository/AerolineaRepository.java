package hn.edu.ujcv.repository.AerolineaRepository;

import hn.edu.ujcv.entity.Aerolinea.Aerolinea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AerolineaRepository extends JpaRepository<Aerolinea, Long> {
    Optional<Aerolinea> findByNombre(String name);
}
