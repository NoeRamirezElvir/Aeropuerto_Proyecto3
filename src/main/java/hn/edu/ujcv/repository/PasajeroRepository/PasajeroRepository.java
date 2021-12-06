package hn.edu.ujcv.repository.PasajeroRepository;

import hn.edu.ujcv.entity.Pasajero.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PasajeroRepository extends JpaRepository<Pasajero,Long> {
    Optional<Pasajero> findByNombre(String nombre);
}
