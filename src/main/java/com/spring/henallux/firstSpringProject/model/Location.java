package com.spring.henallux.firstSpringProject.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class Location {

    private Integer id;

    @NotEmpty
    @Size(min=1, max=200)
    private String name;

    @NotEmpty
    @Size(min=4, max=6)
    private String zip;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
