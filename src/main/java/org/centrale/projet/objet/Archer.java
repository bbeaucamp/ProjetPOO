/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Random;

/**
 * Un archer du jeu World of ECN. C'est un personnage qui attaque à distance.
 *
 * @author muruowang
 */
public class Archer extends Personnage {

    /**
     * Le nombre de flèches de l'archer. Chaque tentative d'attaque à distance
     * consomme un projectile.
     */
    // Attribut
    private int nbFleches;

    public Archer(String nom, int ptMana, int pourcentageMag, int pourcentageResistMag, int degMag, int distAttMax, int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, int ptPar, Point2D pos) {
        super(nom, ptMana, pourcentageMag, pourcentageResistMag, degMag, distAttMax, ptVie, pourcentageAtt, pourcentagePar, degAtt, ptPar, pos);
        this.nbFleches = nbFleches;
    }

    /**
     * Le constructeur de recopie. Crée une copie profonde de l'archer.
     *
     * @param a L'archer à copier.
     */
    public Archer(Archer a) {
        // doit être la première instruction
        super(a);
        this.nbFleches = a.nbFleches;
    }

    /**
     * Le constructeur sans paramètres. Possède les valeurs par défaut d'un
     * Personnage, sauf pour : - nom : Archer, - nbFleches : 5, - distAttMax : 5
     */
    public Archer() {
        super();
        this.setNom("Archer");
        this.nbFleches = 5;
        this.setDistAttMax(5);
    }

    public int getNbFleches() {
        return nbFleches;
    }

    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
    }

    public void affiche() {
        super.affiche();
        System.out.println("Nombre de flèches  " + this.nbFleches);
    }

    /**
     * Méthode pour le combat à distance. Ne marche que si la distance entre
     * l'attaquant et la créature est > 1. Retire une flèche à l'attaquant.
     *
     * @param c La créature attaquée par l'archer.
     */
    public void combattre(Creature c) {
        if (c.getPos().distance(this.getPos()) > 1
                && c.getPos().distance(this.getPos()) < this.getDistAttMax()  // distance Attaque maximum
                && this.getNbFleches() >= 1) {
            this.setNbFleches(this.getNbFleches() - 1);

            Random generateurAleatoire = new Random();

            // Tentative d'attaque
            // chiffre aléatoire entre 1 et 100
            int jetAttaque = 1 + generateurAleatoire.nextInt(100);
            System.out.println("Jet d'attaque : " + jetAttaque + ". Pourcentage d'attaque : " + this.getPourcentageAtt());
            if (jetAttaque <= c.getPourcentageAtt()) {
                System.out.println("Attaque à distance réussie");
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
                System.out.println("Attaque à distance échouée");
            }
        } else {
            System.out.println("Attaque échouée");
        }
    }

}
