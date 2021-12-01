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
    private int    Id;
    private String modelo;
    private String descripcion;
    private String ruta;
    private String tam;
    private int    capacidad;
    private String tipo;
}
