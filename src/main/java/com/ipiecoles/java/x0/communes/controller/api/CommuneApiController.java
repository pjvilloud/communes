package com.ipiecoles.java.x0.communes.controller.api;

import com.ipiecoles.java.x0.communes.model.Commune;
import com.ipiecoles.java.x0.communes.service.CommuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/communes")
public class CommuneApiController {

    @Autowired
    private CommuneService communeService;

    @RequestMapping("/{id}")
    public Commune getCommuneById(@PathVariable("id") Integer id){
        return communeService.getCommuneById(id);
    }

    @RequestMapping("")
    public Page<Commune> getAllCommunes(){
        return communeService.getAllCommunes(0, 10, "ASC", "codeInsee");
    }
}
