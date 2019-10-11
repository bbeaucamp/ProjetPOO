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
public class DegAttMalus extends Nourriture {

    public DegAttMalus(int nTours, int quantite) {
        super(nTours, quantite);
    }

    public DegAttMalus() {
    }

    public void consommer(Personnage p) {
        if (!this.isConsomme()) { // Le personnage n'a pas encore consommé la nourriture
            int newDegAtt = p.getDegAtt() - this.getQuantite();
            if (newDegAtt >= 0) {
                p.setDegAtt(newDegAtt);
            } else {
                p.setDegAtt(0);
            }
        }
        
        if (this.getnTours() > 0) {
            this.setnTours(this.getnTours() - 1);
        } else {
            p.setDegAtt(p.getDegAtt() + this.getQuantite()); // Le malus se termine
        }
    }
}
