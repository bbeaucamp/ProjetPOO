/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Random;
import java.util.StringTokenizer;

/**
 * Un loup du jeu World of ECN. C'est un monstre qui attaque au corps à corps.
 * @author muruowang
 */
public class Loup extends Monstre implements Combattant  {

    public Loup(int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, int ptPar, Point2D pos) {
        super(ptVie, pourcentageAtt, pourcentagePar, degAtt, ptPar, pos);
    }

    /**
     * Le constructeur sans paramètres. Possède les valeurs par défaut d'un 
     * Monstre, sauf pour : pourcentagePar, degAtt.
     */
    public Loup() {
        super();
        Random generateurAleatoire = new Random();
        this.setPourcentagePar(45 + generateurAleatoire.nextInt(10));
        this.setDegAtt(15 + generateurAleatoire.nextInt(7));

    }
    
    public static Loup fromString(String params){
        StringTokenizer tokenizer = new StringTokenizer(params, " ");
        tokenizer.nextToken();
        return new Loup(Integer.parseInt(tokenizer.nextToken()),
                Integer.parseInt(tokenizer.nextToken()),
                Integer.parseInt(tokenizer.nextToken()),
                Integer.parseInt(tokenizer.nextToken()),
                Integer.parseInt(tokenizer.nextToken()),
                Point2D.fromString(tokenizer.nextToken()));
    }
    
    public Loup(String params){
        super();
        StringTokenizer tokenizer = new StringTokenizer(params, " ");
        
    }

    /**
     * Le constructeur de recopie. Crée une copie profonde du loup.
     *
     * @param l Le loup à copier.
     */
    public Loup(Loup l) {
        super(l);
    }  
       /**
     * Méthode pour le combat au coprs à corps. Ne marche que si la distance entre
     * l'attaquant et la créature est égale à  1. 
     *
     * @param c La créature attaquée par le loup.
     */
    @Override
    public void combattre(Creature c) {

        if (c.getPos().distance(this.getPos()) == 1) {
            Random generateurAleatoire = new Random();
            // Tentative d'attaque
            int jetAttaque = 1 + generateurAleatoire.nextInt(100);
            System.out.println("Jet d'attaque : " + jetAttaque + ". Pourcentage d'attaque : " + this.getPourcentageAtt());
            if (jetAttaque <= c.getPourcentageAtt()) {
                System.out.println("Attaque au corps à corps réussie !");
                int qteDegats = this.getDegAtt();
                // Tentative de parade
                int jetDefense = 1 + generateurAleatoire.nextInt(100);
                System.out.println("Jet de parade : " + jetDefense + ". Pourcentage de parade : " + c.getPourcentagePar());
                if (jetDefense <= c.getPourcentagePar()) {
                    System.out.println("Parade réussie !");
                    qteDegats = qteDegats - c.getPtPar();
                }else {
                    System.out.println("Parade échouée !");
                }
                // Applique les dégâts à l'adversaire
                if (qteDegats > 0) {
                    System.out.println(qteDegats + " dégâts sont infligés");
                    c.setPtVie(c.getPtVie() - qteDegats);
                } else {
                    System.out.println("Aucun dégâts subis");
                }
            } else {
                System.out.println("Attaque au corps à corps échouée !");
            }
        } else {
            System.out.println("La créature est trop loin");
        }
    }
    
    public String toString(){
        String res;
        res = "Loup " + this.getPtVie() + " " + this.getPourcentageAtt() + " " +
                this.getPourcentagePar() + " " + this.getDegAtt() + " " + 
                this.getPtPar() + " " + this.getPos().toString();
        return res;
    }
    
}
