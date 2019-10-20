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
    public static void main( String[] args )
    {
 
 Date date= new Date();
 
 long time = date.getTime();
     System.out.println("Time in Milliseconds: " + time);
 
 Timestamp ts = new Timestamp(time);
 System.out.println("Current Time Stamp: " + ts);
    }
}
