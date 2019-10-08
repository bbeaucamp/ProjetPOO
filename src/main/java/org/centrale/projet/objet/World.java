/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.*;

/**
 * Le monde 2D dans lequel évolue les créatures du jeu World of ECN.
 *
 * @author muruowang
 */
public class World {

    // Attributs
    // ArrayList : très efficace à ajouter des éléments à la fin de tableau
    // Personne
    /**
     * Une liste d'archers.
     */
    public ArrayList<Archer> listArchers;
    /**
     * Une liste de paysans.
     */
    public ArrayList<Paysan> listPaysans;

    /**
     * Une liste de guerriers.
     */
    public ArrayList<Guerrier> listGuerriers;

    /**
     * Une liste de mages.
     */
    public ArrayList<Mage> listMages;

    //Monstre
    /**
     * Une liste de loups.
     */
    public ArrayList<Loup> listLoups;

    /**
     * Une liste de lapins.
     */
    public ArrayList<Lapin> listLapins;

    // Objet
    /**
     * Une liste de soins.
     */
    public ArrayList<Soin> listSoins;

    /**
     * Une liste de manas.
     */
    public ArrayList<Mana> listManas;

    /**
     * La taille d'un côté du monde, supposé carré.
     */
    public int tailleMonde;

    /**
     * Le constructeur sans paramètres qui initialise les créatures avec leurs
     * valeurs par défaut puis attribue un nom à chaque personnage.
     */
    public World() {

        // Initialiser dans un tableau "ArrayList" 
        // Définir la taille pour chaque ArrayList
        this.listArchers = new ArrayList<>();
        this.listGuerriers = new ArrayList<>();
        this.listMages = new ArrayList<>();
        this.listPaysans = new ArrayList<>();

        this.listLapins = new ArrayList<>();
        this.listLoups = new ArrayList<>();

        this.listSoins = new ArrayList<>();
        this.listManas = new ArrayList<>();

        this.tailleMonde = 50;

    }

    /**
     * Place toutes les créatures dans le monde 2D (50*50), en s'assurant qu'ils
     * aient tous une position différente.
     */
    public void creeMondeAlea() {
        int maxNbPersonnages = 30; // Nombre max de protagonistes par classe
        Random generateurAleatoire = new Random();
        
        // Archers
        int nbPersonnages = generateurAleatoire.nextInt(maxNbPersonnages); 
        ArrayList<Point2D> positions = this.generePositionsAleatoires(nbPersonnages);
        for(Point2D p : positions){
            Archer a = new Archer();
            a.setPos(p);
            this.listArchers.add(a);
        }
        
        // Guerriers
        nbPersonnages = generateurAleatoire.nextInt(maxNbPersonnages); 
        positions = this.generePositionsAleatoires(nbPersonnages);
        for(Point2D p : positions){
            Guerrier g = new Guerrier();
            g.setPos(p);
            this.listGuerriers.add(g);
        }
        
        // Mages
        nbPersonnages = generateurAleatoire.nextInt(maxNbPersonnages); 
        positions = this.generePositionsAleatoires(nbPersonnages);
        for(Point2D p : positions){
            Mage m = new Mage();
            m.setPos(p);
            this.listMages.add(m);
        }
        
        // Paysans
        nbPersonnages = generateurAleatoire.nextInt(maxNbPersonnages); 
        positions = this.generePositionsAleatoires(nbPersonnages);
        for(Point2D p : positions){
            Paysan paysan = new Paysan();
            paysan.setPos(p);
            this.listPaysans.add(paysan);
        }
        
        // Loups
        nbPersonnages = generateurAleatoire.nextInt(maxNbPersonnages); 
        positions = this.generePositionsAleatoires(nbPersonnages);
        for(Point2D p : positions){
            Loup loup = new Loup();
            loup.setPos(p);
            this.listLoups.add(loup);
        }
        
        // Lapins
        nbPersonnages = generateurAleatoire.nextInt(maxNbPersonnages); 
        positions = this.generePositionsAleatoires(nbPersonnages);
        for(Point2D p : positions){
            Lapin l = new Lapin();
            l.setPos(p);
            this.listLapins.add(l);
        }
        
        // Soins
        nbPersonnages = generateurAleatoire.nextInt(maxNbPersonnages); 
        positions = this.generePositionsAleatoires(nbPersonnages);
        for(Point2D p : positions){
            Soin s = new Soin();
            s.setPos(p);
            this.listSoins.add(s);
        }
        
        // Manas
        nbPersonnages = generateurAleatoire.nextInt(maxNbPersonnages); 
        positions = this.generePositionsAleatoires(nbPersonnages);
        for(Point2D p : positions){
            Mana mana = new Mana();
            mana.setPos(p);
            this.listManas.add(mana);
        }

    }

    public ArrayList<Point2D> generePositionsAleatoires(int nbPositions) {
        // génération de nbPersonnages positions différentes
        ArrayList<Point2D> positions = new ArrayList<>();
        Random generateurAleatoire = new Random();
        Point2D newPos = new Point2D(generateurAleatoire.nextInt(this.tailleMonde), generateurAleatoire.nextInt(this.tailleMonde));
        positions.add(newPos);

        // On ajoute un point à positions dès lors qu'il n'existe pas déjà
        for (int i = 1; i < nbPositions; i++) {
            newPos = new Point2D(generateurAleatoire.nextInt(this.tailleMonde), generateurAleatoire.nextInt(this.tailleMonde));
            while (positions.contains(newPos)) {
                newPos = new Point2D(generateurAleatoire.nextInt(this.tailleMonde), generateurAleatoire.nextInt(this.tailleMonde));
            }
            positions.add(newPos);
           
        }

        return positions;
    }

    public void tourDeJeu() {
    }

    /**
     * Affichage textuel de tous les attributs de tous les créatures du monde.
     */
//    public void afficheWorld() {
//
//        System.out.println("Tous les personnages du monde :");
//        this.grosBill.affiche();
//        this.guillaumeT.affiche();
//        this.merlin.affiche();
//        this.peon.affiche();
//        this.robin.affiche();
//        System.out.println("Tous les monstres du monde :");
//        this.bugs1.affiche();
//        this.bugs2.affiche();
//        this.wolfie.affiche();
//    }
    
}
