/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngo2024;

import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.HashMap;
import java.util.ArrayList;

/**
 *
 * @author walle
 */
public class Anvandare {

    private final InfDB idb;
    private HashMap<String,String> uppgifter;
    
    private boolean admin = false;
    private boolean handlaggare = false;
    
    public Anvandare(InfDB idb, String aid) {
        this.idb = idb;
        uppgifter = new HashMap<>();
        setUppgifter(aid);
        setBehorighet(aid);
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
    
    public boolean isAdmin(){
        return admin;
    }
    
    public boolean isHandlaggare(){
        return handlaggare;
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
    
    private void setBehorighet(String aid){
        
        String sqlFragaAdmin = "SELECT aid FROM admin";
        String sqlFragaHandlaggare = "SELECT aid FROM handlaggare";
        try{
            ArrayList<String> adminAid = idb.fetchColumn(sqlFragaAdmin);
            ArrayList<String> handlaggareAid = idb.fetchColumn(sqlFragaHandlaggare);
            
            for(String dbAid : adminAid){
                if(aid.equals(dbAid)){
                    admin = true;
                    break;
                }
            }
            for(String dbAid : handlaggareAid){
                if(aid.equals(dbAid)){
                    handlaggare = true;
                    break;
                }
            }
        }
        catch(InfException ex){
            System.out.println(ex.getMessage());
        }
    }
}
