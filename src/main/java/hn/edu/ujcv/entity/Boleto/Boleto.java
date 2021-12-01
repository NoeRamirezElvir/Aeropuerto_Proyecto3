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
@Table(name = "boletos")
public class Boleto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long   Id;
    private String nombreCliente;
    private Date   fecha;
    private String asiento;
    private String horaPartida;
    private String equipaje;
    private String clase;
}
