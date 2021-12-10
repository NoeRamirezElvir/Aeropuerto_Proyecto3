package hn.edu.ujcv.repository.LocalComercialRepository;

import hn.edu.ujcv.entity.LocalComercial.LocalComercial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocalComercialRepository extends JpaRepository<LocalComercial, Long> {
    Optional<LocalComercial> findByName(String nombre);
}
