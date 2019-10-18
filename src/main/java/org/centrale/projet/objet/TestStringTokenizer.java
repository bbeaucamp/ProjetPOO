/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jean-Marie Normand (jean-marie.normand@ec-nantes.fr)
 */
package org.centrale.projet.objet;
import java.util.StringTokenizer;

public class TestStringTokenizer {

    public static void main(String args[]) {
        String test = "Largeur 10,10";
        String delimiteurs = " ,.;";

        // on declare un 'tokenizer' qui va decouper 
        // 'test' en fonction de l'ensemble des delimiteurs
        StringTokenizer tokenizer = new StringTokenizer(test, delimiteurs);

        // Parcours de l'ensemble des unites lexicales de 'test'
        // hasMoreTokens() retourne 'vrai' tant qu'il reste des 'mots'
        // dans 'test' separes par un des delimiteurs (espace, 
        // virgule, etc.) declares plus haut
        while (tokenizer.hasMoreTokens()) {
            // nextToken() retourne la prochaine unite lexicale decoupee par les delimiteurs
            String mot = tokenizer.nextToken();
            // pour l'exemple, on transforme 'mot' en lettres minuscules
            mot = mot.toLowerCase();
            // on affiche 'mot' qui est maintenant en minuscules
            System.out.println(mot);
        }
    }
}
