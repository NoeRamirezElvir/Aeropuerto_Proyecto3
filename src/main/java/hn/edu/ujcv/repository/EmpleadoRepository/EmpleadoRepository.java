package hn.edu.ujcv.repository.EmpleadoRepository;

import hn.edu.ujcv.entity.Empleado.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpleadoRepository extends JpaRepository<Empleado,Long> {
    Optional<Empleado> findFirstByNombre(String nombre);
}
