package com.spring.henallux.firstSpringProject.dataAccess.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="article")
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "reference")
    private String reference;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "quantityStock")
    private int quantityStock;

    @Column(name="description")
    private String description;

    @Column(name="picture")
    private String picture;

    @OneToMany(mappedBy = "articleEntity", cascade = CascadeType.ALL)
    private Collection<CommandLineEntity> commandLineEntities;

    public ArticleEntity(){}
    public ArticleEntity(Integer id){this.id = id;}

    public void setPicture(String photo) {
        this.picture = photo;
    }

    public String getPicture() {
        return picture;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantityStock() {
        return quantityStock;
    }

    public void setQuantityStock(int quantityStock) {
        this.quantityStock = quantityStock;
    }

    public Collection<CommandLineEntity> getCommandLineEntities() {
        return commandLineEntities;
    }

    public void setCommandLineEntities(Collection<CommandLineEntity> commandLineEntities) {
        this.commandLineEntities = commandLineEntities;
    }
}