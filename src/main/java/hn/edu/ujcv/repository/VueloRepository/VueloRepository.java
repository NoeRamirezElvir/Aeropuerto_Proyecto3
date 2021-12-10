package hn.edu.ujcv.repository.VueloRepository;

import hn.edu.ujcv.entity.Vuelo.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VueloRepository extends JpaRepository<Vuelo,Long> {
    Optional<Vuelo> findByDestino(String Destino);
}
