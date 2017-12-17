package com.spring.henallux.firstSpringProject.dataAccess.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name="command")
public class CommandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="date")
    private Date date;

    @Column(name="status")
    private String status;

    @Column(name="totalprice")
    private double total_price;

    @JoinColumn(name="idclient", referencedColumnName="id")
    @ManyToOne(cascade = CascadeType.MERGE)
    private ClientEntity clientEntity;

    @OneToMany(mappedBy="commandEntity", cascade = CascadeType.ALL)
    private Collection<CommandLineEntity> commandLineEntityCollection;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }

    public Collection<CommandLineEntity> getCommandLineEntityCollection() {
        return commandLineEntityCollection;
    }

    public void setCommandLineEntityCollection(Collection<CommandLineEntity> commandLineEntityCollection) {
        this.commandLineEntityCollection = commandLineEntityCollection;
    }
}
