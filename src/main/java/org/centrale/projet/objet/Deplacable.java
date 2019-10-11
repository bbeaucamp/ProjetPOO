/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.LinkedList;

/**
 *
 * @author muruowang
 */
// Interface
interface Deplacable {
    
    // Interface abstract methods cannot have body
    public void deplacer(int dx, int dy, LinkedList<Point2D> positionsOccupees, int dimension);
}
