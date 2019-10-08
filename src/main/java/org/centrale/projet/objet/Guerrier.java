/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Random;

/**
 * Un guerrier du jeu World of ECN. C'est un personnage qui attaque au corps à
 * corps.
 *
 * @author muruowang
 */
public class Guerrier extends Personnage {

    public Guerrier(String nom, int ptMana, int pourcentageMag, int pourcentageResistMag, int degMag, int distAttMax, int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, int ptPar, Point2D pos) {
        super(nom, ptMana, pourcentageMag, pourcentageResistMag, degMag, distAttMax, ptVie, pourcentageAtt, pourcentagePar, degAtt, ptPar, pos);
    }

    /**
     * Le constructeur sans paramètres. Possède les valeurs par défaut d'un
     * Personnage, sauf pour : - nom : Guerrier, - ptVie : 120, - degAtt : 20
     */
    public Guerrier() {
        super();
        this.setPtVie(120);
        this.setDegAtt(20);
        this.setNom("Guerrier");
    }

    /**
     * Le constructeur de recopie. Crée une copie profonde du guerrier.
     *
     * @param g Le guerrier à copier.
     */
    public Guerrier(Guerrier g) {
        super(g);
    }

    /**
     * Méthode pour le combat au coprs à corps. Ne marche que si la distance
     * entre l'attaquant et la créature est égale à 1.
     *
     * @param c La créature attaquée par le guerrier.
     */
    public void combattre(Creature c) {

        if (c.getPos().distance(this.getPos()) == 1) {
            Random generateurAleatoire = new Random();
            // Tentative d'attaque
            int jetAttaque = 1 + generateurAleatoire.nextInt(100);
            System.out.println("Jet d'attaque : " + jetAttaque + ". Pourcentage d'attaque : " + this.getPourcentageAtt());
            if (jetAttaque <= c.getPourcentageAtt()) {
                System.out.println("Attaque au corps à corps réussie");
                int qteDegats = this.getDegAtt();
                // Tentative de parade
                int jetDefense = 1 + generateurAleatoire.nextInt(100);
                System.out.println("Jet de parade : " + jetDefense + ". Pourcentage de parade : " + c.getPourcentagePar());
                if (jetDefense <= c.getPourcentagePar()) {
                    System.out.println("Parade réussie !");
                    qteDegats = qteDegats - c.getPtPar();
                } else {
                    System.out.println("Parade échouée !");
                }
                // Applique les dégâts à l'adversaire
                if (qteDegats > 0) {
                    System.out.println(qteDegats + " dégâts sont infligés");
                    c.setPtVie(c.getPtVie() - qteDegats);
                } else {
                    System.out.println("Aucun dégâts subis");
                }
            } else {
                System.out.println("Attaque au corps à corps échouée");
            }
        } else {
            System.out.println("Attaque à distance échouée");
        }
    }
}
