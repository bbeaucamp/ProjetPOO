/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;


/**
 *
 * @author Benjamin
 */
public class TestSeance6 {
    
    public static void main(String[] args){
        testSauvegardePartie();
        //testChargementPartie();
        //testTourDeJeuJoueurHumain();
        //testDeplacementsPossibles();
    }
    
    public static void testSauvegardePartie() {
        World w = new World();
        w.setMaxCrea(5);
        w.setMaxObj(5);
        w.creeMondeAlea();
        w.afficheWorld();
        
        try {
            SauvegardePartie save = new SauvegardePartie("Sauvegarde-WoE-test.txt");
            save.sauvegarderPartie(w);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void testChargementPartie() {
        try {
            ChargementPartie load = new ChargementPartie("Sauvegarde-WoE.txt");
            World w = load.chargerPartie();
            w.afficheWorld();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
    }
    
    public static void testTourDeJeuJoueurHumain(){
        System.out.println("Test de la méthode tourDeJeuJoueurHumain");
        // Combattant cac
        System.out.println("Test pour un combattant au corps à corps :");
        World w = new World();
        w.creeMondeAlea();
        Joueur j = w.getListeJoueurs().get(0); // on sélectionne un joueur du monde
        j.getPerso().affiche();
        
        // Pour tester les méthodes, on ajoute des créatures autour de sa position
        LinkedList<Creature> listCreatures = (LinkedList) w.getListeCreatures();
        Point2D posJoueur = j.getPerso().getPos();
        Point2D newPos = new Point2D(posJoueur);
        newPos.translate(0,1);
        if (!w.getPositionsOccupees().contains(newPos)) {
            listCreatures.get(0).setPos(newPos); // On utilise setPos plutôt que deplacer pour les tests
        }
        newPos = new Point2D(posJoueur);
        newPos.translate(-1,-1);
        if (!w.getPositionsOccupees().contains(newPos)) {
            listCreatures.get(1).setPos(newPos);
        }
        
        w.tourDeJeuJoueurHumain(j); // test déplacement
        j.getPerso().affiche();
        w.tourDeJeuJoueurHumain(j); // test combat
        j.getPerso().affiche();
        
        // Combattant cac
        System.out.println("Test pour un combattant à distance :");
        w = new World();
        w.creeMondeAlea();
        j = w.getListeJoueurs().get(0); // on sélectionne un joueur du monde
        j.getPerso().affiche();
        
        // Pour tester les méthodes, on ajoute des créatures autour de sa position
        listCreatures = (LinkedList) w.getListeCreatures();
        posJoueur = j.getPerso().getPos();
        newPos = new Point2D(posJoueur);
        newPos.translate(0,3);
        listCreatures.get(0).setPos(newPos);
        newPos = new Point2D(posJoueur);
        newPos.translate(-2,-2);
        listCreatures.get(1).setPos(newPos);
        
        w.tourDeJeuJoueurHumain(j); // test déplacement
        j.getPerso().affiche();
        w.tourDeJeuJoueurHumain(j); // test combat
        j.getPerso().affiche();
    }
    
    public static void testDeplacementsPossibles(){
        System.out.println("Test de la méthode deplacementsPossibles");
        World w = new World(); // monde vide
        ArrayList<Point2D> positionsPossibles;
        Point2D pos;
        
        // Au milieu d'un monde vide
        pos = new Point2D(5, 5);
        positionsPossibles = w.deplacementsPossibles(pos);
        System.out.println("Positions atteignables à partir de " + pos.toString() + " (" + positionsPossibles.size() + ") :");
        System.out.println(positionsPossibles);
        
        // Au bord du monde
        pos = new Point2D(0, 0);
        positionsPossibles = w.deplacementsPossibles(pos);
        System.out.println("Positions atteignables à partir de " + pos.toString() + " (" + positionsPossibles.size() + ") :");
        System.out.println(positionsPossibles);
        
        // Avec des créatures sur les cases adjacentes
        pos = new Point2D(5, 5);
        ArrayList<Point2D> posOccupees = (ArrayList)w.getPositionsOccupees();
        posOccupees.add(new Point2D(5,6));
        posOccupees.add(new Point2D(4,5));
        positionsPossibles = w.deplacementsPossibles(pos);
        System.out.print("Positions occupées : ");
        System.out.println(posOccupees);
        System.out.println("Positions atteignables à partir de " + pos.toString() + " (" + positionsPossibles.size() + ") :");
        System.out.println(positionsPossibles);
    }
}
