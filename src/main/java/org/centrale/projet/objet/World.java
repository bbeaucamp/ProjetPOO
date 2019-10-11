/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.*;
import java.util.Scanner;

/**
 * Le monde 2D dans lequel évolue les créatures du jeu World of ECN.
 *
 * @author muruowang
 */
public class World {

    /**
     * La liste des créatures sur le plateau.
     */
    private List<Creature> listeCreatures;

    /**
     * La liste des objets sur le plateau.
     */
    private List<Objet> listeObjets;

    /**
     * La liste des joueurs.
     */
    private List<Joueur> listeJoueurs;

    /**
     * La liste des positions occupées sur le plateau.
     */
    private List<Point2D> positionsOccupees;

    /**
     * La taille d'un côté du monde, supposé carré.
     */
    private int tailleMonde;

    /**
     * Le nombre maximal de créatures d'une sous-classe (Archer, Paysan, Loup,
     * ...) généré à l'intialisation du monde.
     */
    private int maxCrea;

    /**
     * Le nombre maximal d'objets d'une sous-classe (Soin, Mana, Nuage Toxique,
     * ...) généré à l'intialisation du monde.
     */
    private int maxObj;

    /**
     * Le nombre de joueurs.
     */
    private int nJoueurs;

    /**
     * Le constructeur sans paramètres qui initialise les créatures avec leurs
     * valeurs par défaut puis attribue un nom à chaque personnage.
     */
    public World() {

        this.listeCreatures = new LinkedList<>();
        this.listeObjets = new LinkedList<>();
        this.listeJoueurs = new LinkedList<>();
        this.positionsOccupees = new LinkedList<>();
        this.tailleMonde = 50;
        this.maxCrea = 40;
        this.maxObj = 5;
        this.nJoueurs= 1;
    }

    public List<Creature> getListeCreatures() {
        return listeCreatures;
    }

    public List<Objet> getListeObjets() {
        return listeObjets;
    }

    public List<Joueur> getListeJoueurs() {
        return listeJoueurs;
    }

    public List<Point2D> getPositionsOccupees() {
        return positionsOccupees;
    }

    /**
     * Place toutes les créatures dans le monde 2D (50*50), en s'assurant qu'ils
     * aient tous une position différente.
     */
    public void creeMondeAlea() {
        Random generateurAleatoire = new Random();

        int nArcher = generateurAleatoire.nextInt(this.maxCrea);
        int nGuerrier = generateurAleatoire.nextInt(this.maxCrea);
        int nPaysan = generateurAleatoire.nextInt(this.maxCrea);
        int nMage = generateurAleatoire.nextInt(this.maxCrea);
        int nLoup = generateurAleatoire.nextInt(this.maxCrea);
        int nLapin = generateurAleatoire.nextInt(this.maxCrea);

        int nSoin = generateurAleatoire.nextInt(this.maxObj);
        int nMana = generateurAleatoire.nextInt(this.maxObj);
        int nNuageToxique = generateurAleatoire.nextInt(this.maxObj);
        int nDegAttBonus = generateurAleatoire.nextInt(this.maxObj);
        int nDegAttMalus = generateurAleatoire.nextInt(this.maxObj);

        int nCrea = nArcher + nGuerrier + nPaysan + nMage + nLoup + nLapin;
        int nObj = nSoin + nMana + nNuageToxique + nDegAttBonus + nDegAttMalus;
        this.positionsOccupees = generePositionsAleatoires(nCrea + nObj + this.nJoueurs);
        Iterator<Point2D> positionsIt = this.positionsOccupees.iterator();

        // Initialisation des créatures
        int i;
        // Archers
        for (i = 0; i < nArcher; i++) {
            Archer crea = new Archer();
            crea.setPos(positionsIt.next());
            this.listeCreatures.add(crea);
        }

        // Guerriers
        for (i = 0; i < nGuerrier; i++) {
            Guerrier crea = new Guerrier();
            crea.setPos(positionsIt.next());
            this.listeCreatures.add(crea);
        }

        // Paysans
        for (i = 0; i < nPaysan; i++) {
            Paysan crea = new Paysan();
            crea.setPos(positionsIt.next());
            this.listeCreatures.add(crea);
        }

        // Mages
        for (i = 0; i < nMage; i++) {
            Mage crea = new Mage();
            crea.setPos(positionsIt.next());
            this.listeCreatures.add(crea);
        }

        // Loups
        for (i = 0; i < nLoup; i++) {
            Loup crea = new Loup();
            crea.setPos(positionsIt.next());
            this.listeCreatures.add(crea);
        }

        // Lapin
        for (i = 0; i < nLapin; i++) {
            Lapin crea = new Lapin();
            crea.setPos(positionsIt.next());
            this.listeCreatures.add(crea);
        }

        // Initialisation des objets
        // Soins
        for (i = 0; i < nSoin; i++) {
            Soin obj = new Soin();
            obj.setPos(positionsIt.next());
            this.listeObjets.add(obj);
        }

        // Manas
        for (i = 0; i < nMana; i++) {
            Mana obj = new Mana();
            obj.setPos(positionsIt.next());
            this.listeObjets.add(obj);
        }

        // Nuages Toxiques
        for (i = 0; i < nNuageToxique; i++) {
            NuageToxique obj = new NuageToxique();
            obj.setPos(positionsIt.next());
            this.listeObjets.add(obj);
        }

        // Nourriture bonus dégât d'attaque
        for (i = 0; i < nDegAttBonus; i++) {
            DegAttBonus obj = new DegAttBonus();
            obj.setPos(positionsIt.next());
            this.listeObjets.add(obj);
        }

        // Nourriture malus dégât d'attaque
        for (i = 0; i < nDegAttMalus; i++) {
            DegAttMalus obj = new DegAttMalus();
            obj.setPos(positionsIt.next());
            this.listeObjets.add(obj);
        }

        // Initialisation des joueurs
        for (i = 0; i < this.nJoueurs; i++) {
            System.out.println("Joueur " + i + ", entrez vos choix.");
            Joueur nouveauJoueur = this.creeJoueur();
            nouveauJoueur.getPerso().setPos(positionsIt.next());
            this.listeJoueurs.add(nouveauJoueur);
        }
        
        /* On met à jour positionsOccupees en ne gardant que les positions des créatures
        et des joueurs.
        Les positions des objets sont accessibles pour les créatures.
        */
        this.positionsOccupees = new LinkedList<>();
        for (Creature c : this.listeCreatures) {
            this.positionsOccupees.add(c.getPos());
        }
        for (Joueur j : this.listeJoueurs) {
            this.positionsOccupees.add(j.getPerso().getPos());
        }
        
    }

