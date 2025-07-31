package com.exercico_blog.demo.Repositories;

import com.exercico_blog.demo.entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepositorio extends JpaRepository<Autor, Integer > {

}
