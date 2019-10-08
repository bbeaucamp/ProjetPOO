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
public class Mana extends Potion {
    /**
     * La quantité de mana rendu par la potion.
     */
    private int ptManaRendu;

    public Mana(int ptManaRendu, Point2D pos) {
        super(pos);
        this.ptManaRendu = ptManaRendu;
    }

    public Mana() {
        super();
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
     * @param p Le personnage qui va utiliser la potion.
     */
    public void boire(Personnage p){
        p.setPtVie(p.getPtVie() + this.ptManaRendu);
        this.setPtManaRendu(0); // La potion est utilisée
    }
    
    public void affiche(){
        super.affiche();
        System.out.println("Elle rend " + this.getPtManaRendu() + " points de mana");
    }
}
