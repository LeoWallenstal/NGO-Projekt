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
public class Land {
    private String landID;
    private String namn;
    private String sprak;
    private String valuta;
    private String tidszon;
    private String politiskStruktur;
    private String ekonomi;
    private InfDB idb;
    
    public Land(String landID, InfDB idb){
        this.idb = idb;
        HashMap<String, String> ettLand = null;

        String sqlFraga = "SELECT * FROM land WHERE lid = " + landID;

        try{
            ettLand = idb.fetchRow(sqlFraga);
        } catch (InfException ex) {
            System.out.println(ex.getMessage() + "i Land.java, Land()");
        }
        
        if(ettLand != null){
            for(String key : ettLand.keySet()){
                switch(key){
                    case "lid":
                        this.landID = ettLand.get("lid");
                        break;
                    case "namn":
                        namn = ettLand.get("namn");
                        break;
                    case "sprak":
                        namn = ettLand.get("sprak");
                        break;
                    case "valuta":
                        valuta = ettLand.get("valuta");
                        break;
                    case "politisk_struktur":
                        politiskStruktur = ettLand.get("politisk_struktur");
                        break;
                    case "ekonomi":
                        ekonomi = ettLand.get("ekonomi");
                        break;
                    default:
                        break;
                }
            }
        }
        else{
            System.out.println("Nånting gick fel, kolla IDT?");
            //Byta detta felmeddelande mot något annat senare
        } 
    }
    
    public Land(HashMap<String, String> ettLand, InfDB idb){
        this.idb = idb;
        
        for(String key : ettLand.keySet()){
                switch(key){
                    case "lid":
                        landID = ettLand.get("lid");
                        break;
                    case "namn":
                        namn = ettLand.get("namn");
                        break;
                    case "sprak":
                        namn = ettLand.get("sprak");
                        break;
                    case "valuta":
                        valuta = ettLand.get("valuta");
                        break;
                    case "politisk_struktur":
                        politiskStruktur = ettLand.get("politisk_struktur");
                        break;
                    case "ekonomi":
                        ekonomi = ettLand.get("ekonomi");
                        break;
                    default:
                        break;
                }
            }
    }
    
    public String getLandID(){
        return landID;
    }
    
    public String getNamn(){
        return namn;
    }
    
    public String getSprak(){
        return sprak;
    }
    
    public String getValuta(){
        return valuta;
    }
    
    public String getPolitiskStruktur(){
        return politiskStruktur;
    }
    
    public String getEkonomi(){
        return ekonomi;
    }
}
