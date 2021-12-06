package hn.edu.ujcv.entity.Pasajero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pasajero")
public class Pasajero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long   id;
    private String codigo;
    private String categoria;
    private long   telefono;
    private String tipoDocumento;
    private String idDocumento;
    private String nacionalidad;
    private String nombre;
}
