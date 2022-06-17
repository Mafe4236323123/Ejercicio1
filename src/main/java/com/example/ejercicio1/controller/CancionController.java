package com.example.ejercicio1.controller;

import com.example.ejercicio1.model.Cancion;
import com.example.ejercicio1.service.ICancionService;

import javax.validation.Valid;

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

import com.example.ejercicio1.service.ICancionService;

@Controller
@SessionAttributes("cancion")
@RequestMapping("/cancion")
public class CancionController {

    @Autowired
    private ICancionService icancionserv;

    @GetMapping(path = {"/lista", "", "/"})
        public String listar(Model m){
            m.addAttribute("canciones", icancionserv.findAll());
            return "view/cancion/list";
        }

    @GetMapping(path = "/agregar")
        public String abrirForm(Model m){
            Cancion cancion = new Cancion();
            m.addAttribute("cancion", cancion);
            m.addAttribute("accion", "Agregar ");
            return "view/cancion/add";
    }

    @PostMapping(path ="/add")
        public String add(@Valid Cancion cancion, BindingResult res, Model m, SessionStatus status){
            if(res.hasErrors()){
                return "view/cancion/add";
            }
            icancionserv.save(cancion);
            status.setComplete();
            return "redirect:lista";
    }
    
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model m){
        Cancion cancion= null;
        if(id>0){
            cancion=icancionserv.findOne(id);
        }
        else{
            return "redirect:lista";
        }
        m.addAttribute("cancion", cancion);
        m.addAttribute("accion", "Editar");
        return "view/cancion/add";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
		
		if(id > 0) {
			icancionserv.delete(id);
		}
		return "redirect:../lista";
	}
    
}
