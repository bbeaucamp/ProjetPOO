/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.StringTokenizer;

/**
 *
 * @author muruowang
 */
public class ChargementPartie {

    /**
     * Le nom du fichier de sauvegarde à charger.
     */
    private String nomFiche;
    private BufferedReader fichier;

    public ChargementPartie(String nomFiche) throws FileNotFoundException {
        this.nomFiche = nomFiche;
        this.fichier = new BufferedReader(new FileReader(nomFiche));

    }

    public String getNomFiche() {
        return nomFiche;
    }

    public void setNomFiche(String nomFiche) {
        this.nomFiche = nomFiche;
    }

    public World chargerPartie() {
        World w = new World();
        String ligne;
        StringTokenizer tokenizer;
        String premierMot;
        
        try {
            ligne = this.fichier.readLine();
            while (ligne != null) {
                tokenizer = new StringTokenizer(ligne, " ");
                premierMot = tokenizer.nextToken();
                System.out.println(premierMot);
                if (premierMot.equals("tailleMonde")) {
                    w.setTailleMonde(Integer.parseInt(tokenizer.nextToken()));
                } else { // Une classe
                    Class classeElementJeu = Class.forName(premierMot);
                    Method fromString = classeElementJeu.getMethod("fromString", String.class);
                    Object elementJeu = fromString.invoke(null, ligne);
                    // On décide où doit être stocké l'élément de jeu
                    if (elementJeu instanceof Creature){
                        w.getListeCreatures().add((Creature) elementJeu);
                    } else if (elementJeu instanceof Objet){
                        w.getListeObjets().add((Objet) elementJeu);
                    } else { // intanceof Joueur
                        w.getListeJoueurs().add((Joueur) elementJeu);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return w;
    }

}
