package hn.edu.ujcv.repository.AeronaveRepository;

import hn.edu.ujcv.entity.Aeronave.Aeronave;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AeronaveRepository extends JpaRepository<Aeronave,Long> {
    Optional<Aeronave> findByModelo(String descripcion);
}
