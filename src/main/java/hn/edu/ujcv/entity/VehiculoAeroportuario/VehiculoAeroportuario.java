package hn.edu.ujcv.entity.VehiculoAeroportuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehiculoAeroportuario")
public class VehiculoAeroportuario {
    private int    codigo;
    private String numeroPlaca;
    private String tipo;
    private String descripcion;
    private String tipoCombustible;
    private int    capacidad;
}
