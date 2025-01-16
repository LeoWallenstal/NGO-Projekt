/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngo2024;
import java.util.HashMap;
import oru.inf.InfDB;
import oru.inf.InfException;
/**
 *
 * @author james
 */


public class Stad {
    private String stadID;
    private String namn;
    private String landID;
    private InfDB idb;
    
    /*Konstruktor som gör ett 'Stad'-objekt efter ett specifikt 
    stadID. Se Anvandare.java, Land.java, Projekt.java, Avdelning.java,
    och Partner.java. Samma princip.*/
    public Stad(String stadID, InfDB idb){
        this.idb = idb;
        HashMap<String, String> enStad = null;
        
        try{
            enStad = idb.fetchRow("SELECT * FROM stad "
            + " WHERE sid = " + stadID);
        }catch (InfException ex) {
            System.out.println(ex.getMessage() + "i Stad.java, Stad()");
        }
        this.stadID = enStad.get("sid");
        this.namn = enStad.get("namn");
        this.landID = enStad.get("land");
    }
    
     public Stad(HashMap<String, String> enStad, InfDB idb){
        this.idb = idb;

        this.stadID = enStad.get("sid");
        this.namn = enStad.get("namn");
        this.landID = enStad.get("land");
    }
    
    public boolean equals(Stad annan){
        return this.stadID.equals(annan.stadID);
    }
    
    public String getStadID(){
        return stadID;
    }
    
    public String getLandID(){
        return landID;
    }
    
    /*Returnerar ett anonymt 'Land'-objekt med det sparade IDt från
    det här objketets fält 'landID'.*/
    public Land getLand(){
        return new Land(landID, idb);
    }
    
    public String getNamn(){
        return namn;
    }
}
