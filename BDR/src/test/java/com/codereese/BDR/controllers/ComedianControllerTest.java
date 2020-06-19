package com.codereese.BDR.controllers;

import com.codereese.BDR.models.Comedian;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ComedianControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    @Sql("/comedian_table_populate.sql")
    public void getComedianById(){
        ResponseEntity<Comedian> comedianResponseEntity = testRestTemplate.getForEntity("/comedians/1", Comedian.class);
        assertEquals(1,comedianResponseEntity.getBody().getComedianId());
    }

//    @Test
//    @Sql("/comedian_table_populate.sql")
//    public void getComedians(){
//        ResponseEntity<Comedian> comedianResponseEntity = testRestTemplate.getForEntity("/comedians", Comedian.class);
//        assertEquals(1,comedianResponseEntity.getBody().);
//    }
}
