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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long   id;
    private int    codigo;
    private String correoElectronico;
    private String departamento;
    private double sueldo;
    private Date   fechaIngreso;
    private String cargo;
    private String horario;
    private String nombre;
}
