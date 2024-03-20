package com.company.biblioteca;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Imprumut implements Serializable, Interface {
    private Date imprumut;
    private Date restituire;
    private int idcititor, id;
    private String cota;
    private boolean restant;

    public boolean isRestant() {
        return restant;
    }

    public void setRestant() {
        restant = false;
        Date date = new Date(System.currentTimeMillis());
        int result = restituire.compareTo(date);
        if (result < 0) {
            restant = true;
        }
    }

    public Imprumut(int idcititor, int id, String cota) {
        this.idcititor = idcititor;
        this.id = id;
        this.cota = cota;
    }

    public Imprumut(Date imprumut, Date restituire, int idcititor, int id, String cota) {
        this.imprumut = imprumut;
        this.restituire = restituire;
        this.idcititor = idcititor;
        this.id = id;
        this.cota = cota;
    }

    public int getIdcititor() {
        return idcititor;
    }

    public void setIdcititor(int idcititor) {
        this.idcititor = idcititor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCota() {
        return cota;
    }

    public void setCota(String cota) {
        this.cota = cota;
    }


    public Imprumut() {
    }

    @Override
    public void Add() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Id cititor: ");
        setIdcititor(scan.nextInt());
        System.out.print("Id carte: ");
        setCota(scan.next());
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Imprumutat: ");
        try {
            imprumut = formatter.parse(scan.next());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.print("Restituire: ");
        try {
            restituire = formatter.parse(scan.next());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        setId(imprumuturi.size());
        setRestant();
    }
    public static ArrayList<Imprumut> imprumuturi = new ArrayList<>();

    @Override
    public String toString() {
        return "Imprumut{" +
                "imprumut=" + imprumut +
                ", restituire=" + restituire +
                ", idcititor=" + getIdcititor() +
                ", id=" + getId() +
                ", cota='" + getCota() + '\'' +
                '}';
    }

    public Date getImprumut() {
        return imprumut;
    }

    public void setImprumut(Date imprumut) {
        this.imprumut = imprumut;
    }

    public Date getRestituire() {
        return restituire;
    }

    public void setRestituire(Date restituire) {
        this.restituire = restituire;
    }


}
