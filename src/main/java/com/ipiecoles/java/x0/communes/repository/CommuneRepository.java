package com.ipiecoles.java.x0.communes.repository;

import com.ipiecoles.java.x0.communes.model.Commune;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommuneRepository extends JpaRepository<Commune, Integer> {
    List<Commune> findByLatitudeBetweenAndLongitudeBetween(Double latMin, Double latMax, Double longMin, Double longMax);

    Page<Commune> findByNomContainingIgnoreCase(String nom, Pageable pageable);
}
