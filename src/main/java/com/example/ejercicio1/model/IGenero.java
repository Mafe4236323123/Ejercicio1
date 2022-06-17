package com.example.ejercicio1.model;

import java.util.List;

public interface IGenero {
    
    public List<Genero> findAll();
    public void save (Genero genero);
    public Genero findOne(Integer idGenero);
    public void delete(Integer idGenero);
}


