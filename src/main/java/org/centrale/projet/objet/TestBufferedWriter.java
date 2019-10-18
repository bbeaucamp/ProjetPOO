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
import java.io.*;

public class TestBufferedWriter {

    public static void main(String args[]) {
        BufferedWriter bufferedWriter = null;
        String filename = "monFichier.txt";

        try {
            // Creation du BufferedWriter
            bufferedWriter = new BufferedWriter(new FileWriter(filename));
            // On ecrit dans le fichier
            bufferedWriter.write("Ecriture ligne un dans le fichier");
            bufferedWriter.newLine();
            bufferedWriter.write("Ecriture ligne deux dans le fichier");
        } // on attrape l'exception si on a pas pu creer le fichier
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } // on attrape l'exception si il y a un probleme lors de l'ecriture dans le fichier
        catch (IOException ex) {
            ex.printStackTrace();
        } // on ferme le fichier
        finally {
            try {
                if (bufferedWriter != null) {
                    // je force l'écriture dans le fichier
                    bufferedWriter.flush();
                    // puis je le ferme
                    bufferedWriter.close();
                }
            } // on attrape l'exception potentielle 
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
