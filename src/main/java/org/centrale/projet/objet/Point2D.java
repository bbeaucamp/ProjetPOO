/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.StringTokenizer;

/**
 * Un point du plan, défini par deux coordonnées entières.
 *
 * @author muruowang
 */
public class Point2D {

    private int x;
    private int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point2D() {
        this.x = 0;
        this.y = 0;
    }

    public Point2D(Point2D p) {
        this.x = p.x;
        this.y = p.y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public void affiche() {
        System.out.println("[" + this.x + " ; " + this.y + "]");
    }

    /**
     * Teste si deux points sont à la même position.
     *
     * @param o L'objet à tester.
     * @return Un booléen indiquant si les deux points sont à la même position
     * ou non.
     */
    // CM2 : page 65
    // méthode pour vérifier  si les deux points  sont  à la même position
    // equals(...) permet de comparer deux objets de même type pour dire si ils sont égaux ou non
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        } else {
            Point2D p = (Point2D) o;
            return (this.x == p.getX() && this.y == p.getY());
        }
    }

    /**
     * Méthode pour obtenir une chaine de caractères indiquant la position du
     * point.
     *
     * @return La position du point sous la forme d'une chaine de caractères.
     */
    // CM2 : page 65
    // afficher les positions des objets
    //toString() permet d’obtenir une représentation de l’objet sous forme de chaîne de caractères
    public String toString() {
        return (this.x + "," + this.y);
    }

    /**
     * Calcule la distance entre deux points. La distance utilisée est la
     * distance associée à la norme l1 (valeur absolue).
     *
     * @param p Le point auquel on veut connaitre la distance.
     * @return La distance entre les deux points.
     */
    // méthode pour calculer la distance entre deux points
    // valeur absolue
    public double distance(Point2D p) {

        // double dis = Math.sqrt(Math.pow(this.x - p.getX(), 2) + Math.pow(this.y - p.getY(),2));  // racine 
        double dis = Math.sqrt((this.x - p.getX()) * (this.x - p.getX()) + (this.y - p.getY()) * (this.y - p.getY()));
        return dis;
    }
    
    public static Point2D fromString(String params) {
        StringTokenizer tokenizer = new StringTokenizer(params, ",");
        return new Point2D(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
    }

}
