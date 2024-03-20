package com.company.biblioteca.Carti;

import com.company.biblioteca.Interface;

import java.util.Scanner;

public class CartiSpecialitate extends Carti implements Interface {
    private String domeniu;
    public CartiSpecialitate(String titlu, String autor, String editura, int anul, String domeniu) {
        super(titlu, autor, editura, anul);
        this.domeniu = domeniu;
    }

    public CartiSpecialitate() {
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
        System.out.print("Domeniu: ");
        domeniu = scan.next();
        setCota();
    }

    @Override
    public String toString() {
        return "CartiSpecialitate{" +
                "cota='" + cota + '\'' +
                ", titlu='" + titlu + '\'' +
                ", autor='" + autor + '\'' +
                ", editura='" + editura + '\'' +
                ", anul=" + anul +
                ", domeniu='" + domeniu + '\'' +
                '}';
    }

    public String getDomeniu() {
        return domeniu;
    }

    public void setDomeniu(String domeniu) {
        this.domeniu = domeniu;
    }
}
