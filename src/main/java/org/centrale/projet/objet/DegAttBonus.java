/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.StringTokenizer;

/**
 *
 * @author muruowang
 */
public class DegAttBonus extends Nourriture {

    public DegAttBonus(int nTours, int quantite, String nom, Point2D pos) {
        super(nTours, quantite, nom, pos);
    }

    public DegAttBonus() {
    }
    
    public void consommer(Personnage p){
        if (!this.isConsomme()) {
            p.setDegAtt(p.getDegAtt() + this.getQuantite());
        }
        
        if (this.getNTours() > 0) {
            this.setNTours(this.getNTours() - 1);
        } else {
            p.setDegAtt(p.getDegAtt() - this.getQuantite()); // Le bonus se termine
        }
    }
    
    public String toString(){
        String res;
        res = "DegAttBonus " + this.getNTours() + " " + this.getQuantite() + " " +
                this.getNom() + " " + this.getPos().toString();
        return res;
    }
    
    public static DegAttBonus fromString(String params){
        StringTokenizer tokenizer = new StringTokenizer(params, " ");
        tokenizer.nextToken();
        return new DegAttBonus(Integer.parseInt(tokenizer.nextToken()),
                Integer.parseInt(tokenizer.nextToken()),
                tokenizer.nextToken(), 
                Point2D.fromString(tokenizer.nextToken()));
    }
}
