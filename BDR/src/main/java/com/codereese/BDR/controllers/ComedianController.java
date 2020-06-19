package com.codereese.BDR.controllers;

import com.codereese.BDR.exceptions.ComedianNotFoundException;
import com.codereese.BDR.models.Comedian;
import com.codereese.BDR.repos.ComedianRepo;
import com.codereese.BDR.services.ComedianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ComedianController {
    @Autowired
    ComedianRepo comedianRepo;

    @Autowired
    ComedianService comedianService;

    @CrossOrigin("http://localhost:3000")
    @GetMapping("/comedians")
    public List<Comedian> getAllComedians(){
        return comedianService.getComedians();
    }

    @GetMapping("comedians/{id}")
    public Comedian getComedianById(@PathVariable(value= "id") Long comedianId) throws ComedianNotFoundException {
        return comedianService.getComedianById(comedianId);
    }
}
