/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.LinkedList;
import java.util.List;
import static org.centrale.projet.objet.TestSeance3.testcreeMondeAlea;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author Benjamin
 */
public class TestSeance5 {
    
    public static void main(String[] args) {
        //testNullPointer();
        //testArrayOfBound();
        //testArithmeic();
        //testClassCast();
        //testNumberFormat();
        //testStackOverflow();
        //testConcurrentModifiaction();
        testCreeMondeAlea();
    }
    
    public static void testCreeMondeAlea(){
        System.out.println("Test de la création aléatoire du monde :");
        World w = new World();
        w.creeMondeAlea();
        
        System.out.print("Est-ce-qu'il y a des positions en double ? ");
        boolean positionEnDouble = false;
        List<Point2D> posOccupees = new LinkedList<Point2D>(w.getPositionsOccupees());
        for(Point2D p : w.getPositionsOccupees()){
            posOccupees.remove(p);
            if (posOccupees.contains(p)){
                positionEnDouble = true;
                p.affiche();
            }
        }
        System.out.println(positionEnDouble);
        
        System.out.println("");
        System.out.println("Personnages des joueurs :");
        for(Joueur j : w.getListeJoueurs()){
            j.getPerso().affiche();
        }
        
        System.out.println("");
        System.out.println("Nombre de créatures générées : " + w.getListeCreatures().size());
        System.out.println("Première créature de la liste : "); 
        w.getListeCreatures().get(0).affiche();
        System.out.println("Nombre d'objets généres : " + w.getListeObjets().size());
        System.out.println("Premier objet de la liste : "); 
        w.getListeObjets().get(0).affiche();
    }
    
    // NullPointerException
    public static void testNullPointer() {
        try {
            World w = null;

            w.creeMondeAlea();

        } catch (NullPointerException ex) {
            System.err.println("NullPointerException : " + ex.getMessage());
        }
    }

    // ArrayIndexOutOfBoundsException
    public static void testArrayOfBound() {

        try {
            String[] name = {"tom", "dick", "harry"};
            for (int i = 0; i <= name.length; i++) {
                System.out.println(name[i]);

            }

        } catch (ArrayIndexOutOfBoundsException ex) {

            System.err.println("ArrayIndexOutOfBoundsException : " + ex.getMessage());
        }

    }

    // ArithmeticException
    public static void testArithmeic() {
        try {
            int x = 19;
            int y = 0;
            int z = x / y;
            System.out.println("La valeur de x est " + z);
        } catch (ArithmeticException ex) {
            System.err.println("ArithmeticException : " + ex.getMessage());
        }
    }

    // ClassCastException
    public static void testClassCast() {
        try {
            Object i = Integer.valueOf(42);
            String s = (String) i;
        } catch (ClassCastException ex) {
            System.err.println("ClassCastException : " + ex.getMessage());
        }
    }

    // NumberFormatException
    public static void testNumberFormat() {
        try {
            String today = "" + System.currentTimeMillis();
            long todayLong = Long.parseLong(today);
            System.out.println("L'heure est " + todayLong);
        } catch (NumberFormatException ex) {
            System.err.println("NumberFormatException : " + ex.getMessage());
        }
    }

    // StackOverflowError
    public static void testStackOverflow() {
        try {
            testStackOverflow();
        } catch (StackOverflowError ex) {
            System.err.println("StackOverflowError : " + ex.getMessage());
        }
    }

    // ConcurrentModificationException
    public static void testConcurrentModifiaction() {
        try {

            List<String> list = new ArrayList<>();

            list.add("1");
            list.add("2");
//            for (Iterator<String> it = list.iterator(); it.hasNext();) {
//                String value = it.next();
//
//                if (value.equals("2")) {
//                    it.remove();
//                    list.add("6");
//                }
//
//            }

            List<String> newList = list.stream()
                    .map(s -> s.equals("2") ? "6" : s)
                    .collect(Collectors.toList());
            System.out.println("La deuxième valeur est " + newList.get(1));

        } catch (ConcurrentModificationException ex) {
            System.err.println("ConcurrentModificationException : " + ex.getMessage());
        }
    }
}
