package com.example.ejercicio1.service;

import java.util.List;
import com.example.ejercicio1.model.Album;
 
public interface IAlbumService {
    public List<Album> findAll();
    public void save (Album album);
    public Album findOne(Integer id);
    public void delete(Integer id);
    
}
