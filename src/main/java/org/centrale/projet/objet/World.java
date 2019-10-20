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
    private LinkedList<Creature> listeCreatures;

    /**
     * La liste des objets sur le plateau.
     */
    private LinkedList<Objet> listeObjets;

    /**
     * La liste des joueurs.
     */
    private LinkedList<Joueur> listeJoueurs;

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
     * Le nombre de joueurs. Seulement utilisé lors de la génération aléatoire du monde.
     */
    private int nJoueurs;

    /**
     * Les translations possibles depuis une positions sur la grille.
     */
    private List<Point2D> deplacementsUnitaires;

    /**
     * Le constructeur sans paramètres qui initialise les créatures avec leurs
     * valeurs par défaut puis attribue un nom à chaque personnage.
     */
    public World() {

        this.listeCreatures = new LinkedList<>();
        this.listeObjets = new LinkedList<>();
        this.listeJoueurs = new LinkedList<>();
        this.tailleMonde = 50;
        this.maxCrea = 40;
        this.maxObj = 5;
        this.nJoueurs = 1;
        this.deplacementsUnitaires = new ArrayList<>();
        this.deplacementsUnitaires.add(new Point2D(1, 0));
        this.deplacementsUnitaires.add(new Point2D(1, 1));
        this.deplacementsUnitaires.add(new Point2D(0, 1));
        this.deplacementsUnitaires.add(new Point2D(-1, 1));
        this.deplacementsUnitaires.add(new Point2D(-1, 0));
        this.deplacementsUnitaires.add(new Point2D(-1, -1));
        this.deplacementsUnitaires.add(new Point2D(0, -1));
        this.deplacementsUnitaires.add(new Point2D(1, -1));
    }

    public void setMaxCrea(int maxCrea) {
        this.maxCrea = maxCrea;
    }

    public void setMaxObj(int maxObj) {
        this.maxObj = maxObj;
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

    public void setListeCreatures(LinkedList<Creature> listeCreatures) {
        this.listeCreatures = listeCreatures;
    }

    public void setListeObjets(LinkedList<Objet> listeObjets) {
        this.listeObjets = listeObjets;
    }

    public void setListeJoueurs(LinkedList<Joueur> listeJoueurs) {
        this.listeJoueurs = listeJoueurs;
    }

    public int getTailleMonde() {
        return tailleMonde;
    }

    public void setTailleMonde(int tailleMonde) {
        this.tailleMonde = tailleMonde;
    }

    /**
     * Renvoie la liste des positions occupées sur le plateau.
     * @return Renturn les positions occupées.
     */
    public ArrayList<Point2D> getPositionsOccupees() {
        ArrayList positionsOccupees = new ArrayList<>();
        for (Creature c : this.listeCreatures) {
            positionsOccupees.add(c.getPos());
        }
        for (Joueur j : this.listeJoueurs) {
            positionsOccupees.add(j.getPerso().getPos());
        }
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
        LinkedList<Point2D> positionsDisponibles = generePositionsAleatoires(nCrea + nObj + this.nJoueurs);
        Iterator<Point2D> positionsIt = positionsDisponibles.iterator();

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
     *
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
     * Vérifie si newPos est à une distance supérier ou égale à 3 de tous les points de
     * positions.
     *
     * @param positions Position de Point2D
     * @param newPos Génrer les nouvelles positions dans la liste
     * @return un booléen indiquant si newPos est à une distance supérier ou égale à 3 de tous
     * les points de positions
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
     * Parcourt la liste des joueurs et des créatures et met à jour la
     * nourriture de chaque personnage rencontré.
     */
    public void miseAJourNourritureWorld() {
        for (Joueur j : this.listeJoueurs) {
            this.miseAJourNourriturePersonnage(j.getPerso());
        }

        for (Creature c : this.listeCreatures) {
            if (c instanceof Personnage) {
                this.miseAJourNourriturePersonnage((Personnage) c);
            }
        }
    }

    /**
     * Parcourt la liste de nourriture du personnage, met à jour ses
     * caractéristique et le compteur de tours restants.
     *
     * @param p Type Personngae
     */
    public void miseAJourNourriturePersonnage(Personnage p) {
        Iterator<Nourriture> nourritureIt = p.getListeNourriture().iterator();
        Nourriture n;
        while (nourritureIt.hasNext()) {
            n = nourritureIt.next();
            n.consommer(p);
            if (n.getNTours() == 0) { // La nourriture a été entièrement consommée
                nourritureIt.remove();
            }
        }

    }

    public void afficheWorld(){
        System.out.println("Taille du monde : " + this.tailleMonde);
        System.out.println("");
        System.out.println("Nombre de créatures  : " + this.listeCreatures.size());
        System.out.println("Première créature de la liste : "); 
        this.listeCreatures.get(0).affiche();
        System.out.println("");
        System.out.println("Nombre de joueurs : " + this.listeJoueurs.size());
        System.out.println("Premier joueur de la liste : "); 
        this.listeJoueurs.get(0).affiche();
        System.out.println("");
        System.out.println("Nombre d'objets : " + this.listeObjets.size());
        System.out.println("Premier objet de la liste : "); 
        this.listeObjets.get(0).affiche();
        
    }
    
    public void tourDeJeu() {

    }

    /**
     * Fais jouer un tour de jeu à un joueur humain. Celui-ci a le choix de se
     * déplacer ou de combattre une autre créature.
     *
     * @param j La joueur qui va jouer son tour.
     */
    public void tourDeJeuJoueurHumain(Joueur j) {
        Personnage perso = j.getPerso();
        Scanner input;
        System.out.println("Voulez-vous vous déplacer (1) ou combattre (2) ?");
        System.out.println("Entrez le numéro correspondant à votre choix :");

        input = new Scanner(System.in);
        int choixAction = input.nextInt();
        while ((choixAction != 1) && (choixAction != 2)) {
            input = new Scanner(System.in);
            choixAction = input.nextInt();
        }

        int choixMax;
        switch (choixAction) {
            case 1:
                // Liste des positions atteignables
                ArrayList<Point2D> deplacementsAutorises = deplacementsPossibles(j.getPerso().getPos());
                System.out.print("Positions possibles :");
                System.out.println(deplacementsAutorises);
                choixMax = deplacementsAutorises.size() - 1;
                if (choixMax >= 0) { // il y a au moins une case atteignable
                    System.out.println("Choisissez une position que vous souhaitez atteindre (0 à " + choixMax + ") :");
                    input = new Scanner(System.in);
                    int choixDeplacement = input.nextInt();
                    while (choixDeplacement < 0 || choixDeplacement > choixMax) {
                        System.out.println("Choix invalide.");
                        System.out.println("Choisissez une position que vous souhaitez atteindre (0 à " + choixMax + ") :");
                        input = new Scanner(System.in);
                        choixDeplacement = input.nextInt();
                    }
                    j.getPerso().deplacer(deplacementsAutorises.get(choixDeplacement), this.getPositionsOccupees(), this.tailleMonde);
                } else {
                    System.out.println("Il n'y a aucune position atteignable.");
                }
                break;
            case 2:
                // Liste des créatures que le joueur peut attaquer
                ArrayList<Creature> creaturesAttaquables = combatsPossibles(j);
                System.out.println("Les créatures à proximité :");
                for (int i = 0; i < creaturesAttaquables.size(); i++) {
                    Creature c = creaturesAttaquables.get(i);
                    System.out.println(i + " : " + c.getPos().toString() + " Points de vie : " + c.getPtVie());
                }

                // Choix du joueur
                choixMax = creaturesAttaquables.size() - 1;
                if (choixMax >= 0) {
                    System.out.println("Choisissez une créature que vous souhaitez attaquer (0 à " + choixMax + ") :");
                    input = new Scanner(System.in);
                    int choix = input.nextInt();
                    while (choix < 0 || choix > choixMax) {
                        System.out.println("Choix invalide.");
                        System.out.println("Choisissez une créature que vous souhaitez attaquer (0 à " + choixMax + ") :");
                        input = new Scanner(System.in);
                        choix = input.nextInt();
                    }

                    // Combat !
                    if (perso instanceof Combattant){
                        Combattant jCombattant = (Combattant)perso;
                        jCombattant.combattre(creaturesAttaquables.get(choix));
                    }
                } else {
                    System.out.println("Il n'y a pas de créature à attaquer à proximité");
                }
                
                break;
            default:
                System.out.println("Choix invalide");

        }
    }

    /**
     * Renvoie la liste des déplacements possibles à partir d'une position
     * donnée
     *
     * @param p La position de départ
     * @return Une liste de positions atteignables.
     */
    public ArrayList<Point2D> deplacementsPossibles(Point2D p) {
        ArrayList<Point2D> deplacements = new ArrayList<>();
        Point2D nouveauDeplacement;
        for (int i = 0; i < 8; i++) {
            nouveauDeplacement = new Point2D(p);
            Point2D depUnitaire = this.deplacementsUnitaires.get(i);
            nouveauDeplacement.translate(depUnitaire.getX(), depUnitaire.getY());
            if (positionInBounds(nouveauDeplacement) && !getPositionsOccupees().contains(nouveauDeplacement)) {
                deplacements.add(nouveauDeplacement);
            }
        }
        return deplacements;
    }

    /**
     * Indique si une position est sur la grille ou non.
     *
     * @param p Type Point2D
     * @return Un point 
     */
    public boolean positionInBounds(Point2D p) {
        int x = p.getX();
        int y = p.getY();

        return (x >= 0) && (x < this.tailleMonde)
                && (y >= 0) && (y < this.tailleMonde);
    }

    /**
     * Renvoie la liste des créatures attaquables par le joueur.
     *
     * @param j L'attaquant
     * @return La liste des créatures attaquables
     */
    public ArrayList<Creature> combatsPossibles(Joueur j) {
        Personnage p = j.getPerso();
        Point2D posJoueur = p.getPos();
        int distAttMax = p.getDistAttMax();
        ArrayList<Creature> creaturesAttaquables = new ArrayList<>();

        for (Creature c : this.listeCreatures) {
            if (posJoueur.distance(c.getPos()) <= distAttMax) {
                creaturesAttaquables.add(c);
            }
        }

        return creaturesAttaquables;
    }
}
