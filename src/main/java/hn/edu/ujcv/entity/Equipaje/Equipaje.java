package hn.edu.ujcv.entity.Equipaje;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "equipaje")
public class Equipaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long boleto;
    private String pasajero;
    private double peso;
    private String fechaRegistro;
    private String destino;
    private String color;
    private String tamaño;
}
