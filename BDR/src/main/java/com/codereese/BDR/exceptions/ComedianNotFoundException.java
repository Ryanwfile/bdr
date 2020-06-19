package com.codereese.BDR.exceptions;

public class ComedianNotFoundException extends Exception {
    private long comedianId;
    public ComedianNotFoundException(long comedianId){
        super(String.format("Comedian not found with id : '%s'", comedianId));
    }
}
