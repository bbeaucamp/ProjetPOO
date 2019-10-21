/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;
import java.util.Random;
import java.util.StringTokenizer;

/**
 * Un lapin du jeu World of ECN.
 * @author muruowang
 */
// classe Lapion héritage calsee Monstre
public class Lapin extends Monstre  {

    private String nomAffichage = "La";
    
    public Lapin(int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, int ptPar, Point2D pos) {
        super(ptVie, pourcentageAtt, pourcentagePar, degAtt, ptPar, pos);
    }

    public Lapin(Lapin l) {
        // Chaque constructeur d’une sous-classe doit faire un appel au constructeur de sa super-classe : super(...)
        // mais si on obulie, java va le faire pour vous
        super(l);
    }

    /**
     * Le constructeur sans paramètres. Initialise les attributs de manière
     * arbitraire.
     */
    //Possède toutes les valeurs par défaut de Creature.
    public Lapin() {
        super();
        Random generateurAleatoire = new Random();
        this.setPtVie(10 + generateurAleatoire.nextInt(7));
        this.setPourcentageAtt(30 + generateurAleatoire.nextInt(10));
        this.setPourcentagePar(20 + generateurAleatoire.nextInt(15));
        this.setDegAtt(5 + generateurAleatoire.nextInt(3));
        this.setPtPar(2 + generateurAleatoire.nextInt(4));
    }
    
    /**
     * Renvoie un lapin à partir d'une chaine de caractères qui spécifie ses
     * attributs. Cette méthode est utilisée pour charger une partie depuis
     * un fichier de sauvegarde.
     * @param params Chaine de caractère spécifiant les attributs de la créature,
     * dans l'ordre du constructeur avec tous les paramètres, et séparés par un
     * espace.
     * @return Un lapin.
     */
    public static Lapin fromString(String params) {
        StringTokenizer tokenizer = new StringTokenizer(params, " ");
        tokenizer.nextToken();
        return new Lapin(Integer.parseInt(tokenizer.nextToken()),
                Integer.parseInt(tokenizer.nextToken()),
                Integer.parseInt(tokenizer.nextToken()),
                Integer.parseInt(tokenizer.nextToken()),
                Integer.parseInt(tokenizer.nextToken()),
                Point2D.fromString(tokenizer.nextToken()));
    }

    public String getNomAffichage() {
        return nomAffichage;
    }

    public void setNomAffichage(String nomAffichage) {
        this.nomAffichage = nomAffichage;
    }
    
    public String toString(){
        String res;
        res = "Lapin " + this.getPtVie() + " " + this.getPourcentageAtt() + " " +
                this.getPourcentagePar() + " " + this.getDegAtt() + " " + 
                this.getPtPar() + " " + this.getPos().toString();
        return res;
    }
    
    

}
