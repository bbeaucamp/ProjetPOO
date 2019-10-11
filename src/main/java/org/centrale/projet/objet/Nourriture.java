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
public abstract class Nourriture extends Objet {

    private int nTours;
    private int quantite;
    private boolean consomme;

    public Nourriture(int nTours, int quantite, String nom, Point2D pos) {
        super(nom, pos);
        this.nTours = nTours;
        this.quantite = quantite;
        this.consomme = false;
    }
    
    public Nourriture(){
        this.nTours = 2;
        this.quantite = 3;
        this.consomme = false;
    }

    public int getNTours() {
        return nTours;
    }

    public void setNTours(int nTours) {
        this.nTours = nTours;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public boolean isConsomme() {
        return consomme;
    }

    public void setConsomme(boolean consomme) {
        this.consomme = consomme;
    }

    /**
     * Enlève ou ajoute 'quantite' à l'attribut concerné deu personnage p.
     * @param p Le personnage qui consomme la nourriture.
     */
    public abstract void consommer(Personnage p);

}
