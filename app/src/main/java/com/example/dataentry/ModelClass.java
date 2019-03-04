package com.example.dataentry;

public class ModelClass {

    private int id;
    private String name;
    private String Phone;

    public ModelClass(String name, String phone) {
        this.name = name;
        Phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
