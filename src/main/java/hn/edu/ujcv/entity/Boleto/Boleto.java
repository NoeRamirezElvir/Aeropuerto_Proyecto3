package hn.edu.ujcv.entity.Boleto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "boleto")
public class Boleto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long   id;
    private String codigoFactura;
    private String nombrePasajero;
    private String vuelo;
    private String asiento;
    private String numeroPuertaEmbarque;
    private String clase;
    private double total;
}
