package com.spring.henallux.firstSpringProject.Enumeration;


public enum EnumStatutCommand {

    PAID("paid"),
    UNPAID("unpaid");

    private String code;

    EnumStatutCommand(String code){
        this.code = code;
    }

    public String getCode(){
        return this.getCode();
    }

    public void setCode(String code) {
        this.code = code;
    }
}
