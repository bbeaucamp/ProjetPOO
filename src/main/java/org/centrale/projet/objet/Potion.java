/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 *
 * @author muruowang
 */
 public  abstract class Potion extends Objet {
    
    public Potion(String nom, Point2D pos) {
        super(nom, pos);
        
    }
    
    public Potion() {
        super();
        this.setNom("Portion");
    }
    
    public abstract void boire(Personnage p);
 
    
}
