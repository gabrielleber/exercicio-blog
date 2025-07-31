package com.exercico_blog.demo.Controllers;


import com.exercico_blog.demo.Repositories.AutorRepositorio;
import com.exercico_blog.demo.entities.Autor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/autor")

public class AutorController {

    private final AutorRepositorio autorRepositorio;

    public AutorController(AutorRepositorio autorRepositorio) {
        this.autorRepositorio = autorRepositorio;
    }

    @GetMapping


    public List<Autor> listar () {
        return this.autorRepositorio.findAll();

    }

    @GetMapping("/{idAutor}")
    public Autor buscarAutor(@PathVariable Integer idAutor) {
        return this.autorRepositorio.findBy(idAutor).get();
    }
}





