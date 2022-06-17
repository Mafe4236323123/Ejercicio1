package com.example.ejercicio1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAlbum;

    @NotEmpty
    @Column(length = 20, nullable=false)
    private String nombreAlbum;

    @NotEmpty
    @Column(length = 10, nullable=false)
    private String anioPublicacion;
    
    @NotNull
    @Column(nullable=false)
    private Integer idArtista;

    @NotNull
    @Column(nullable=false)
    private Integer idGenero;

    @NotNull
    @Column(nullable=false)
    private boolean estadoAlbum;

    public Album(){
        
    }

    public Album(Integer idAlbum, String nombreAlbum, String anioPublicacion, Integer idArtista, Integer idGenero, boolean estadoAlbum){
        this.idAlbum=idAlbum;
        this.nombreAlbum=nombreAlbum;
        this.anioPublicacion=anioPublicacion;
        this.idArtista=idArtista;
        this.idGenero=idGenero;
        this.estadoAlbum=estadoAlbum;
    }

    //--------------------------------------------------

    public void setIdAlbum(Integer idAlbum){
        this.idAlbum=idAlbum;
    }
    public Integer getIdAlbum(){
        return idAlbum;
    }

    //--------------------------------------------------

    public void setNombreAlbum(String nombreAlbum){
        this.nombreAlbum=nombreAlbum;
    }
    public String getNombreAlbum(){
        return nombreAlbum;
    }

    //--------------------------------------------------

    public void setAnioPublicacion(String anioPublicacion){
        this.anioPublicacion=anioPublicacion;
    }
    public String getAnioPublicacion(){
        return anioPublicacion;
    }

    //--------------------------------------------------

    public void setIdArtista(Integer idArtista){
        this.idArtista=idArtista;
    }
    public Integer getIdArtista(){
        return idArtista;
    }

    //-------------------------------------------------

    public void setIdGenero(Integer idGenero){
        this.idGenero=idGenero;
    }
    public Integer getIdGenero(){
        return idGenero;
    }

    //------------------------------------------------
    
    public void setEstadoAlbum(boolean estadoAlbum){
        this.estadoAlbum=estadoAlbum;
    }
    public Boolean getEstadoAlbum(){
        return estadoAlbum;
    }
}
