package com.codereese.BDR.services;

import com.codereese.BDR.exceptions.ComedianNotFoundException;
import com.codereese.BDR.models.Comedian;
import com.codereese.BDR.repos.ComedianRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
