package com.codereese.BDR.controllers;

import com.codereese.BDR.models.Comedian;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.client.RestClientException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ComedianControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    @Sql("/getComedianByIdTest.sql")
    public void getComedianById(){
        ResponseEntity<Comedian> comedianResponseEntity = testRestTemplate.getForEntity("/comedians/1", Comedian.class);
        assertEquals(1,comedianResponseEntity.getBody().getComedianId());
    }

    @Test
    @Sql("/comedian_table_populate.sql")
    public void getComediansLength(){
        ResponseEntity<Comedian[]> comedianResponseEntity = testRestTemplate.getForEntity("/comedians", Comedian[].class);
        Comedian[] comedians = comedianResponseEntity.getBody();
        assertEquals(3, comedians.length);
    }

    @Test
    @Sql("/createComedianTest.sql")
    public void saveComedian(){
        Comedian comedian = new Comedian();
        comedian.setFirst_name("Jim");
        comedian.setLast_name("Gaffigan");
        comedian.setImg_src("testdummy");

        HttpEntity<Comedian> comedianHttpEntity = new HttpEntity<>(comedian);
        ResponseEntity<Comedian> comedianResponseEntity = testRestTemplate.postForEntity("/comedians", comedianHttpEntity, Comedian.class);

        assertNotNull(comedianResponseEntity.getBody().getComedianId());
    }

    @Test
    public void updateComedianReturnsTrue(){
        Comedian updatedComedian = new Comedian();
        updatedComedian.setComedianId(1l);

    }

//    @Test
//    public void updateComedian(){
//        Comedian comedian = new Comedian();
//        comedian.setImg_src("I am an updated imgsrc");
//        comedian.setFirst_name("updated");
//        comedian.setLast_name("Mcgoo");
//
//        HttpEntity<Comedian> comedianHttpEntity = new HttpEntity<>(comedian);
//
//        try {
//            ResponseEntity<Comedian> comedianResponseEntity = testRestTemplate.put("/comedians/6", comedianHttpEntity);
//        } catch (RestClientException e) {
//            e.printStackTrace();
//        }
//    }
}
