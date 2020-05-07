package com.ipiecoles.java.x0.communes.controller;

import com.ipiecoles.java.x0.communes.model.Commune;
import com.ipiecoles.java.x0.communes.service.CommuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/communes")
public class CommuneController {

    @Autowired
    private CommuneService communeService;

    @RequestMapping("/{id}")
    public String findCommuneById(
            @PathVariable("id") Integer id,
            @RequestParam(value = "perimetre", defaultValue = "10") Integer perimetre,
            Map<String, Object> model
    ){
        Commune commune = communeService.getCommuneById(id);
        List<Commune> communesProches = communeService.findCommunesProches(commune, perimetre);
        model.put("commune", commune);
        model.put("communesProches", communesProches);
        model.put("perimetre", perimetre);
        return "detail";
    }

    @RequestMapping(params = "nom")
    public String findCommuneById(
            @RequestParam(value = "nom") String nom,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
            @RequestParam(value = "sortProperty", defaultValue = "codeInsee") String sortProperty,
            Map<String, Object> model
    ){
        Page<Commune> communes = communeService.findCommunesNomLike(nom, page, size, sortDirection, sortProperty);
        model.put("communes", communes);
        model.put("nom", nom);
        return "index";
    }
}
