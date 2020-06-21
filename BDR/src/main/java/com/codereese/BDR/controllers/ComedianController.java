package com.codereese.BDR.controllers;

import com.codereese.BDR.exceptions.ComedianNotFoundException;
import com.codereese.BDR.models.Comedian;
import com.codereese.BDR.repos.ComedianRepo;
import com.codereese.BDR.services.ComedianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @CrossOrigin("http://localhost:3000")
    @GetMapping("comedians/{id}")
    public Comedian getComedianById(@PathVariable(value= "id") Long comedianId) throws ComedianNotFoundException {
        return comedianService.getComedianById(comedianId);
    }
    @CrossOrigin("http://localhost:3000")
    @PostMapping("/comedians")
    public Comedian createComedian(@RequestBody Comedian comedian) {
        return comedianService.createComedian(comedian);
    }
    @CrossOrigin("http://localhost:3000")
    @PutMapping("/comedians/{id}")
    public Comedian updateComedian(@PathVariable(value="id")Long comedianId, @RequestBody Comedian comedianDetails) throws ComedianNotFoundException {
        return comedianService.updateComedianById(comedianId, comedianDetails);
    }

    @DeleteMapping("/comedians/{id}")
    public ResponseEntity<?> deleteComedian(@PathVariable(value="id")Long comedianId) throws ComedianNotFoundException {
        return comedianService.deleteComedianById(comedianId);
    }
}
