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
public class Soin extends Potion {
    
    private String nomAffichage = "S+";
    
    /**
     * La quantité de vie rendue par la potion.
     */
    private int ptVieRendu;

    public Soin(int ptVieRendu, String nom, Point2D pos) {
        super(nom, pos);
        this.ptVieRendu = ptVieRendu;
    }

    

    public Soin() {
        super();
        this.setNom("Soin");
        this.ptVieRendu = 20;
    }

    public int getPtVieRendu() {
        return ptVieRendu;
    }

    public void setPtVieRendu(int ptVieRendu) {
        this.ptVieRendu = ptVieRendu;
    }
    
    /**
     * Utilise la potion de soin et rend des points de vie. Après utilisation,
     * la quantité de vie rendue par la potion passe à 0.
     * @param p Le perosnnage qui va utiliser la potion.
     */
    public void boire(Personnage p){
        p.setPtVie(p.getPtVie() + this.ptVieRendu);
        this.setPtVieRendu(0); // La potion est utilisée
    }
    
    public void affiche(){
        super.affiche();
        System.out.println("Elle rend " + this.getPtVieRendu() + " points de vie");
    }
    
    public static Soin fromString(String params){
        StringTokenizer tokenizer = new StringTokenizer(params, " ");
        tokenizer.nextToken();
        return new Soin(Integer.parseInt(tokenizer.nextToken()),
                tokenizer.nextToken(), 
                Point2D.fromString(tokenizer.nextToken()));
    }
    
    public String toString(){
        String res;
        res = "Soin " + this.getPtVieRendu() + " " + this.getNom() + " " + this.getPos().toString();
        return res;
    }

    public String getNomAffichage() {
        return nomAffichage;
    }

    public void setNomAffichage(String nomAffichage) {
        this.nomAffichage = nomAffichage;
    }
 
}
