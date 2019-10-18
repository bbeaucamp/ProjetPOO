/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.ArrayList;
import java.util.LinkedList;


/**
 *
 * @author Benjamin
 */
public class TestSeance6 {
    
    public static void main(String[] args){
        //testTourDeJeuJoueurHumain();
        testDeplacementsPossibles();
    }
    
    public static void testTourDeJeuJoueurHumain(){
        System.out.println("Test de la méthode tourDeJeuJoueurHumain");
        World w = new World();
        w.creeMondeAlea();
        Joueur j = w.getListeJoueurs().get(0); // on sélectionne un joueur du monde
        
        // Pour tester les méthodes, on ajoute des créatures autour de sa position
        LinkedList listCreatures = (LinkedList) w.getListeCreatures();
        w.tourDeJeuJoueurHumain(j);
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
        LinkedList<Point2D> posOccupees = (LinkedList)w.getPositionsOccupees();
        posOccupees.add(new Point2D(5,6));
        posOccupees.add(new Point2D(4,5));
        positionsPossibles = w.deplacementsPossibles(pos);
        System.out.print("Positions occupées : ");
        System.out.println(posOccupees);
        System.out.println("Positions atteignables à partir de " + pos.toString() + " (" + positionsPossibles.size() + ") :");
        System.out.println(positionsPossibles);
    }
}
