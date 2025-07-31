package com.exercico_blog.demo.Controllers;


import com.exercico_blog.demo.Repositories.AutorRepositorio;
import com.exercico_blog.demo.entities.Autor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Autor criarAutor(@RequestBody Autor autor) {
        this.autorRepositorio.save(autor);
        return autor;

    }

    @PutMapping("/{idAutor}")
    public Autor alterarAutor(
            @PathVariable Integer idAutor,
            @RequestBody Autor autor
    ){
        Autor alterar = this.autorRepositorio.findAllById(idAutor).get();

        alterar.setNome(autor.getNome());
        alterar.setEmail(autor.getEmail());
        alterar.setData_nascimento(autor.getData_nascimento());


        this.autorRepositorio.save(alterar);
        return alterar;
    }

    @DeleteMapping("/{idAutor}")
    public Autor removerAutor(@PathVariable Integer idAutor) {
        Autor autor = this.autorRepositorio.findById(idAutor).get();

        this.autorRepositorio.deleteAllById();

        return autor;
    }




}





