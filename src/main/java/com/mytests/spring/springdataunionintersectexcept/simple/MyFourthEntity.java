package com.mytests.spring.springdataunionintersectexcept.simple;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MyFourthEntity {
    @Id
    private Long id;
    private String name;
    private String fifthEntityName;

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

    public String getFifthEntityName() {
        return fifthEntityName;
    }

    public void setFifthEntityName(String fifthEntityName) {
        this.fifthEntityName = fifthEntityName;
    }

    public MyFourthEntity(Long id, String name, String fifthEntityName) {
        this.id = id;
        this.name = name;
        this.fifthEntityName = fifthEntityName;
    }

    public MyFourthEntity() {
    }

    @Override
    public String toString() {
        return "MyFourthEntity{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", fifthEntityName='" + fifthEntityName + '\'' +
               '}';
    }
}
