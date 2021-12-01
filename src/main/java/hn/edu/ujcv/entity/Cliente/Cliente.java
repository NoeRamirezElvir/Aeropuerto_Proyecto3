package hn.edu.ujcv.entity.Cliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {
    private long   DNI;
    private String nombre;
    private int    edad;
    private int    numeroBoleto;
    private int    numeroVisa;
    private long   telefono;
    private String direccion;
    private String correoElectronico;
}
