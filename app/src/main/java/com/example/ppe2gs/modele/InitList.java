package com.example.ppe2gs.modele;


import java.util.ArrayList;

public class InitList {
    public static ArrayList<Evenement> getListEvenement(){
        ArrayList<Evenement> listEvenement = new ArrayList<Evenement>();
        Evenement event = new Evenement();
        event.setTitre("Session debutant  ");

       // event.setDate_debut(LocalDate.of(2018,10,12));
        listEvenement.add(event);
        Evenement event1 = new Evenement();
        event1.setTitre("Sous le soleil");
        //event1.setDate_debut(LocalDate.of(2020,02,13));
        listEvenement.add(event1);
        Evenement event2 = new Evenement();
        event2.setTitre("Test 1");
        //event2.setDate_debut(LocalDate.of(2020,03,14));
        listEvenement.add(event2);
        Evenement event3 = new Evenement();
        event3.setTitre("Event23");
       // event3.setDate_debut(LocalDate.of(2020,04,15));
        listEvenement.add(event3);
        Evenement event4 = new Evenement();
        event4.setTitre("Event4");
        //event4.setDate_debut(LocalDate.of(2020,05,16));
        listEvenement.add(event4);
        Evenement event5 = new Evenement();
        event5.setTitre("Event5");
        //event5.setDate_debut(LocalDate.of(2020,06,17));
        listEvenement.add(event5);
        return listEvenement;
    }
}