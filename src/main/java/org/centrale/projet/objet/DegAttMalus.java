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
public class DegAttMalus extends Nourriture {
    
    private String nomAffichage = "A-";

    public String getNomAffichage() {
        return nomAffichage;
    }

    public void setNomAffichage(String nomAffichage) {
        this.nomAffichage = nomAffichage;
    }

    public DegAttMalus(int nTours, int quantite, String nom, Point2D pos) {
        super(nTours, quantite, nom, pos);
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
        
        if (this.getNTours() > 0) {
            this.setNTours(this.getNTours() - 1);
        } else {
            p.setDegAtt(p.getDegAtt() + this.getQuantite()); // Le malus se termine
        }
    }
    
    public String toString(){
        String res;
        res = "DegAttMalus " + this.getNTours() + " " + this.getQuantite() + " " +
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
