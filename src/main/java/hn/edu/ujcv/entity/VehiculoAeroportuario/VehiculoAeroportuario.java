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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long   id;
    private String codigo;
    private String numeroPlaca;
    private String tipo;
    private String descripcion;
    private String estado;
    private String tipoCombustible;
    private int    capacidad;
}
