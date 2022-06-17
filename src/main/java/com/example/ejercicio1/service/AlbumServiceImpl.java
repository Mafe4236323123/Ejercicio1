package com.example.ejercicio1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ejercicio1.model.Album;
import com.example.ejercicio1.model.IAlbum;

@Service
public class AlbumServiceImpl implements IAlbumService{

    @Autowired
    private IAlbum ialbum;

    @Override
    public List<Album> findAll() {
        return (List<Album>) ialbum.findAll();
    }

    @Override
    public void save(Album album){
        ialbum.save(album);
    }

    @Override
    public Album findOne(Integer id){
        return ialbum.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        ialbum.deleteById(id);
        
    }    
    
    
}
