/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Un paysan du jeu World of ECN.
 * @author muruowang
 */
public class Paysan extends Personnage {

    public Paysan(String nom, int ptMana, int pourcentageMag, int pourcentageResistMag, int degMag, int distAttMax, int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, int ptPar, Point2D pos) {
        super(nom, ptMana, pourcentageMag, pourcentageResistMag, degMag, distAttMax, ptVie, pourcentageAtt, pourcentagePar, degAtt, ptPar, pos);
    }
        
    /**
     * Le constructeur de recopie. Crée une copie profonde du paysan.
     * @param perso Le paysan à copier.
     */
    public Paysan(Personnage perso) {
        super(perso);
    }

    
        /**
     * Le constructeur sans paramètres. Possède les valeurs par défaut d'un 
     * Personnage, sauf pour :
     *  - nom : Paysan
     */
    public Paysan() {
        super();
       this.setNom("Paysan");
    }

}
