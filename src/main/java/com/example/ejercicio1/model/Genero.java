package com.example.ejercicio1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity 
@Table(name="genero")
public class Genero {
    @Id //clave primaria  
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrementable
    private Integer idGenero;

    @Column(length = 20, nullable=false) //longitud y deignación de si se permiten campos nulos
    @NotEmpty //validación - campo obligatorio
    private String nombreGenero;

    @Column(nullable=false)
    private boolean estadoGenero;



    public Genero(){ 
        
    }

    public Genero(Integer idGenero, String nombreGenero, boolean estadoGenero){
        this.idGenero=idGenero;
        this.nombreGenero=nombreGenero;
        this.estadoGenero=estadoGenero;
    }

    //-------------------------------------------
    public void setIdGenero(Integer idGenero){
        this.idGenero=idGenero;
    }

    public Integer getIdGenero(){
        return idGenero;
    }

    //-------------------------------------------

    public void setNombreGenero(String nombreGenero){
        this.nombreGenero=nombreGenero;
    }

    public String getNombreGenero(){
        return nombreGenero;
    }

    //-------------------------------------------

    public void setEstadoGenero(Boolean estadoGenero){
        this.estadoGenero=estadoGenero;
    }

    public boolean getEstadoGenero(){
        return estadoGenero;
    }
    
}
