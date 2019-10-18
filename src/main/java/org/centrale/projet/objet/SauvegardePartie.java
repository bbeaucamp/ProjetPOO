/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Benjamin
 */
public class SauvegardePartie {
    /**
     * Le nom du fichier de sauvegarde à charger.
     */
    private String nomFichier;
    private BufferedWriter fichier;

    public SauvegardePartie(String nomFichier) throws FileNotFoundException, IOException {
        this.nomFichier = nomFichier;
        this.fichier = new BufferedWriter(new FileWriter(this.nomFichier));

    }

    public String getNomFichier() {
        return nomFichier;
    }

    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    

    public World chargerPartie() {
}
