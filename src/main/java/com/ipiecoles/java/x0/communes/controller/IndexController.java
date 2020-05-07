package com.ipiecoles.java.x0.communes.controller;

import com.ipiecoles.java.x0.communes.service.CommuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class IndexController {
    @Autowired
    private CommuneService communeService;

    @RequestMapping
    public String index(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
            @RequestParam(value = "sortProperty", defaultValue = "codeInsee") String sortProperty,
            Map<String, Object> model
    ){
        model.put("communes", communeService.findAllCommunes(page, size, sortDirection, sortProperty));
        return "index";
    }
}
