/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngo2024;

import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.HashMap;

/**
 *
 * @author walle
 */
public class Anvandare {

    private final InfDB idb;
    private HashMap<String,String> uppgifter;
    
    public Anvandare(InfDB idb, String aid) {
        this.idb = idb;
        uppgifter = new HashMap<>();
        setUppgifter(aid);
    }

    //Getters 
    public String getFornamn() {
        return uppgifter.get("fornamn");
    }

    public String getEfternamn() {
        return uppgifter.get("efternamn");
    }

    public String getFullNamn() {
        return uppgifter.get("fornamn") + " " + uppgifter.get("efternamn");
    }
    
    public String getAdress(){
        return uppgifter.get("adress");
    }
    
    public String getTelNr(){
        return uppgifter.get("telefon");
    }
    
    public String getAvdelningsId(){
        return uppgifter.get("avdelning");
    }
    
    public String getAnstallningsId(){
        return uppgifter.get("aid");
    }
    
    public String getAnstallningsDatum(){
        return uppgifter.get("anstallningsdatum");
    }
    
    public String getEPost(){
        return uppgifter.get("epost");
    }
    
    public String getLosenord(){
        return uppgifter.get("losenord");
    }
    

    //Setters
    private void setUppgifter(String aid) {
        try {
            String sqlFraga = "SELECT fornamn, efternamn, adress, telefon, avdelning, anstallningsdatum, epost, losenord, aid "
                    + "FROM anstalld where aid = '" + aid+"'";
            uppgifter = idb.fetchRow(sqlFraga);
        } catch (InfException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
}
