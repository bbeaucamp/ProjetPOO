/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Scanner;

/**
 *
 * @author Benjamin
 */
public class Jeu {

    public static void main(String[] args) {
        Scanner input;
        World w = new World();
        System.out.println("Bienvenue dans World of ECN !");
        System.out.println("Suivez bien les instructions à l'écran et n'entrez pas de valeur erronée !!");

        // Initialisation du monde
        System.out.println("Voulez-vous commencer une nouvelle partie (1) ou charger une partie (2) ?");
        input = new Scanner(System.in);
        int choix = input.nextInt();
        if (choix == 1 || choix == 2) {
            switch (choix) {
                case 1:
                    System.out.println("Combien y a-t-il de joueurs ?");
                    input = new Scanner(System.in);
                    w.setnJoueurs(input.nextInt());
                    w.creeMondeAlea();
                    break;
                case 2:
                    System.out.println("Entrez le nom du fichier de sauvegarde :");
                    input = new Scanner(System.in);
                    try {
                        ChargementPartie load = new ChargementPartie(input.nextLine());
                        w = load.chargerPartie();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("Erreur");
            }

            // Début de la partie
            w.setJeuEnCours(true);

            while (w.isJeuEnCours()) {
                w.tourDeJeu();
            }

        } else {
            w.finPartie();
        }
    }
}
