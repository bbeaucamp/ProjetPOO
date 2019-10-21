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
 public abstract class ElementDeJeu {

    /**
     * La position de l'objet sur la carte.
     */
    private Point2D pos;
    private String nomAffichage;

    public String getNomAffichage() {
        return nomAffichage = "EdJ";
    }

    public void setNomAffichage(String nomAffichage) {
        this.nomAffichage = nomAffichage;
    }


    public ElementDeJeu(Point2D pos) {
        this.pos = pos;
    }

    public ElementDeJeu() {
        this.pos = new Point2D();
        
    }
    
    
    
    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }

    public abstract void affiche();
    
}
