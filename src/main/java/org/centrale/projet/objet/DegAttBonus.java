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
public class DegAttBonus extends Nourriture {

    public DegAttBonus(int nTours, int quantite) {
        super(nTours, quantite);
    }

    public DegAttBonus() {
    }
    
    public void consommer(Personnage p){
        if (!this.isConsomme()) {
            p.setDegAtt(p.getDegAtt() + this.getQuantite());
        }
        
        if (this.getnTours() > 0) {
            this.setnTours(this.getnTours() - 1);
        } else {
            p.setDegAtt(p.getDegAtt() - this.getQuantite()); // Le bonus se termine
        }
    }
}
