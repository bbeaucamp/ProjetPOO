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
public class Objet {
    /**
     * La position de l'objet sur la carte.
     */
    private Point2D pos;
    /**
     * Le nom de l'objet
     */
    private String nom;

    public Objet(Point2D pos) {
        this.pos = pos;
    }

    public Objet() {
        this.pos = new Point2D();
    }

    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void affiche() {
        System.out.println(this.nom + " se trouve en " + this.pos.toString());
    }
    
}
