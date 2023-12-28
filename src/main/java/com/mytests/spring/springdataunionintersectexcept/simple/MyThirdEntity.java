package com.mytests.spring.springdataunionintersectexcept.simple;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MyThirdEntity {
    @Id
    private Long id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public MyThirdEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public MyThirdEntity() {
    }
}
