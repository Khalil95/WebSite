package com.spring.henallux.firstSpringProject.model;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Client {

    private Integer id;
    @NotEmpty(message = "This field is required !")
    @Size(min = 3, max = 50)
    @Email
    private String email;
    @NotEmpty
    @Size(min =4, max = 16)
    private String password;
    @NotNull
    @Size(min=4, max=16)
    private String passwordConfirmation;
    @NotEmpty
    @Size(min = 2, max = 50)
    private String first_name;
    @NotEmpty
    @Size(min = 2, max = 50)
    private  String last_name;
    @NotEmpty
    @Size(min = 2, max = 50)
    private String street_name;
    @NotEmpty
    @Size(min = 1, max = 8)
    private String number_address;
    @NotEmpty
    @Size(min = 2, max = 50)
    private String phone_number;
    @NotEmpty
    @Size(min = 2, max = 50)
    private String city;
    @Min(0)
    @Max(9999)
    @NotNull
    private Integer zip;
    @NotEmpty
    @Size(min = 2, max = 50)
    private String country;


    private String job;

    private  Command command;
    private boolean registered;

    public Client(){}

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public boolean isRegistered() {
        return registered;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }



    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public Integer getZip() {
        return zip;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getStreet_name() {
        return street_name;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    public String getNumber_address() {
        return number_address;
    }

    public void setNumber_address(String number_address) {
        this.number_address = number_address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }
}
