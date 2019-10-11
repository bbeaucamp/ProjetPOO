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
public  abstract class NuageToxique extends Objet implements Deplacable, Combattant {


    
    public NuageToxique(String nom, Point2D pos) {
        super(nom,pos);
      
    }

    public NuageToxique() {
        super();
          this.setNom("NuageToxique");
    }

    // Override method depalcer() in class Deplaceble
    /**
     * Déplace une créature aléatoirement sur une case adjacente (les cases en
     * diagonale sont autorisées).
     */
    public void deplacer() {
        Random generateurAleatoire = new Random();
        // nextInt(3) --> 0,1,2
        // nextInt(3) - 1 --> -1,0,1
        // 3*3 = 9 possiblités
        int deplacementX = generateurAleatoire.nextInt(3) - 1;
        int deplacementY = generateurAleatoire.nextInt(3) - 1;
      //  this.pos.translate(deplacementX, deplacementY);
        this.getPos().translate(deplacementX, deplacementY);
    }

    // Override method combattre(Creature c) in clasee Combattant
    /**
     *
     * @param c La créature attaquée par NuageToxique.
     */
    @Override
    public void combattre(Creature c) {
    }


 
 


}
