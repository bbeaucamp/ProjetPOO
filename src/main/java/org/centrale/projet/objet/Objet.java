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
abstract class Objet extends ElementDeJeu {

    /**
     * Le nom de l'objet
     */
    private String nom;

    public String getNom() {
        return nom;
    }

    public Objet(String nom, Point2D pos) {
        super(pos);
        this.nom = nom;
    }

    public Objet() {
        this.nom = "Objet";
    }
 
        
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void affiche() {
        System.out.println(this.nom + " se trouve en " + this.getPos().toString());
    }

}
