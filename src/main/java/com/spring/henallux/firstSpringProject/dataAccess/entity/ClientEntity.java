package com.spring.henallux.firstSpringProject.dataAccess.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name="client")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="first_name")
    private String first_name;

    @Column(name="last_name")
    private String last_name;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="phone_number")
    private String phone_number;

    @Column(name="number_address")
    private String number_address;

    @Column(name="street_name")
    private String street_name;

    @Column(name="zip")
    private Integer zip;

    @Column(name="city")
    private String city;

    @Column(name="country")
    private String country;

    @Column(name="job")
    private String job;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientEntity")
    private Set<CommandEntity> commandEntityCollection;

    public Set<CommandEntity> getCommandEntityCollection() {
        return commandEntityCollection;
    }

    public void setCommandEntityCollection(Set<CommandEntity> commandEntityCollection) {
        this.commandEntityCollection = commandEntityCollection;
    }

    public String getCity() {
        return city;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public Integer getZip() {
        return zip;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String telephone) {
        this.phone_number = telephone;
    }

    public String getNumber_address() {
        return number_address;
    }

    public void setNumber_address(String number_address) {
        this.number_address = number_address;
    }

    public String getStreet_name() {
        return street_name;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}

