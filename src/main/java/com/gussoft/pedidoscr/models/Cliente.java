package com.gussoft.pedidoscr.models;

import javax.persistence.*;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String dni;

    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, length = 15)
    private String phone;
    private String adress;
    private String status;

    public Cliente() {
    }

    public Cliente(Integer id, String dni, String name, String phone, String adress, String status) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.phone = phone;
        this.adress = adress;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
