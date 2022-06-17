package com.example.ejercicio1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ejercicio1.model.Cancion;
import com.example.ejercicio1.model.ICancion;

@Service
public class CancionServiceImpl implements ICancionService{
    @Autowired
    private ICancion icancion;

    @Override
    public List<Cancion> findAll(){
        return (List<Cancion>) icancion.findAll();
    }

    @Override
    public void save(Cancion cancion){
        icancion.save(cancion);
    }

    @Override
    public Cancion findOne(Integer id){
        return icancion.findById(id).orElse(null);
    }

    @Override 
    public void delete(Integer id){
        icancion.deleteById(id);
    }
    
}
