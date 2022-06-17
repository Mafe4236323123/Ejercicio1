package com.example.ejercicio1.controller;

import com.example.ejercicio1.model.Album;
import com.example.ejercicio1.service.IAlbumService;

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


@Controller
@SessionAttributes("album")
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    private IAlbumService ialbum;

    @GetMapping(path = {"/lista", "", "/"}) 
        public String listar(Model m){
            m.addAttribute("albumnes", ialbum.findAll());
            return "view/album/list";
        }

    @GetMapping(path = "/agregar")
        public String abrirForm(Model m){
            Album album = new Album();
            m.addAttribute("album", album);
            m.addAttribute("accion", "Agregar ");
            return "view/album/add";
    }


    @PostMapping(path ="/add")
        public String add(@Valid Album album, BindingResult res, Model m, SessionStatus status){
            if(res.hasErrors()){
                return "view/album/add";
            }
            ialbum.save(album);
            status.setComplete();
            return "redirect:lista";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model m){
        Album album= null;
        if(id>0){
            album=ialbum.findOne(id);
        }
        else{
            return "redirect:lista";
        }
        m.addAttribute("album", album);
        m.addAttribute("accion", "Editar");
        return "view/album/add";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
		
		if(id > 0) {
			ialbum.delete(id);
		}
		return "redirect:../lista";
	}
}
