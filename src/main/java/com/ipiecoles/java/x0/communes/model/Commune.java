package com.ipiecoles.java.x0.communes.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "communes")
public class Commune {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code_commune_INSEE")
    private String codeInsee;

    @Column(name = "nom_commune")
    private String nom;

    @Column(name = "code_postal")
    private String codePostal;

    @Column(name = "libelle_acheminement")
    private String libelleAcheminement;

    @Column(name = "ligne_5")
    private String ligne5;

    private Double latitude;

    private Double longitude;

    public Long getDistance(Double latitude, Double longitude){
        Double lat1 = Math.toRadians(latitude);
        Double lng1 = Math.toRadians(longitude);
        Double lat2 = Math.toRadians(this.latitude);
        Double lng2 = Math.toRadians(this.longitude);

        double dlon = lng2 - lng1;
        double dlat = lat2 - lat1;

        double a = Math.pow((Math.sin(dlat/2)),2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon/2),2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        return Math.round(6371.009 * c);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeInsee() {
        return codeInsee;
    }

    public void setCodeInsee(String codeInsee) {
        this.codeInsee = codeInsee;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getLibelleAcheminement() {
        return libelleAcheminement;
    }

    public void setLibelleAcheminement(String libelleAcheminement) {
        this.libelleAcheminement = libelleAcheminement;
    }

    public String getLigne5() {
        return ligne5;
    }

    public void setLigne5(String ligne5) {
        this.ligne5 = ligne5;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Commune)) return false;
        Commune commune = (Commune) o;
        return codeInsee.equals(commune.codeInsee) &&
                nom.equals(commune.nom) &&
                codePostal.equals(commune.codePostal) &&
                Objects.equals(ligne5, commune.ligne5);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeInsee, nom, codePostal, ligne5);
    }
}
