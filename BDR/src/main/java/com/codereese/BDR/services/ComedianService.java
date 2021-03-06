package com.codereese.BDR.services;

import com.codereese.BDR.exceptions.ComedianNotFoundException;
import com.codereese.BDR.models.Comedian;
import com.codereese.BDR.repos.ComedianRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ComedianService {

    @Autowired
    private ComedianRepo comedianRepo;

    public List<Comedian> getComedians(){
        List<Comedian> comedianList = comedianRepo.findAll();
        return comedianList;
    }

    public Comedian getComedianById(Long id) throws ComedianNotFoundException {
        Comedian comedian = comedianRepo.findById(id).orElseThrow(() -> new ComedianNotFoundException(id));
        return comedian;
    }

    public Comedian createComedian(@RequestBody Comedian comedian) {
        return comedianRepo.save(comedian);
    }

    public Comedian updateComedianById(@PathVariable(value="id") Long comedianId, @RequestBody Comedian comedianDetails) throws ComedianNotFoundException {
        Comedian comedian = comedianRepo.findById(comedianId).orElseThrow(() -> new ComedianNotFoundException(comedianId));
        comedian.setName(comedianDetails.getName());
        comedian.setImg_src(comedianDetails.getImg_src());
        Comedian updatedComedian = comedianRepo.save(comedian);
        return updatedComedian;
    }

    public ResponseEntity<?> deleteComedianById(@PathVariable(value="id")Long comedianId) throws ComedianNotFoundException {
        Comedian comedian = comedianRepo.findById(comedianId).orElseThrow(()-> new ComedianNotFoundException(comedianId));
        comedianRepo.delete(comedian);
        return ResponseEntity.ok().build();
    }
}
