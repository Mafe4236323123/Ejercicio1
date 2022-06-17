package com.example.ejercicio1.controller;

import javax.validation.Valid;

import com.example.ejercicio1.model.Genero;
import com.example.ejercicio1.model.IGenero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("genero")
@RequestMapping("/genero")
public class GeneroController {

    @Autowired
    private IGenero igenero;
    

    @GetMapping(path = "/lista")
        public String listar(Model m){

            m.addAttribute("genero", igenero.findAll());
            return "view/Genero/list";
        }


    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model m){
        Genero genero=null;
        if(id>0){
            genero=igenero.findOne(id);
        }else{
            return "redirect:lista";
        }
        m.addAttribute("genero", genero);
        m.addAttribute("accion", "Editar");
        return "view/genero/add";
    }

    @GetMapping(path = "/agregar")
        public String abrirForm(Model m){
            Genero genero = new Genero();
            m.addAttribute("genero", genero);
            m.addAttribute("accion", "Agregar ");
            return "view/genero/add";
    }


    @PostMapping(path ="/add")
        public String add(@Valid Genero genero, BindingResult res, Model m, SessionStatus status){
            if(res.hasErrors()){
                return "view/genero/add";
            }

            igenero.save(genero);
            status.setComplete();
            return "redirect:lista";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
		
		if(id > 0) {
			igenero.delete(id);
		}
		return "redirect:../lista";
	}

    
    
    
}
