package com.example.ejercicio1.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class GeneroDao implements IGenero{
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)

    @Override
    public List<Genero> findAll(){
        return em.createQuery("from Genero").getResultList();
    }

    @Transactional
    @Override
    public void save(Genero genero) {
        if (genero.getIdGenero() != null && genero.getIdGenero() > 0) {
			em.merge(genero);
		} else {
			em.persist(genero);
		}
    }

    @Override
    @Transactional(readOnly = true)
    public Genero findOne(Integer idGenero) {
        
        return em.find(Genero.class, idGenero);
    }

    @Override
    @Transactional
    public void delete(Integer idGenero) {
        em.remove(findOne(idGenero));
    }   

    
}
