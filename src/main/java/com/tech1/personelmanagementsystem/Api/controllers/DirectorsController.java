package com.tech1.personelmanagementsystem.Api.controllers;

import com.tech1.personelmanagementsystem.Business.abstracts.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/diretors")
public class DirectorsController {
    private final DirectorService directorService;
    @Autowired
    public DirectorsController(DirectorService directorService){
        this.directorService = directorService;
    }



}
