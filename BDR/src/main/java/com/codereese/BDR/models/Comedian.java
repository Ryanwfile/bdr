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
    private String name;
    private String img_src;

    public Comedian(){
        super();
    }
    public Comedian(Long comedianId, String name, String img_src) {
        this.comedianId = comedianId;
        this.name = name;
        this.img_src = img_src;
    }

    public Comedian(Long comedianId, String name) {
        this.comedianId = comedianId;
        this.name = name;
    }

    public Comedian(Long comedianId) {
        this.comedianId = comedianId;
    }

    public Long getComedianId() {
        return comedianId;
    }

    public void setComedianId(Long comedianId) {
        this.comedianId = comedianId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                ", name='" + name + '\'' +
                ", img_src='" + img_src + '\'' +
                '}';
    }
}
