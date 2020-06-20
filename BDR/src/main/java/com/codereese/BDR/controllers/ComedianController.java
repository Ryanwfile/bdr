package com.codereese.BDR.controllers;

import com.codereese.BDR.exceptions.ComedianNotFoundException;
import com.codereese.BDR.models.Comedian;
import com.codereese.BDR.repos.ComedianRepo;
import com.codereese.BDR.services.ComedianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/comedians")
    public Comedian createComedian(@RequestBody Comedian comedian) {
        return comedianService.createComedian(comedian);
    }

    @PutMapping("/comedians/{id}")
    public Comedian updateComedian(@PathVariable(value="id")Long comedianId, @RequestBody Comedian comedianDetails) throws ComedianNotFoundException {
        return comedianService.updateComedianById(comedianId, comedianDetails);
    }
}
