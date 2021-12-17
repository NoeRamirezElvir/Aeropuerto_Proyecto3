package hn.edu.ujcv.repository.EquipajeRepository;

import hn.edu.ujcv.entity.Equipaje.Equipaje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EquipajeRepository extends JpaRepository<Equipaje, Long> {
    Optional<Equipaje> findFirstByPasajero(String pasajero);
}
