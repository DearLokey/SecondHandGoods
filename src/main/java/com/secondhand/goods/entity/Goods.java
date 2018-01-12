package com.secondhand.goods.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by lokey
 * 2018/1/12
 */
@Entity
public class Goods {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String price;
    private String description;
    private Integer userName;

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getUserName() {
        return userName;
    }

    public void setUserName(Integer userName) {
        this.userName = userName;
    }
}
