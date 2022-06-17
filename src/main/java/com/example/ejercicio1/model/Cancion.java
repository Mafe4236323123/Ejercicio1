package com.example.ejercicio1.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table
public class Cancion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCancion;

    @NotEmpty
    @Column(nullable = false)
    private String nombreCancion;

    @Column
    private Date fechaGrabacion;

    @NotEmpty
    @Size(min=1,max=5)
    @Column(nullable=false, length=5)
    private String duracionCancion;

    @NotNull
    @Column(nullable=false)
    private boolean estadoCancion;

    @NotNull
    private Integer idAlbum;


    public Cancion(){

    }
    
    public Cancion(Integer idCancion, String nombreCancion, Date fechaGrabacion, String duracionCancion, boolean estadoCancion, Integer idAlbum){
        this.idCancion=idCancion;
        this.nombreCancion=nombreCancion;
        this.fechaGrabacion=fechaGrabacion;
        this.duracionCancion=duracionCancion;
        this.estadoCancion=estadoCancion;
        this.idAlbum=idAlbum;
    }

    //-------------------------------------------------

    public void setIdCancion(Integer idCancion) {
        this.idCancion = idCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public void setFechaGrabacion(Date fechaGrabacion) {
        this.fechaGrabacion = fechaGrabacion;
    }

    public void setDuracionCancion(String duracionCancion) {
        this.duracionCancion = duracionCancion;
    }

    public void setEstadoCancion(boolean estadoCancion) {
        this.estadoCancion = estadoCancion;
    }

    public void setIdAlbum(Integer idAlbum) {
        this.idAlbum = idAlbum;
    }

    //---------------------------------------


    public Integer getIdCancion() {
        return idCancion;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public Date getFechaGrabacion() {
        return fechaGrabacion;
    }

    public String getDuracionCancion() {
        return duracionCancion;
    }

    public boolean getEstadoCancion() {
        return estadoCancion;
    }

    public Integer getIdAlbum() {
        return idAlbum;
    }


}

