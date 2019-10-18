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
public class Mana extends Potion {

    /**
     * La quantité de mana rendu par la potion.
     */
    private int ptManaRendu;

    public Mana(int ptManaRendu, String nom, Point2D pos) {
        super(nom, pos);
        this.ptManaRendu = ptManaRendu;
    }

    

    public Mana() {
        super();
        this.setNom("Mana");
        this.ptManaRendu = 5;
    }

    public int getPtManaRendu() {
        return ptManaRendu;
    }

    public void setPtManaRendu(int ptManaRendu) {
        this.ptManaRendu = ptManaRendu;
    }

    /**
     * Utilise la potion de mana et rend des points de mana. Après utilisation,
     * la quantité de mana rendue par la potion passe à 0.
     *
     * @param p Le personnage qui va utiliser la potion.
     */
    public void boire(Personnage p) {
        p.setPtVie(p.getPtVie() + this.ptManaRendu);
        this.setPtManaRendu(0); // La potion est utilisée
    }

    public void affiche() {
        super.affiche();
        System.out.println("Elle rend " + this.getPtManaRendu() + " points de mana");
    }
    
    public static Mana fromString(String params){
        StringTokenizer tokenizer = new StringTokenizer(params, " ");
        tokenizer.nextToken();
        return new Mana(Integer.parseInt(tokenizer.nextToken()),
                tokenizer.nextToken(), 
                Point2D.fromString(tokenizer.nextToken()));
    }
    
    public String toString(){
        String res;
        res = "Mana " + this.getPtManaRendu() + " " + this.getNom() + " " + this.getPos().toString();
        return res;
    }

}
