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
    private Date fechaRegistro;
    private String destino;
    private String color;
    private String tamaño;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getBoleto() {
        return boleto;
    }
    public void setBoleto(long boleto) {
        this.boleto = boleto;
    }
    public String getPasajero() {
        return pasajero;
    }
    public void setPasajero(String pasajero) {
        this.pasajero = pasajero;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public Date getFechaRegistro() {
        return fechaRegistro;
    }
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public String getDestino() {
        return destino;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getTamaño() {
        return tamaño;
    }
    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }
}
