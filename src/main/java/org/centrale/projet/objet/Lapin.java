/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;
import java.util.Random;

/**
 * Un lapin du jeu World of ECN.
 * @author muruowang
 */
// classe Lapion héritage calsee Monstre
public class Lapin extends Monstre  {

    public Lapin(int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, int ptPar, Point2D pos) {
        super(ptVie, pourcentageAtt, pourcentagePar, degAtt, ptPar, pos);
    }

    public Lapin(Lapin l) {
        // Chaque constructeur d’une sous-classe doit faire un appel au constructeur de sa super-classe : super(...)
        // mais si on obulie, java va le faire pour vous
        super(l);
    }

    /**
     * Le constructeur sans paramètres. Initialise les attributs de manière
     * arbitraire.
     */
    //Possède toutes les valeurs par défaut de Creature.
    public Lapin() {
        super();
        Random generateurAleatoire = new Random();
        this.setPtVie(10 + generateurAleatoire.nextInt(7));
        this.setPourcentageAtt(30 + generateurAleatoire.nextInt(10));
        this.setPourcentagePar(20 + generateurAleatoire.nextInt(15));
        this.setDegAtt(5 + generateurAleatoire.nextInt(3));
        this.setPtPar(2 + generateurAleatoire.nextInt(4));
    }
    
    

}
