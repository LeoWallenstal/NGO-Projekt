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
    private Land land;
    private InfDB idb;
    
    public Stad(String stadID, InfDB idb){
        this.idb = idb;
        HashMap<String, String> enStad = new HashMap<>();
        
        try{
            enStad = idb.fetchRow("SELECT * FROM stad "
            + " WHERE sid = " + stadID);
        }catch (InfException ex) {
            System.out.println(ex.getMessage() + "i Stad.java, Stad()");
        }
        
        for(String key : enStad.keySet()){
            switch(key){
                case "sid":
                    this.stadID = enStad.get(key);
                    break;
                case "namn":
                    this.namn = enStad.get(key);
                    break;
                case "land":
                    landID = enStad.get(key);
                    break;
            }
        }
        land = new Land(landID, idb);
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
    
    public Land getLand(){
        return land;
    }
    
    public String getNamn(){
        return namn;
    }
}
