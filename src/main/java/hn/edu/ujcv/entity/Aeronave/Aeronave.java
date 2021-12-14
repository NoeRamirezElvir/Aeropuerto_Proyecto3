package hn.edu.ujcv.entity.Aeronave;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "aeronave")
public class Aeronave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long    id;
    private String modelo;
    private String fabricante;
    private String aerolinea;
    private double tamaño;
    private int    capacidad;
    private String tipo;
}
