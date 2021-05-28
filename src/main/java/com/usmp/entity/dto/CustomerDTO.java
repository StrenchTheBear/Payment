package com.usmp.entity.dto;

public class CustomerDTO {

    private String name;
    private String firstLastName;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getFirstLastName() { return firstLastName; }
    public void setFirstLastName(String firstLastName) { this.firstLastName = firstLastName; }

    public CustomerDTO() {
    }

    public CustomerDTO(String name, String firstLastName) {
        this.name = name;
        this.firstLastName = firstLastName;
    }

}
