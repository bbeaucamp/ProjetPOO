/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;


/**
 *Un personnage du jeu World of ECN.
 * @author muruowang
 */
public class   Personnage  extends Creature{

/**
     * Le nom du personnage.
     */
    private String nom;
    /**
     * Les points de mana du personnage. Chaque tentative d'attaque magique 
     * consomme un point de mana.
     */
    private int ptMana;
    /**
     * Le pourcentage d'attaque magique du personnage. Détermine la chance de 
     * réussir une attaque magique ou non.
     */
    private int pourcentageMag;
    /**
     * Le pourcentage de résistance magique du personnage. Détermine la chance 
     * de parer une attaque magique ou non.
     */
    private int pourcentageResistMag;
    /**
     * Les dégâts de magie du personnage. Détermine la quantité de dégâts
     * magiques infligés lors d'une attaque réussie.
     */
    private int degMag;
    /**
     * La distance maximale d'attaque du personnage. Indique la distance
     * maximale à laquelle le personnage peut lancer une attaque.
     */
    private int distAttMax;

    public Personnage(String nom, int ptMana, int pourcentageMag, int pourcentageResistMag, int degMag, int distAttMax, int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, int ptPar, Point2D pos) {
        super(ptVie, pourcentageAtt, pourcentagePar, degAtt, ptPar, pos);
        this.nom = nom;
        this.ptMana = ptMana;
        this.pourcentageMag = pourcentageMag;
        this.pourcentageResistMag = pourcentageResistMag;
        this.degMag = degMag;
        this.distAttMax = distAttMax;
    }

    /**
     * Le constructeur sans paramètres. Initialise le nom à "Personnage" et les
     * autres attributs de manière arbitraire.
     */
    public Personnage() {
        super(100, 70, 60, 15, 5, new Point2D());
        this.nom = "Personnage";
        this.ptMana = 5;
        this.pourcentageMag = 30;
        this.pourcentageResistMag = 30;
        this.degMag = 10;
        this.distAttMax = 1;
    }

    /**
     * Le constructeur de recopie. Crée une copie profonde du personnage.
     * @param p Le personnage à copier.
     */
    public Personnage(Personnage p) {
        super(p);
        this.nom = p.nom;
        this.ptMana = p.ptMana;
        this.pourcentageMag = p.pourcentageMag;
        this.pourcentageResistMag = p.pourcentageResistMag;
        this.degMag = p.degMag;
        this.distAttMax = p.distAttMax;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPtMana() {
        return ptMana;
    }

    public void setPtMana(int ptMana) {
        this.ptMana = ptMana;
    }

    public int getPourcentageMag() {
        return pourcentageMag;
    }

    public void setPourcentageMag(int pourcentageMag) {
        this.pourcentageMag = pourcentageMag;
    }

    public int getPourcentageResistMag() {
        return pourcentageResistMag;
    }

    public void setPourcentageResistMag(int pourcentageResistMag) {
        this.pourcentageResistMag = pourcentageResistMag;
    }

    public int getDegMag() {
        return degMag;
    }

    public void setDegMag(int degMag) {
        this.degMag = degMag;
    }

    public int getDistAttMax() {
        return distAttMax;
    }

    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }

    /**
     * Affichage textuel de tous les attributs du personnage.
     */
    public void affiche() {
        System.out.println("Nom : " + this.nom);
        super.affiche();
        System.out.println("Points de mana : " + this.ptMana);
        System.out.println("Dégâts de magie : " + this.degMag);
        System.out.println("Pourcentage de magie : " + this.pourcentageMag);
        System.out.println("Pourcentage de résistance à la magie : " + this.pourcentageResistMag);
        System.out.println("Distance d'attaque maximale : " + this.distAttMax);
    }
    

    
    
}
