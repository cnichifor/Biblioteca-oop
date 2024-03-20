package com.company.biblioteca;

import com.company.Filiale.Filiala;
import com.company.biblioteca.Carti.Carti;
import com.company.biblioteca.Carti.CartiSpecialitate;


import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static com.company.Filiale.Filiala.*;
import static com.company.biblioteca.Carti.Carti.carti;
import static com.company.biblioteca.Cititor.cititori;
import static com.company.biblioteca.Imprumut.imprumuturi;

public class Main {



    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);


        try {
            FileInputStream fis = new FileInputStream("Carti.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            try {
                carti = (ArrayList<Carti>) ois.readObject();
            }catch (Exception ignored){
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fis = new FileInputStream("Cititori.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            try {
                cititori = (ArrayList<Cititor>) ois.readObject();
            }catch (Exception ignored){
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fis = new FileInputStream("Imprumuturi.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            try {
                imprumuturi = (ArrayList<Imprumut>) ois.readObject();
            }catch (Exception ignored){
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fis = new FileInputStream("Filiale.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            try {
                filiale = (ArrayList<Filiala>) ois.readObject();
            }catch (Exception ignored){
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Maxstat();
        while (true){
            System.out.println("___________________________________\n1 - Gestionare Carti\n2 - Gestionare Cititori\n3 - Gestionare Imprumuturi\n4 - Statistica totala a periodelor de imprumut\n5 - Gestionare Filiale\n0 - Exit\n___________________________________\n");
            try {
                switch (scan.nextInt()) {
                    case 0 -> System.exit(0);
                    case 1 -> {
                        System.out.println("""
                                \n___________________________________
                                0 - Afisare Carti
                                1 - Adaugare carte
                                2 - Excludere carte
                                3 - Cautare carti
                                4 - Cautare dupa autor
                                5 - Cautare dupa domeniu
                                ___________________________________
                                """);
                        switch (scan.nextInt()) {
                            case 0:
                                for (Carti value : carti) System.out.println(value.toString());
                                break;
                            case 1: {
                                System.out.println("1 - carte de specialitate\n0 - carte\n");
                                switch (scan.nextInt()) {
                                    case 0 -> {
                                        carti.add(new Carti());
                                        carti.get(carti.size() - 1).Add();
                                    }
                                    case 1 -> {
                                        carti.add(new CartiSpecialitate());
                                        carti.get(carti.size() - 1).Add();
                                    }
                                }
                                try {
                                    FileOutputStream fos = new FileOutputStream("Carti.bin");
                                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                                    oos.writeObject(carti);
                                    oos.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                break;
                            }
                            case 2: {
                                String input;
                                System.out.println("Introduceti cota cartii: ");
                                input = scan.next();
                                for (int i = 0; i < carti.size(); i++) {
                                    if (carti.get(i).getCota().equals(input)) {
                                        carti.remove(i);
                                        break;
                                    }
                                }

                                try {
                                    FileOutputStream fos = new FileOutputStream("Carti.bin");
                                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                                    oos.writeObject(carti);
                                    oos.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                break;
                            }
                            case 3: {
                                String input;
                                System.out.println("Introduceti numele cartii: ");
                                input = scan.next();
                                for (Carti value : carti) {
                                    if (value.getTitlu().contains(input)) {
                                        System.out.println(value);
                                    }
                                }
                                break;
                            }
                            case 4: {
                                String input;
                                System.out.println("Introduceti numele Autorului: ");
                                input = scan.next();
                                for (Carti value : carti) {
                                    if (value.getAutor().equals(input)) {
                                        System.out.println(value);
                                    }
                                }
                                break;
                            }
                            case 5: {
                                String input;
                                System.out.println("Introduceti domeniul: ");
                                input = scan.next();
                                for (Carti value : carti) {
                                    if (((CartiSpecialitate) value).getDomeniu().equals(input)) {
                                        System.out.println(value);
                                    }
                                }
                                break;
                            }
                        }
                    }
                    case 2 -> {
                        System.out.println("""
                                \n___________________________________
                                0 - Afisare Cititori
                                1 - Adaugare Cititorului
                                2 - Excluderea Cititorului
                                3 - Cautare dupa nume
                                4 - Cautare dupa id
                                ___________________________________
                                """);
                        switch (scan.nextInt()) {
                            case 0 -> {
                                for (Cititor cititor : cititori) System.out.println(cititor.toString());
                            }
                            case 1 -> {
                                cititori.add(new Cititor());
                                cititori.get(cititori.size() - 1).Add();

                                try {
                                    FileOutputStream fos = new FileOutputStream("Cititori.bin");
                                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                                    oos.writeObject(cititori);
                                    oos.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            case 2 -> {
                                int input;
                                System.out.println("Introduceti idul cititorului: ");
                                input = scan.nextInt();
                                for (int i = 0; i < cititori.size(); i++) {
                                    if (cititori.get(i).getId() == input) {
                                        cititori.remove(i);
                                        break;
                                    }
                                }
                                cititori.get(cititori.size() - 1).setId(input);
                                try {
                                    FileOutputStream fos = new FileOutputStream("Cititori.bin");
                                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                                    oos.writeObject(cititori);
                                    oos.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            case 3 -> {
                                String input;
                                System.out.println("Introduceti numele cititorului: ");
                                input = scan.next();
                                for (Cititor cititor : cititori) {
                                    if (cititor.getName().contains(input)) {
                                        System.out.println(cititor);
                                    }
                                }
                            }
                            case 4 -> {
                                int input;
                                System.out.println("Introduceti idul cititorului: ");
                                input = scan.nextInt();
                                for (Cititor cititor : cititori) {
                                    if (cititor.getId() == input) {
                                        System.out.println(cititor);
                                    }
                                }
                            }
                        }
                    }
                    case 3 -> {
                        System.out.println("""
                                \n___________________________________
                                0 - Afisare Imprumuturi
                                1 - Efectuare imprumut
                                2 - Restituire carte
                                3 - Imprumuturi restante
                                4 - Imprumuturi cititor
                                5 - Cititori care au imprumutat o carte
                                ___________________________________
                                """);
                        switch (scan.nextInt()) {
                            case 0 -> {
                                for (Imprumut imprumut : imprumuturi) System.out.println(imprumut.toString());
                            }
                            case 1 -> {
                                imprumuturi.add(new Imprumut());
                                imprumuturi.get(imprumuturi.size() - 1).Add();

                                try {
                                    FileOutputStream fos = new FileOutputStream("Imprumuturi.bin");
                                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                                    oos.writeObject(imprumuturi);
                                    oos.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            case 2 -> {
                                int input;
                                String sinput;
                                System.out.println("Introduceti idul cititorului si cota cartii: ");
                                input = scan.nextInt();
                                sinput = scan.next();
                                for (int i = 0; i < imprumuturi.size(); i++)
                                    if (imprumuturi.get(i).getIdcititor() == input && imprumuturi.get(i).getCota().equals(sinput)) {
                                        imprumuturi.remove(i);
                                        break;
                                    }
                            }
                            case 3 -> {
                                for (Imprumut imprumut : imprumuturi) {
                                    if (imprumut.isRestant()) {
                                        for (Cititor cititor : cititori) {
                                            if (imprumut.getIdcititor() == cititor.getId()) {
                                                System.out.println(cititor);
                                            }
                                        }
                                        for (Carti carte : carti) {
                                            if (imprumut.getCota().equals(carte.getCota())) {
                                                System.out.println(carte);
                                            }
                                        }
                                    }
                                }
                            }
                            case 4 -> {
                                int input;
                                System.out.println("Introduceti idul cititorului: ");
                                input = scan.nextInt();
                                for (Imprumut imprumut : imprumuturi) {
                                    if (imprumut.getIdcititor() == input) {
                                        System.out.println(imprumut);
                                    }
                                }
                            }
                            case 5 -> {
                                String input;
                                System.out.println("Introduceti cota cartii: ");
                                input = scan.next();
                                for (Imprumut imprumut : imprumuturi) {
                                    if (Objects.equals(imprumut.getCota(), input)) {
                                        for (Cititor cititor : cititori) {
                                            if (imprumut.getIdcititor() == cititor.getId()) {
                                                System.out.println(cititor);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    case 4 -> {
                        Maxstat();
                        System.out.println("Perioada totala de imprumuturi: " + getStat() + " zile");
                    }
                    case 5 -> {
                        System.out.println("""
                                \n___________________________________
                                0 - Afisare Filiale
                                1 - Adaugare Filiala
                                ___________________________________
                                """);
                        switch (scan.nextInt()) {
                            case 0 -> {
                                for (Filiala filiala : filiale) {
                                    System.out.println(filiala);
                                }
                            }
                            case 1 -> {
                                filiale.add(new Filiala());
                                filiale.get(filiale.size() - 1).Add();

                                try {
                                    FileOutputStream fos = new FileOutputStream("Filiale.bin");
                                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                                    oos.writeObject(filiale);
                                    oos.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }

                        }
                    }
                }
            }catch(Exception e){
                System.out.println("Ceva nu a mers bine!");
            }
        }
    }
}
