/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.ArrayList;

/**
 * Interface pour permettre à certaines entités de se déplacer sur le plateau de jeu.
 * @author muruowang
 */
interface Deplacable {
    
    /**
     * Deplace une entité vers une nouvelle position si elle est libre.
     * @param nouvellePosition La position atteinte par l'entité si elle est libre.
     * @param positionsOccupees La liste des positions sur lesquelles l'entité ne peut pas se déplacer
     * @param dimension La taille du monde dans lequel l'entité se déplace.
     */
    public void deplacer(Point2D nouvellePosition, ArrayList<Point2D> positionsOccupees, int dimension);
}
