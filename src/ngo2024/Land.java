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
                        sprak = ettLand.get("sprak");
                        break;
                    case "valuta":
                        valuta = ettLand.get("valuta");
                        break;
                    case "tidszon":
                        tidszon = ettLand.get("tidszon");
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
                        sprak = ettLand.get("sprak");
                        break;
                    case "valuta":
                        valuta = ettLand.get("valuta");
                        break;
                    case "tidszon":
                        tidszon = ettLand.get("tidszon");
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
    
    public Land(InfDB idb){
        this.idb = idb;
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
    
    public String getTidszon(){
        return tidszon;
    }
    
    public void setNamn(String namn){
        if(!namn.isEmpty()){
            this.namn = namn;
        }
    }
    
    public void setSprak(String sprak){
        if(!sprak.isEmpty()){
            this.sprak = sprak;
        }
    }
        
    public void setValuta(String valuta){
        if(!valuta.isEmpty()){
            this.valuta = valuta;
        }
    }
        
    public void setTidszon(String tidszon){
        if(!tidszon.isEmpty()){
            this.tidszon = tidszon;
        }
    }
    
    public void setPolitiskStruktur(String politiskStruktur){
        if(!politiskStruktur.isEmpty()){
            this.politiskStruktur = politiskStruktur;
        }
    }
    
    public void setEkonomi(String ekonomi){
        if(!ekonomi.isEmpty()){
            this.ekonomi = ekonomi;
        }
    }
    
    public void setLandID(){
        LandRegister allaLand = new LandRegister(idb);
        int nyttID = allaLand.getHogstaLandID() + 1;
        String nyttIDStr = Integer.toString(nyttID);
        
        landID = nyttIDStr;
    }
    
    public void insertLandDB(){
        try{
            idb.insert("INSERT INTO land (lid, namn, sprak, "
                    + "valuta, tidszon, politisk_struktur, ekonomi) " 
                    + "VALUES (" + this.getLandID() + ", '" + this.getNamn() + "', '"
                    + this.getSprak() + "', '" + this.getValuta() + "', '"
                    + this.getTidszon() + "', '" + this.getPolitiskStruktur() + "', '" 
                    + this.getEkonomi() +"');");
            
        } catch (InfException ex) {
            System.out.println(ex.getMessage() + "i Land.java, insertLandDB()");
        }
    }
    
    public void updateLandDB(){
        try{
            String sqlFraga = ("UPDATE land SET namn = '" + this.getNamn() + "', sprak = '"
                    + this.getSprak() + "', valuta = " + this.getValuta()
                    + ", tidszon = '" + this.getTidszon() + "', politisk_struktur = '"
                    + this.getPolitiskStruktur() + "', ekonomi = '" + this.getEkonomi()
                    + "' WHERE lid = " + this.getLandID() + ";");
            idb.update(sqlFraga);
        }
        catch(InfException ex){
            System.out.println(ex.getMessage() + "i Land.java, updateLandDB()");
        }
    }
}
