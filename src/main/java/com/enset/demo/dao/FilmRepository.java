package com.enset.demo.dao;

import com.enset.demo.entites.Film;
import com.enset.demo.entites.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")

public interface FilmRepository extends JpaRepository<Film,Long> {
}
