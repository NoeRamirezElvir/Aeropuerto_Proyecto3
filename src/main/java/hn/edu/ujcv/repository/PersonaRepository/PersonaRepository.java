package hn.edu.ujcv.repository.PersonaRepository;

import hn.edu.ujcv.entity.Persona.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona,Long> {
    Optional<Persona> findFirstByNombre(String nombre);
}
