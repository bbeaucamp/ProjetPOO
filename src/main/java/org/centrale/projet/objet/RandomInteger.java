/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Random;

/**
 *
 * @author muruowang
 */
//On genere 10 entiers pseudo-aleatoires dans l'intervalle [0,99]
public class RandomInteger {

    public static void main(String[] args) {
        System.out.println("Generation de 10 nombres entiers dans l'intervalle [0,99]");

        // NB : il est INUTILE de creer plusieurs objets de type Random
        // UN SEUL suffit pour generer plusieurs 
        // nombres pseudo-aleatoires
        Random generateurAleatoire = new Random();

        // Boucle de generation des 10 nombres
        for (int i = 0; i < 6; i++) {
            // ici definit la borne sup de l'intervalle entre 0 et 99
            int entierAlea = generateurAleatoire.nextInt(100);
            System.out.println("On vient de generer : " + entierAlea);
        }
    }
}
