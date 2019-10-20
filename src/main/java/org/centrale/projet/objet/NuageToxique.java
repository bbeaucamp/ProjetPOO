/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.*;

/**
 *
 * @author muruowang
 */
public class NuageToxique extends Objet implements Deplacable, Combattant {
    
    /**
     * Les dégâts infligés par le nuage à une créature se trouvant sur la même case.
     */
    private int degAtt;

    
    public NuageToxique(String nom, Point2D pos, int degAtt) {
        super(nom,pos);
        this.degAtt = degAtt;
    }

    public NuageToxique() {
        super();
        this.setNom("NuageToxique");
        this.degAtt = 4;
    }

    public int getDegAtt() {
        return degAtt;
    }

    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    /**
     * Translate le nuage toxique d'une quantité spécifiée (les cases en
     * diagonale sont autorisées).
     * @param nouvellePosition La nouvelle position de Nuage Toxique
     * @param positionsOccupees Inutilisée ici car le nuage peut se déplacer partout.
     * @param dimension La dimension du plateau de jeu (supposé carré).
     */
    public void deplacer(Point2D nouvellePosition, ArrayList<Point2D> positionsOccupees, int dimension) {
        if (nouvellePosition.getX() >= 0 && nouvellePosition.getX() < dimension
                && nouvellePosition.getY() >= 0 && nouvellePosition.getY() < dimension){
            this.setPos(nouvellePosition);
        } else {
            System.out.println("Déplacement impossible ! La case est hors du plateau.");
        }
        
    }

    // Override method combattre(Creature c) in clasee Combattant
    /**
     *
     * @param c La créature attaquée par NuageToxique.
     */
    @Override
    public void combattre(Creature c) {
        if (this.getPos().equals(c.getPos())) {
            c.setPtVie(c.getPtVie() - this.getDegAtt());
        }
    }


    public static NuageToxique fromString(String params){
        StringTokenizer tokenizer = new StringTokenizer(params, " ");
        tokenizer.nextToken();
        return new NuageToxique(tokenizer.nextToken(), 
                Point2D.fromString(tokenizer.nextToken()),
                Integer.parseInt(tokenizer.nextToken()));
    }
 
    public String toString(){
        String res;
        res = "NuageToxique " + this.getNom() + " " + this.getPos().toString() + " " + this.getDegAtt();
        return res;
    }

}
