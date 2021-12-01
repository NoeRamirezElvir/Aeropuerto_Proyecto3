package hn.edu.ujcv.entity.Empleado;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "empleado")
public class Empleado {
    private long DNI;
    private int codigo;
    private String nombre;
    private int edad;
    private Date fechaIngreso;
    private String cargo;
    private String direccion;
    private String correoElectronico;
}
