package com.boletos.apiBoletos.Models;
import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Eventos")
public class Evento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventoId;
    private String nombreEvento;
    private String descripcion;
    private Date fechaEvento;
    private String ubicacion;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
    private Set<Boletos> boletos;
    


    public Evento( String nombreEvento, String descripcion, Date fechaEvento, String ubicacion) {
        this.nombreEvento = nombreEvento;
        this.descripcion = descripcion;
        this.fechaEvento = fechaEvento;
        this.ubicacion = ubicacion;
       
    }



    public Evento() {

    }



    public Long getEventoId() {
        return eventoId;
    }

    public void setEventoId(Long eventoId) {
        this.eventoId = eventoId;
    }


    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombre) {
        this.nombreEvento = nombre;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fechaEvento;
    }

    public void setFecha(Date fecha) {
        this.fechaEvento = fecha;
    }
    


    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

  



}
