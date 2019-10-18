/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Un paysan du jeu World of ECN.
 *
 * @author muruowang
 */
public class Paysan extends Personnage {

    public Paysan(String nom, int ptMana, int pourcentageMag, int pourcentageResistMag, int degMag, int distAttMax, LinkedList<Nourriture> listeNourriture, int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, int ptPar, Point2D pos) {
        super(nom, ptMana, pourcentageMag, pourcentageResistMag, degMag, distAttMax, listeNourriture, ptVie, pourcentageAtt, pourcentagePar, degAtt, ptPar, pos);
    }

    /**
     * Le constructeur de recopie. Crée une copie profonde du paysan.
     *
     * @param perso Le paysan à copier.
     */
    public Paysan(Personnage perso) {
        super(perso);
    }

    /**
     * Le constructeur sans paramètres. Possède les valeurs par défaut d'un
     * Personnage, sauf pour : - nom : Paysan
     */
    public Paysan() {
        super();
        this.setNom("Paysan");
    }

    public static Paysan fromString(String params) {
        StringTokenizer tokenizer = new StringTokenizer(params, " ");
        // passer nom
        tokenizer.nextToken();
        return new Paysan(tokenizer.nextToken(),
                Integer.parseInt(tokenizer.nextToken()),
                Integer.parseInt(tokenizer.nextToken()),
                Integer.parseInt(tokenizer.nextToken()),
                Integer.parseInt(tokenizer.nextToken()),
                Integer.parseInt(tokenizer.nextToken()),
                new LinkedList<Nourriture>(),
                Integer.parseInt(tokenizer.nextToken()),
                Integer.parseInt(tokenizer.nextToken()),
                Integer.parseInt(tokenizer.nextToken()),
                Integer.parseInt(tokenizer.nextToken()),
                Integer.parseInt(tokenizer.nextToken()),
                Point2D.fromString(tokenizer.nextToken()));
    }

    public String toString() {
        String rse;
        rse = "Paysan " + this.getNom() + " " + this.getPtMana() + " " + this.getPourcentageMag() + " "
                + this.getPourcentageResistMag() + " " + this.getDegMag() + " " + this.getDistAttMax() + " "
                + this.getPtVie() + " " + this.getPourcentageAtt() + " " + this.getPourcentagePar() + " "
                + this.getDegAtt() + " " + this.getPtPar() + " " + this.getPos().toString();

        return rse;

    }

}
