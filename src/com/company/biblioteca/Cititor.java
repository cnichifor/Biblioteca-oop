package com.company.biblioteca;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Cititor implements Interface, Serializable {
    private int id;
    private String name, adress, tel, email;

    public Cititor(String name, String adress, String tel, String email) {
        this.id = cititori.size();
        this.name = name;
        this.adress = adress;
        this.tel = tel;
        this.email = email;
    }

    public Cititor() {
    }

    @Override
    public void Add() {
        setId();
        Scanner scan = new Scanner(System.in);
        System.out.print("Nume: ");
        name = scan.next();
        System.out.print("Adresa: ");
        adress = scan.next();
        System.out.print("Telefon: ");
        tel = scan.next();
        System.out.print("Email: ");
        email = scan.next();
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = cititori.size();
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cititor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static ArrayList<Cititor> cititori = new ArrayList<>();
}
