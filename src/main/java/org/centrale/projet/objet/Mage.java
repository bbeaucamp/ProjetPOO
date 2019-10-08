/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Random;

/**
 * Un mage du jeu World of ECN. C'est un personnage qui attaque à distance.
 *
 * @author muruowang
 */
public class Mage extends Personnage {

    public Mage(String nom, int ptMana, int pourcentageMag, int pourcentageResistMag, int degMag, int distAttMax, int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, int ptPar, Point2D pos) {
        super(nom, ptMana, pourcentageMag, pourcentageResistMag, degMag, distAttMax, ptVie, pourcentageAtt, pourcentagePar, degAtt, ptPar, pos);
    }

    /**
     * Le constructeur sans paramètres. Possède les valeurs par défaut d'un
     * Personnage, sauf pour : - nom : Mage, - degMag : 20, - ptMana : 7, -
     * pourcentageMag : 80, - distAttMax : 3
     */
    public Mage() {
        super();
        this.setPtMana(7);
        this.setNom("Mage");
        this.setPourcentageMag(80);
        this.setDegMag(20);
        this.setDistAttMax(3);
    }

    /**
     * Le constructeur de recopie. Crée une copie profonde du mage.
     *
     * @param m Le mage à copier.
     */
    public Mage(Mage m) {
        super(m);
    }

    /**
     * Méthode pour le combat à distance. Ne marche que si la distance entre
     * l'attaquant et la créature est égale à 1.
     *
     * @param c La créature attaquée par le loup.
     */
    public void combattre(Creature c) {
        if (c.getPos().distance(this.getPos()) >= 1
                && c.getPos().distance(this.getPos()) < this.getDistAttMax()
                && this.getPtMana() >= 1) {
            this.setPtMana(this.getPtMana() - 1); // On retire 1 mana
            Random generateurAleatoire = new Random();
            // Tentative d'attaque
            int jetAttaque = 1 + generateurAleatoire.nextInt(100);
            System.out.println("Jet d'attaque : " + jetAttaque + ". Pourcentage d'attaque : " + this.getPourcentageMag());
            if (jetAttaque <= this.getPourcentageMag()) {
                System.out.println("Attaque magique réussie !");
                int qteDegats = this.getDegMag();
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
                    c.setPtVie(c.getPtVie() - qteDegats);
                    System.out.println(qteDegats + " dégâts sont infligés");
                } else {
                    System.out.println("Aucun dégâts subis");
                }

            } else {
                System.out.println("Attaque magique échouée");
            }
        } else {
            System.out.println("Attaque échouée");
        }
    }

}
