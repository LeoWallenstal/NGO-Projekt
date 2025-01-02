/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngo2024;

import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author james
 */
public class Avdelning {
    private String avdelningsID;
    private String namn;
    private String beskrivning;
    private String adress;
    private String epost;
    private String telefonnummer;
    private Stad stad;
    private String stadID;
    private Anvandare chef;
    private String chefID;
    private ArrayList<Anvandare> anstallda;
    
    private InfDB idb;
    
    public Avdelning(HashMap<String, String> enAvdelning, InfDB idb){
        this.idb = idb;
        this.anstallda = hamtaAnstallda();
        
        for(String key : enAvdelning.keySet()){
            switch(key){
                case "avdid":
                    avdelningsID = enAvdelning.get(key);
                    break;
                case "namn":
                    this.namn = enAvdelning.get(key);
                    break;
                case "beskrivning":
                    this.beskrivning = enAvdelning.get(key);
                    break;
                case "adress":
                    this.adress = enAvdelning.get(key);
                    break;
                case "epost":
                    this.epost = enAvdelning.get(key);
                    break;
                case "telefon":
                    telefonnummer = enAvdelning.get(key);
                    break;
                case "stad":
                {
                    stadID = enAvdelning.get(key);
                    stad = new Stad(stadID, idb);
                    break;
                }
                case "chef":
                {
                    if(chefID != null){
                        chefID = enAvdelning.get(key);
                        chef = new Anvandare(idb, this.getAnstalldID());
                    }
                    else{
                        chef = null;
                    }
                    break;
                }     
            }
        }
        
    }
    
    public Avdelning(String avdelningsID, InfDB idb){
        this.idb = idb;
        this.anstallda = new ArrayList<>();
        
        HashMap<String, String> enAvdelning = new HashMap<>();
        
        try{
            enAvdelning = idb.fetchRow("SELECT * FROM avdelning "
            + " WHERE avdid = " + avdelningsID);
        }catch (InfException ex) {
            System.out.println(ex.getMessage() + "i Avdelning.java, Avdelning()");
        }
        
        for(String key : enAvdelning.keySet()){
            switch(key){
                case "avdid":
                    this.avdelningsID = enAvdelning.get(key);
                    break;
                case "namn":
                    this.namn = enAvdelning.get(key);
                    break;
                case "beskrivning":
                    this.beskrivning = enAvdelning.get(key);
                    break;
                case "adress":
                    this.adress = enAvdelning.get(key);
                    break;
                case "epost":
                    this.epost = enAvdelning.get(key);
                    break;
                case "telefon":
                    telefonnummer = enAvdelning.get(key);
                    break;
                case "stad":
                {
                    this.stadID = enAvdelning.get(key);
                    this.stad = new Stad(stadID, idb);
                    break;
                }
                case "chef":
                {
                    String chefID = enAvdelning.get(key);
                    if(chefID != null){
                        this.chefID = chefID;
                        this.chef = new Anvandare(idb, this.getAnstalldID());
                    }
                    else{
                        chef = null;
                    }
                    break;
                }
            }
        }
        anstallda = hamtaAnstallda();
    }
    
    public String toString(){
        return "[AvdelningsID]: " + avdelningsID + "\n[Avdelningens namn]: " + namn +
                "\n[Beskrivning]: " + beskrivning + "\n[Adress]: " + adress +
                "\n[Epost]: " + epost + "\n[Telefonnummer]: " + telefonnummer +
                "\n[StadID]: " + stadID +  "\n[Stad]: " + stad.getNamn() +
                "\n[ChefID]: " + chefID + "\n[Chef]: " + chef.getFullNamn(); 
    }
    
    public String getAvdelningsID(){
        return avdelningsID;
    }
    
    public String getNamn(){
        return namn;
    }
    
    public String getBeskrivning(){
        return beskrivning;
    }
    
    public String getAdress(){
        return adress;
    }
    
    public String getEpost(){
        return epost;
    }
    
    public String getTelefonnummer(){
        return telefonnummer;
    }
    
    public Stad getStad(){
        return stad;
    }
    
    public String getStadID(){
        return stadID;
    }
    
    public Anvandare getChef(){
        return chef;
    }
    
    private String getAnstalldID(){
        String anstallningsID = "";
        
        try{
            String sqlFraga = "SELECT anstalld.aid " 
                            + "FROM anstalld "
                            + "JOIN avdelning ON avdelning.chef = anstalld.aid "
                            + "WHERE avdelning.avdId = " + avdelningsID;
            
            anstallningsID = idb.fetchSingle(sqlFraga);
        }catch (InfException ex) {
            System.out.println(ex.getMessage() + "i Avdelning.java, getAnstallningsID()");
        }
        
        return anstallningsID;
    }
    
    public ArrayList<Anvandare> getAvdelningensAnstallda(){
        return anstallda;
    }
    
    private ArrayList<Anvandare> hamtaAnstallda(){
        ArrayList<Anvandare> avdelningensAnstallda = new ArrayList<>();
        ArrayList<HashMap<String, String>>avdelningensAnstalldaMap = new ArrayList<>();
    
        try{
            String sqlFraga = "SELECT anstalld.aid "
                            + "FROM anstalld "
                            + "WHERE anstalld.avdelning = " + avdelningsID;
            
            avdelningensAnstalldaMap = idb.fetchRows(sqlFraga);
        }catch (InfException ex) {
            System.out.println(ex.getMessage() + "i Avdelning.java, getAnstallningsID()");
        }
        
        for(HashMap<String, String> enAnstalld : avdelningensAnstalldaMap){
            String anstalldID = enAnstalld.get("aid");
            avdelningensAnstallda.add(new Anvandare(idb, anstalldID));
        }
        return avdelningensAnstallda;
    }
}
