package com.mytests.spring.springdataunionintersectexcept.simple;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class MyFifthEntity {
    @Id
    private Long id;
    private String name;
    @OneToMany
    private List<MyFourthEntity> fourthEntities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public List<MyFourthEntity> getFourthEntities() {
        return fourthEntities;
    }

    public void setFourthEntities(List<MyFourthEntity> fourthEntities) {
        this.fourthEntities = fourthEntities;
    }

    public MyFifthEntity(Long id, String name, List<MyFourthEntity> fourthEntities) {
        this.id = id;
        this.name = name;
        this.fourthEntities = fourthEntities;
    }

    public MyFifthEntity() {
    }
}
