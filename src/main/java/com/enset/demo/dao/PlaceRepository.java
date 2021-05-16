package com.enset.demo.dao;

import com.enset.demo.entites.Place;
import com.enset.demo.entites.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PlaceRepository extends JpaRepository<Place,Long> {
}
