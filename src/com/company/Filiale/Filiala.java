package com.company.Filiale;

import com.company.biblioteca.Imprumut;
import com.company.biblioteca.Interface;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static com.company.biblioteca.Imprumut.imprumuturi;

public class Filiala implements Interface, Serializable {
    private String nume, adresa, telefon, contact;
    private static long stat;

    public Filiala(String nume, String adresa, String telefon, String contact) {
        this.nume = nume;
        this.adresa = adresa;
        this.telefon = telefon;
        this.contact = contact;
    }

    public Filiala() {
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public static long getStat() {
        return stat;
    }

    public static void setStat(long stat) {
        Filiala.stat += stat;
    }

    @Override
    public String toString() {
        return "Filiala{" +
                "nume='" + nume + '\'' +
                ", adresa='" + adresa + '\'' +
                ", telefon='" + telefon + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }

    public static void Maxstat(){
        for (Imprumut imprumut : imprumuturi) {
            Date dateBefore = imprumut.getImprumut();
            Date dateAfter = imprumut.getRestituire();


            long dateBeforeInMs = dateBefore.getTime();
            long dateAfterInMs = dateAfter.getTime();

            long timeDiff = Math.abs(dateAfterInMs - dateBeforeInMs);

            long daysDiff = timeDiff / (60 * 60 * 1000 * 24);
            setStat(daysDiff);
        }
    }
    public static ArrayList<Filiala> filiale = new ArrayList<>();

    @Override
    public void Add() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nume: ");
        nume = scan.next();
        System.out.print("Adresa: ");
        adresa = scan.next();
        System.out.print("Telefon: ");
        telefon = scan.next();
        System.out.print("Contact: ");
        contact = scan.next();

    }


}
