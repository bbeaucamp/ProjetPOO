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
import java.util.Date;
import java.sql.Timestamp;

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

    public SauvegardePartie() throws FileNotFoundException, IOException {

        Date date = new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);
        this.nomFichier = "Sauvegarde-WoE-timestamp" + ts + ".txt"; // Mieux avec un timestamp
        this.fichier = new BufferedWriter(new FileWriter(this.nomFichier));
    }

    public String getNomFichier() {
        return nomFichier;
    }

    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    public void sauvegarderPartie(World w) {
        try {
            this.fichier.write("tailleMonde " + w.getTailleMonde());
            this.fichier.newLine();

            for (Creature c : w.getListeCreatures()) {
                this.fichier.write(c.toString());
                this.fichier.newLine();
            }

            for (Objet o : w.getListeObjets()) {
                this.fichier.write(o.toString());
                this.fichier.newLine();
            }

            for (Joueur j : w.getListeJoueurs()) {
                this.fichier.write(j.toString());
                this.fichier.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (this.fichier != null) {
                    this.fichier.flush();
                    this.fichier.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
