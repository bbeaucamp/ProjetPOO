/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Un monstre du jeu World of ECN. Un monstre du jeu World of ECN.
 *
 * @author muruowang
 */
public abstract class Monstre extends Creature {

    public Monstre(int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, int ptPar, Point2D pos) {
        super(ptVie, pourcentageAtt, pourcentagePar, degAtt, ptPar, pos);
    }

    /**
     * Le constructeur sans paramètres. Possède toutes les valeurs par défaut de
     * Creature.
     */
    public Monstre() {
        super();
    }

    /**
     * Le constructeur de recopie. Crée une copie profonde du monstre.
     *
     * @param m Le monstre à copier.
     */
    public Monstre(Monstre m) {
        super(m);
    }

    // Override abstract method deplacer() in Creature 
    public void deplacer() {
    }

}
