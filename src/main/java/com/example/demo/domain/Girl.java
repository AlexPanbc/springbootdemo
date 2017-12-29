package com.example.demo.domain;


import javax.persistence.*;

/**
 * Created by panbingcan on 2017/12/28.
 */
@Entity
public class Girl {
    @Id
    @GeneratedValue
    private  Integer id;
    private String cupSize;
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Girl() {
    }
}
