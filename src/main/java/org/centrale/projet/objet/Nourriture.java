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
public abstract class Nourriture {

    private int nTours;
    private int quantite;
    private boolean consomme;

    public Nourriture(int nTours, int quantite) {
        this.nTours = nTours;
        this.quantite = quantite;
        this.consomme = false;
    }

    public int getnTours() {
        return nTours;
    }

    public void setnTours(int nTours) {
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

    public void consommer(Personnage p) {

    }

}
