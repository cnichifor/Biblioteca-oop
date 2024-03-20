package com.company.biblioteca.Carti;

import com.company.biblioteca.Interface;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Carti implements Interface, Serializable {
    protected String cota;
    protected String titlu;
    protected String autor;
    protected String editura;
    protected int anul;

    public static ArrayList<Carti> carti = new ArrayList<>();

    public Carti(String titlu, String autor, String editura, int anul) {
        setCota();
        this.titlu = titlu;
        this.autor = autor;
        this.editura = editura;
        this.anul = anul;
    }

    public Carti() {
    }

    public void Cota(){}
    public void FindAutor(){}

    public String getCota() {
        return cota;
    }

    public void setCota() {
        this.cota = String.valueOf(getAutor().charAt(0)) + carti.size();
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditura() {
        return editura;
    }

    public void setEditura(String editura) {
        this.editura = editura;
    }

    public int getAnul() {
        return anul;
    }

    public void setAnul(int anul) {
        this.anul = anul;
    }


    @Override
    public void Add() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Titlu: ");
        titlu = scan.next();
        System.out.print("Autor: ");
        autor = scan.next();
        System.out.print("Editura: ");
        editura = scan.next();
        System.out.print("Anul: ");
        anul = scan.nextInt();
        setCota();
    }


    @Override
    public String toString() {
        return "Carti{" +
                "cota='" + cota + '\'' +
                ", titlu='" + titlu + '\'' +
                ", autor='" + autor + '\'' +
                ", editura='" + editura + '\'' +
                ", anul=" + anul +
                '}';
    }
}
