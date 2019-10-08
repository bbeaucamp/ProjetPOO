/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.*;

/**
 *
 * @author muruowang
 */
public class TestSeance3 {

    public static void main(String[] args) {
        // testArrayList();
        // testParcoursConteneurs();
       testCalculeTemps();
    }

    public static void testArrayList() {
        World w1 = new World();
        w1.creeMondeAlea();
    }

    public static void testParcoursConteneurs() {
        ArrayList<Archer> listArchers = new ArrayList<>();
        //Initialisation de la liste
        for (int i = 0; i < 10; i++) {
            listArchers.add(new Archer());
        }

        // Parcours de la liste basé sur la taille
        for (int i = 0; i < listArchers.size(); i++) {
            System.out.println();
            System.out.println("Itération " + i);
            listArchers.get(i).affiche();
        }
    }
    
    public static void testCalculeTemps(){
             World w = new World();
            w.creeMondeAlea();
    }
}
