/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Random;

/**
 * Une entité de base du jeu World of ECN.
 *
 * @author muruowang
 */

 
public   class  Creature {

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
        this.ptVie = 50;
        this.pourcentageAtt = 50;
        this.pourcentagePar = 50;
        this.degAtt = 5;
        this.ptPar = 2;
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
     * Déplace une créature aléatoirement sur une case adjacente (les cases en
     * diagonale sont autorisées).
     */
    public void deplace() {
        Random generateurAleatoire = new Random();
        // nextInt(3) --> 0,1,2
        // nextInt(3) - 1 --> -1,0,1
        // 3*3 = 9 possiblités
        int deplacementX = generateurAleatoire.nextInt(3) - 1;
        int deplacementY = generateurAleatoire.nextInt(3) - 1;
        this.pos.translate(deplacementX, deplacementY);
    }

}
