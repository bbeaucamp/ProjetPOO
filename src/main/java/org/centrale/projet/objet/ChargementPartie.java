/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author muruowang
 */

public class ChargementPartie {
    
    /**
     *Le nom du fichier de sauvegarde à charger.
     */
    private String nomFiche;
    private BufferedReader fichier;

    public ChargementPartie(String nomFiche) throws FileNotFoundException {
        this.nomFiche = nomFiche;
        this.fichier =   new BufferedReader(new FileReader(nomFiche));
         lecture();
      
    }

    public String getNomFiche() {
        return nomFiche;
    }

    public void setNomFiche(String nomFiche) {
        this.nomFiche = nomFiche;
    }

    
//        public static void main(String args[]) throws FileNotFoundException {
//        ChargementPartie testBufferedReader = new ChargementPartie("Sauvegarde-WoE.txt");
//    }

    private void lecture() {
        try {
            String ligne;
            ligne = this.fichier.readLine();
            while (ligne != null) {
                System.out.println(ligne);
                ligne = this.fichier.readLine();
            }

            fichier.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public World chargerPartie(World w){
        World w1 = new World();
        w1.setTailleMonde(0);
        w1.setListeCreatures(listeCreatures);
        w1.setListeJoueurs(listeJoueurs);
        w1.setListeObjets(listeObjets);
    
        return w1;
    }
    
    public void static creerElementJeu(params){
    
    }
    
}
