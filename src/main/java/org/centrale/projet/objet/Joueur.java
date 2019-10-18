/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.StringTokenizer;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
/**
 *
 * @author muruowang
 */
public class Joueur {
    
    private Personnage perso;

    public Joueur(Personnage perso) {
        this.perso = perso;
    }  

    public Joueur() {
    }

    public Personnage getPerso() {
        return perso;
    }

    public void setPerso(Personnage perso) {
        this.perso = perso;
    }
    
    public static Joueur fromString(String params) throws ClassNotFoundException, NoSuchMethodException, 
            IllegalAccessException, InvocationTargetException {
        StringTokenizer tokenizer = new StringTokenizer(params, " ");
        tokenizer.nextToken(); // On passe le nom de la classe

        Class classePerso = Class.forName(tokenizer.nextToken());
        Method fromString = classePerso.getMethod("fromString", String.class);
        return new Joueur((Personnage) fromString.invoke(null, (Object) tokenizer.nextToken("")));
    }
    
}
