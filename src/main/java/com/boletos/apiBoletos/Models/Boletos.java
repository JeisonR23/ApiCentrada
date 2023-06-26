package com.boletos.apiBoletos.Models;
import javax.persistence.*;



@Entity
@Table(name = "Boletos")
public class Boletos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBoleto;
    private int cantidadBoletos;
    private double price;
    private String tipoAsiento;



    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

     
    public Boletos( int cantidadBoletos, double price, String tipoAsiento) {
        this.cantidadBoletos = cantidadBoletos;
        this.price = price;
        this.tipoAsiento = tipoAsiento;
       
    }



    public Boletos() {

    }



    public Long getBoletoId() {
        return idBoleto;
    }

    public void setBoletoId(Long boletoId) {
        this.idBoleto = boletoId;
    }


    public int getCantidadBoletos() {
        return cantidadBoletos;
    }

    public void setCantidadBoletos(int cantidad) {
        this.cantidadBoletos = cantidad;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTipoAsiento() {
        return tipoAsiento;
    }

    public void setTipoAsiento(String tipo) {
        this.tipoAsiento = tipo;
    }
    
    
}
