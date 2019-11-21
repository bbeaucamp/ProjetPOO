/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Iterator;
import java.util.Random;

/**
 * Une entité de base du jeu World of ECN.
 *
 * @author muruowang
 */
public abstract class Creature extends ElementDeJeu implements Deplacable {

    /**
     * Les points de vie de la créature. A 0 points de vie, elle meurt.
     */
    private int ptVie;

    /**
     * Le pourcentage d'attaque de la créature. Détermine la chance de réussir
     * une attaque ou non.
     */
    private int pourcentageAtt;

    /**
     * Le pourcentage de parade de la créature. Détermine la chance de réussir
     * une parade ou non.
     */
    private int pourcentagePar;

    /**
     * Les dégâts d'attaque de la créature. Détermine les dégâts infligés lors
     * d'une attaque réussie.
     */
    private int degAtt;

    /**
     * Les points de parade de la créature. Détermine la quantité de dégâts
     * equivés lors d'une parade réussie.
     */
    private int ptPar;
    /**
     * La position de la créature dans le monde 2D.
     */
    private Point2D pos;

    public Creature(int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, int ptPar, Point2D pos) {
        this.ptVie = ptVie;
        this.pourcentageAtt = pourcentageAtt;
        this.pourcentagePar = pourcentagePar;
        this.degAtt = degAtt;
        this.ptPar = ptPar;
        this.pos = pos;
    }

    /**
     * Le constructeur sans paramètres. Les valeurs par défaut sont arbitraires.
     */
    public Creature() {
        Random generateurAleatoire = new Random();
        this.ptVie = 40 + generateurAleatoire.nextInt(15);
        this.pourcentageAtt = 45 + generateurAleatoire.nextInt(15);
        this.pourcentagePar = 40 + generateurAleatoire.nextInt(10);
        this.degAtt = 8 + generateurAleatoire.nextInt(5);
        this.ptPar = 4 + generateurAleatoire.nextInt(3);
        this.pos = new Point2D();
    }

    /**
     * Le constructeur de recopie. Crée une copie profonde de la créature.
     *
     * @param c La créature à copier.
     */
    public Creature(Creature c) {
        this.ptVie = c.ptVie;
        this.pourcentageAtt = c.pourcentageAtt;
        this.pourcentagePar = c.pourcentagePar;
        this.degAtt = c.degAtt;
        this.ptPar = c.ptPar;

        // bien une copie profonde car nous appelons le constructeur de recopie de Point2D
        this.pos = new Point2D(c.pos);

        // recopie va changer 
        // this.pos = c.pos;
    }

    
    public int getPtVie() {
        return ptVie;
    }

    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    public int getPourcentageAtt() {
        return pourcentageAtt;
    }

    public void setPourcentageAtt(int pourcentageAtt) {
        this.pourcentageAtt = pourcentageAtt;
    }

    public int getPourcentagePar() {
        return pourcentagePar;
    }

    public void setPourcentagePar(int pourcentagePar) {
        this.pourcentagePar = pourcentagePar;
    }

    public int getDegAtt() {
        return degAtt;
    }

    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    public int getPtPar() {
        return ptPar;
    }

    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }

    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }

    /**
     * Affichage textuel de tous les attributs de la créature.
     */
    public void affiche() {
        System.out.println("Points de vie : " + this.ptVie);
        System.out.println("Position : " + this.pos.toString());
        System.out.println("Points d'attaque : " + this.degAtt);
        System.out.println("Pourcentages d'attaque : " + this.pourcentageAtt);
        System.out.println("Points de parade : " + this.ptPar);
        System.out.println("Pourcentages de parade : " + this.pourcentagePar);
    }

    /**
     * Translate une créature d'une quantité spécifiée (les cases en diagonale
     * sont autorisées).
     *
     * @param nouvellePosition La position de Creature
     * @param w  World Le monde dans lequel se déplace l'élément.
     * @param dimension La dimension du plateau de jeu (supposé carré).
     */
    public void deplacer(Point2D nouvellePosition, World w, int dimension) {

        boolean errorMessage = (this instanceof Personnage) && (((Personnage)this).getNomAffichage().charAt(0) == ("J".charAt(0)));
        if (nouvellePosition.getX() >= 0 && nouvellePosition.getX() < dimension
                && nouvellePosition.getY() >= 0 && nouvellePosition.getY() < dimension
                && !w.getPositionsOccupees().contains(nouvellePosition)) {
            this.setPos(nouvellePosition);

            Iterator<Objet> objetsIt = w.getListeObjets().iterator();
            while(objetsIt.hasNext()) {
                Objet o = objetsIt.next();
                if (o.getPos().equals(this.getPos())) {
                    if (this instanceof Personnage) {
                        if (o instanceof Potion) {
                            ((Potion) o).boire((Personnage) this);
                            objetsIt.remove();
                        } else if (o instanceof Nourriture) {
                            ((Personnage) this).getListeNourriture().add((Nourriture) o);
                            objetsIt.remove();
                        }
                    } else {
                        if (o instanceof NuageToxique) {
                            ((NuageToxique) o).combattre(this);
                        }
                    }

                }

            }
        } else {
            if (errorMessage) {
                System.out.println("Déplacement impossible ! La case est occupée ou hors des limites.");
            }
            
        }
    }

}
