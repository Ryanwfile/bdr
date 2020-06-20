package com.codereese.BDR.models;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;

@Entity
@Table(name="comedians", schema = "mysql")
public class Comedian {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="comedianId")
    private Long comedianId;
    private String first_name;
    private String last_name;
    private String img_src;

    public Comedian(){
        super();
    }

    public Comedian(Long comedianId, String first_name, String last_name, String img_src) {
        this.comedianId = comedianId;
        this.first_name = first_name;
        this.last_name = last_name;
        this.img_src = img_src;
    }

    public Comedian(Long comedianId, String first_name, String last_name) {
        this.comedianId = comedianId;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Comedian(Long comedianId) {
        this.comedianId = comedianId;
    }
    /*****************************JUST ADDED******************************/
//    public Comedian(String first_name, String last_name, String img_src){
//        super();
//    }
    public Long getComedianId() {
        return comedianId;
    }

    public void setComedianId(Long comedianId) {
        this.comedianId = comedianId;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getImg_src() {
        return img_src;
    }

    public void setImg_src(String img_src) {
        this.img_src = img_src;
    }

    @Override
    public String toString() {
        return "Comedian{" +
                "comedianId=" + comedianId +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", img_src='" + img_src + '\'' +
                '}';
    }
}
