package com.enset.demo.dao;

import com.enset.demo.entites.Salle;
import com.enset.demo.entites.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource

public interface SeanceRepository extends JpaRepository<Seance,Long> {
}
