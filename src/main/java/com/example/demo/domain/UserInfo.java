package com.example.demo.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by panbingcan on 2017/12/29.
 */
@Entity
public class UserInfo {
    /**
     * 序号
     */
    private Integer id;
    private Integer age;
    private String name;
    private String cupSize;
    private Integer height;
    private Integer weight;
    private String img;
    private Date createTime;
    private String sTime;

    @Transient/*Transient表示不映射到数据库表中*/
    public String getsTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(createTime);
    }

    public void setsTime(String sTime) {
        this.sTime = sTime;
    }

    @Min(value = 18, message = "未成年禁止入内")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public UserInfo() {
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotEmpty(message = "胸围不能为空")
    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getCreateTime() {
//        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(createTime);
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", cupSize='" + cupSize + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", img='" + img + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
