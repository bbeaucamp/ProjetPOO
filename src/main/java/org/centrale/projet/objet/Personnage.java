/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.LinkedList;
import java.util.Random;

/**
 * Un personnage du jeu World of ECN.
 *
 * @author muruowang
 */
 public abstract class Personnage extends Creature {

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
    
    /**
     * La liste des aliments en train de donner un bonus ou un malus au personnage.
     */
    private LinkedList<Nourriture> listeNourriture;

    public Personnage(String nom, int ptMana, int pourcentageMag, int pourcentageResistMag, int degMag, int distAttMax, LinkedList<Nourriture> listeNourriture, int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, int ptPar, Point2D pos) {
        super(ptVie, pourcentageAtt, pourcentagePar, degAtt, ptPar, pos);
        this.nom = nom;
        this.ptMana = ptMana;
        this.pourcentageMag = pourcentageMag;
        this.pourcentageResistMag = pourcentageResistMag;
        this.degMag = degMag;
        this.distAttMax = distAttMax;
        this.listeNourriture = listeNourriture;
    }

    /**
     * Le constructeur sans paramètres. Initialise le nom à "Personnage" et les
     * autres attributs de manière arbitraire.
     */
    public Personnage() {
        super(100, 70, 60, 15, 5, new Point2D());
        Random generateurAleatoire = new Random();
        this.setPtVie(100 + generateurAleatoire.nextInt(30));
        this.setPourcentageAtt(60 + generateurAleatoire.nextInt(10));
        this.setPourcentagePar(55 + generateurAleatoire.nextInt(10));
        this.setDegAtt(15 + generateurAleatoire.nextInt(5));
        this.setPtPar(8 + generateurAleatoire.nextInt(5));
        this.nom = "Personnage";
        this.ptMana = 3 + generateurAleatoire.nextInt(3);
        this.pourcentageMag = 25 + generateurAleatoire.nextInt(10);
        this.pourcentageResistMag = 30 + generateurAleatoire.nextInt(10);
        this.degMag = 10 + generateurAleatoire.nextInt(5);
        this.distAttMax = 1;
        this.listeNourriture = new LinkedList<>();
    }

    /**
     * Le constructeur de recopie. Crée une copie profonde du personnage.
     *
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
        this.listeNourriture = new LinkedList<>(p.listeNourriture);
    }
    
    public abstract String getNomAffichage();
    
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

    public LinkedList<Nourriture> getListeNourriture() {
        return listeNourriture;
    }

    public void setListeNourriture(LinkedList<Nourriture> listeNourriture) {
        this.listeNourriture = listeNourriture;
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

    // Override abstract method deplacer() in Creature 
    public void deplacer() {
    }
    
    public abstract void setNomAffichage(String nomAffichage);

}
