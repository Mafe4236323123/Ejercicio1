package com.example.ejercicio1.service;

import java.util.List;
import com.example.ejercicio1.model.Cancion;

public interface ICancionService {

    public List<Cancion> findAll();
    public void save(Cancion cancion);  
    public Cancion findOne(Integer id);
    public void delete(Integer id);
    
}
