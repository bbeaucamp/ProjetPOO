/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;
import java.util.Date;
import java.sql.Timestamp;
/**
 *
 * @author muruowang
 */


 
public class GetTimestamp
{
    private String i ;

    public GetTimestamp(String i) {
        this.i = i;
    }
    public static void main( String[] args )
    {
         GetTimestamp i = new GetTimestamp("test");
         System.out.println(i);
}
}
