package com.spring.henallux.firstSpringProject.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Command {

    private Integer id;
    private Date date;
    private double total_price;
    private String status;
    private Client client;
    private List<CommandLine> commandLines;


    public Command(){}

    public Command(Client client){
        this.client = client;
        date = new Date();
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

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

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<CommandLine> getCommandLines() {
        return commandLines;
    }

    public void setCommandLines(List<CommandLine> commandLines) {
        this.commandLines = commandLines;
    }

    public void addCommandLine(CommandLine commandLine){this.commandLines.add(commandLine);}
}
