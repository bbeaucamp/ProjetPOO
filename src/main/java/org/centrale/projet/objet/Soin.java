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
public class Soin extends Potion {
    /**
     * La quantité de vie rendue par la potion.
     */
    private int ptVieRendu;

    public Soin(int ptVieRendu, Point2D pos) {
        super(pos);
        this.ptVieRendu = ptVieRendu;
    }

    public Soin() {
        super();
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
     * @param c La créature qui va utiliser la potion.
     */
    public void boire(Creature c){
        c.setPtVie(c.getPtVie() + this.ptVieRendu);
        this.setPtVieRendu(0); // La potion est utilisée
    }
    
    public void affiche(){
        super.affiche();
        System.out.println("Elle rend " + this.getPtVieRendu() + " points de vie");
    }
}
