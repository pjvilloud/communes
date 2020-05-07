package com.ipiecoles.java.x0.communes.service;

import com.ipiecoles.java.x0.communes.model.Commune;
import com.ipiecoles.java.x0.communes.repository.CommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommuneService {

    public static final Double DEGRE_LAT_KM = 111d;
    public static final Double DEGRE_LONG_KM = 77d;

    @Autowired
    private CommuneRepository communeRepository;

    public Commune getCommuneById(Integer id){
        Optional<Commune> commune = communeRepository.findById(id);
        if(commune.isPresent()){
            return commune.get();
        }
        throw new EntityNotFoundException("Impossible de trouver la commune d'identifiant " + id);
    }

    public Page<Commune> findAllCommunes(Integer page, Integer size, String sortDirection, String sortProperty) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.fromString(sortDirection), sortProperty);
        return communeRepository.findAll(pageable);
    }

    public List<Commune> findCommunesProches(Commune commune, Integer perimetreEnKm) {
        Double latMin, latMax, longMin, longMax, degreLat, degreLong;
        //1 degré latitude = 111km, 1 degré longitude = 77km
        degreLat = perimetreEnKm/DEGRE_LAT_KM;
        degreLong = perimetreEnKm/DEGRE_LONG_KM;
        latMin = commune.getLatitude() - degreLat;
        latMax = commune.getLatitude() + degreLat;
        longMin = commune.getLongitude() - degreLong;
        longMax = commune.getLongitude() + degreLong;
        List<Commune> communesProches = communeRepository.findByLatitudeBetweenAndLongitudeBetween(latMin, latMax, longMin, longMax);
        ;
        return communesProches.stream().filter(commune1 -> !commune1.getNom().equals(commune.getNom()) && commune1.getDistance(commune.getLatitude(), commune.getLongitude()) <= perimetreEnKm).collect(Collectors.toList());
    }

    public Page<Commune> findCommunesNomLike(String nom, Integer page, Integer size, String sortDirection, String sortProperty) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.fromString(sortDirection), sortProperty);

        return communeRepository.findByNomContainingIgnoreCase(nom, pageable);
    }

    public Page<Commune> getAllCommunes(Integer page, Integer size, String sortDirection, String sortProperty) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.fromString(sortDirection), sortProperty);

        return communeRepository.findAll(pageable);

    }
}