    /**
     * Génère un certain nombre de positions sur le plateau, toutes distinctes.
     *
     * @param nbPositions Le nombre de positions à générer
     * @return La liste des positions générées.
     */
    public LinkedList<Point2D> generePositionsAleatoires(int nbPositions) {

        // génération de nbPersonnages positions différentes
        LinkedList<Point2D> positions = new LinkedList<>();
        Random generateurAleatoire = new Random();
        Point2D newPos = new Point2D(generateurAleatoire.nextInt(this.tailleMonde), generateurAleatoire.nextInt(this.tailleMonde));
        positions.add(newPos);

        // On ajoute un point à positions dès lors qu'il n'existe pas déjà
        for (int i = 1; i < nbPositions; i++) {
            newPos = new Point2D(generateurAleatoire.nextInt(this.tailleMonde), generateurAleatoire.nextInt(this.tailleMonde));
            while (positions.contains(newPos) && !this.verifierDistanceMin(positions, newPos)) {
                newPos = new Point2D(generateurAleatoire.nextInt(this.tailleMonde), generateurAleatoire.nextInt(this.tailleMonde));
            }
            positions.add(newPos);
        }

        return positions;
    }

    /**
     * Crée un nouveau joueur suivant les valeurs entrées par l'utilisateur.
     * @return Le joueur créé.
     */
    public Joueur creeJoueur() {
        Joueur nouveauJoueur = new Joueur();
        
        // Choix de la classe 
        System.out.println("Quel classe désirez-vous jouer ?");
        System.out.println("Choix possibles : Archer, Guerrier, Mage");
        Scanner input = new Scanner(System.in);
        String choix = input.nextLine();
        while (!choix.toLowerCase().equals("archer") && !choix.toLowerCase().equals("guerrier")
                && !choix.toLowerCase().equals("mage")) {
            System.out.println(choix.toLowerCase());
            System.out.println("Erreur. Entrez à nouveau votre choix.");
            System.out.println("Choix possibles : Archer, Guerrier, Mage");
            input = new Scanner(System.in);
            choix = input.nextLine();
        }

        switch (choix.toLowerCase()) {
            case "archer":
                nouveauJoueur.setPerso(new Archer());
                break;
            case "guerrier":
                nouveauJoueur.setPerso(new Guerrier());
                break;
            case "mage":
                nouveauJoueur.setPerso(new Mage());
                break;
            default:
                nouveauJoueur.setPerso(new Archer());
                break;
        }
        
        // Choix du nom
        System.out.println("Entrez un nom pour votre personnage :");
        input = new Scanner(System.in);
        nouveauJoueur.getPerso().setNom(input.nextLine());
        
        return nouveauJoueur;
    }
    /**
     * Vérifie si newPos est à une distance >= 3 de tous les points de positions.
     * @param positions
     * @param newPos
     * @return un booléen indiquant si newPos est à une distance >= 3 de tous les points de positions
     */
    public boolean verifierDistanceMin(LinkedList<Point2D> positions, Point2D newPos) {
        boolean res = true;
        for (Point2D p : positions) {
            if (p.distance(newPos) < 3) {
                res = false;
            }
        }
        return res;
    }

    /**
     * Parcourt la liste des joueurs et des créatures et met à jour la nourriture
     * de chaque personnage rencontré.
     */
    public void miseAJourNourritureWorld() {
        for (Joueur j : this.listeJoueurs){
            this.miseAJourNourriturePersonnage(j.getPerso());
        }
        
        for (Creature c: this.listeCreatures) {
            if (c instanceof Personnage){
                this.miseAJourNourriturePersonnage((Personnage)c);
            }
        }
    }
    
    /**
     * Parcourt la liste de nourriture du personnage, met à jour
     * ses caractéristique et le compteur de tours restants.
     * @param p 
     */
    public void miseAJourNourriturePersonnage(Personnage p) {
        Iterator<Nourriture> nourritureIt = p.getListeNourriture().iterator();
        Nourriture n;
        while(nourritureIt.hasNext()){
            n = nourritureIt.next();
            n.consommer(p);
            if (n.getNTours() == 0){ // La nourriture a été entièrement consommée
                nourritureIt.remove(); 
            }
        }
        
    }
    
    public void tourDeJeu() {
        
    }

}
