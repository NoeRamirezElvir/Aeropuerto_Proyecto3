package hn.edu.ujcv.entity.Vuelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vuelos")
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date fecha;
    private String lugarPartida;
    private String horaP;
    private String destino;
    private String aerolinea;
    private String TiempoE;
    private String descripcion;

    //HH:mm:ss formato a usar, pasar a string.

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getLugarPartida() {
        return lugarPartida;
    }
    public void setLugarPartida(String lugarPartida) {
        this.lugarPartida = lugarPartida;
    }
    public String getHoraP() {
        return horaP;
    }
    public void setHoraP(String horaP) {
        this.horaP = horaP;
    }
    public String getDestino() {
        return destino;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }
    public String getAerolinea() {
        return aerolinea;
    }
    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }
    public String getTiempoE() {
        return TiempoE;
    }
    public void setTiempoE(String tiempoE) {
        TiempoE = tiempoE;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
