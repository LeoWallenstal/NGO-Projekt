/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngo2024;

import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.HashMap;
import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author walle
 */
public class Anvandare {

    private final InfDB idb;
    private HashMap<String,String> uppgifter;
    
    private boolean admin = false;
    private boolean handlaggare = false;
    
    private String fornamn;
    private String efternamn;
    private String adress;
    private String telefon;
    private String avdelningsId;
    private String anstallningsdatum;
    private String epost;
    private String losenord;
    private String aid;
    
    private Avdelning avdelning;
    
    public Anvandare(HashMap<String,String> enAnvandare, InfDB idb){
        /*En konstruktor som tar en HashMap som parameter, samt ett objekt
        av datatypen InfDB. Sedan initialiseras objektet med HashMapens
        .get() funktion, där man anger tabellens namn som nyckel.*/
        
        this.idb = idb;
        fornamn = enAnvandare.get("fornamn");
        efternamn = enAnvandare.get("efternamn");
        adress = enAnvandare.get("adress");
        telefon = enAnvandare.get("telefon");
        avdelningsId = enAnvandare.get("avdelning");
        anstallningsdatum = enAnvandare.get("anstallningsdatum");
        epost = enAnvandare.get("epost");
        losenord = enAnvandare.get("losenord");
        aid = enAnvandare.get("aid");
    }
    
    public Anvandare(InfDB idb, String aid) {
        /*En konstruktor som skapar ett 'Anvandare'-objekt utifrån
        ett givet anställningsID, och initialiserar fälten i setUppgifter()
        resp. setBehorighet()*/
        this.idb = idb;
        uppgifter = new HashMap<>();
        setUppgifter(aid);
        setBehorighet(aid);
    }
    
    public Anvandare(InfDB idb, HashMap<String,String> uppgifter, boolean admin, boolean handlaggare) {
        //Se första konstruktorn
 
        this.idb = idb;
        this.uppgifter = uppgifter;
        this.admin = admin;
        this.handlaggare = handlaggare;
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
    
    public String getAvdelningsID(){
        return uppgifter.get("avdelning");
    }
    
    public String getAvdelningsNamn(){
        String namn = "";
        try{
            String sqlFraga = "SELECT namn FROM avdelning " 
                + "WHERE avdid = " + getAvdelningsID();
            namn = idb.fetchSingle(sqlFraga);
        }
        catch (InfException ex) {
            System.out.println(ex.getMessage());
        } 
        return namn;
    }
    
    
    public String getAnstallningsID(){
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
    
    public boolean isProjektchef(Projekt ettProjekt){
        return ettProjekt.getProjektchefID().equals(this.getAnstallningsID());
    }

    //Setters
    private void setUppgifter(String aid) {
        try {
            String sqlFraga = "SELECT fornamn, efternamn, adress, telefon, avdelning, anstallningsdatum, epost, losenord, aid "
                    + "FROM anstalld WHERE aid = '" + aid + "'";
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
            
            if(handlaggareAid.contains(aid)){
                handlaggare = true;
                return;
            }
            if(adminAid.contains(aid)){
                admin = true;
                return;
            }
            
        }
        catch(InfException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public boolean isProjektChef(){
        ProjektRegister allaProjekt = new ProjektRegister(idb);
        for(Projekt ettProjekt: allaProjekt.getLista()){
            if(this.getAnstallningsID().equals(ettProjekt.getProjektchefID())){
                return true;
            }
        }
        return false;
    }
    
    public void laggTillAnvandareDb(int aid, String fornamn, String efternamn, String adress, String epost, String telefonNr, Date anstallningsdatum, String losenord, int avdelning){
         try{
             String sqlFraga = "INSERT INTO anstalld (aid, fornamn, efternamn, adress, epost, telefon, anstallningsdatum, losenord, avdelning) "
                + "VALUES (" + aid + ", '" + fornamn + "', '" + efternamn + "', '" + adress + "', '" +
                epost + "', '" + telefonNr + "', '" + anstallningsdatum + "', '" + losenord + "', " + avdelning + ")";
            idb.insert(sqlFraga);
            }
            catch (InfException ex) {
            System.out.println(ex.getMessage() + "i Anvandare.java, laggTillAnvandareDb()");
            }
    }
    
    public void laggTillHandlaggareMedMentorDb(int aid, String beskrivningAnsvar, String mentor){
        try{
            String sqlFraga = "INSERT INTO handlaggare (aid, ansvarighetsomrade, mentor)" +
                    "VALUES (" + aid + ", '" + beskrivningAnsvar + "', " + mentor + ")"; 
            idb.insert(sqlFraga);}
        catch(InfException ex) {
            System.out.println(ex.getMessage() + "i Anvandare.java, laggTillHandlaggareMedMentorDb()");
            }
    }
    
    public void laggTillHandlaggareUtanMentorDb(int aid, String beskrivningAnsvar){
        try {
            String sqlFraga = "INSERT INTO handlaggare (aid, ansvarighetsomrade, mentor) " +
                    "VALUES (" + aid + ", '" + beskrivningAnsvar + "', NULL)";
            idb.insert(sqlFraga);}
        catch(InfException ex) {
            System.out.println(ex.getMessage() + "i Anvandare.java, laggTillHandlaggareUtanMentorDb()");
            }
    }
    
    public void laggTillAdminDb(int aid){
        try{
            String sqlFraga = "INSERT INTO admin (aid, behörighetsniva) " +
            "VALUES (" + aid +", " + 1 + ")";
            idb.insert(sqlFraga);
        } catch (InfException ex) {
            System.out.println(ex.getMessage() + "i Anvandare.java, laggTillAdminDb()");
            }
    }
    
    public void bytRoll(){
        
        try{
            if(admin){
                
                idb.delete("DELETE FROM admin WHERE aid = " + getAnstallningsID());
                
                idb.insert("INSERT INTO handlaggare " +
                        "VALUES ( " + getAnstallningsID() + ", null, null)");
                
                
                setBehorighet(getAnstallningsID());
                }
            
            else if(handlaggare){
            
                idb.update("UPDATE projekt SET projektchef = NULL WHERE projektchef = " + this.getAnstallningsID());
                idb.update("UPDATE handlaggare SET mentor = NULL WHERE mentor = " + this.getAnstallningsID());
                idb.delete("DELETE FROM handlaggare WHERE aid = " + getAnstallningsID());
                
                idb.insert("INSERT INTO admin " +
                        "VALUES ( " + getAnstallningsID() + ", '1')");
                
                setBehorighet(getAnstallningsID());
            }
        }
            
        catch (InfException ex) {
            System.out.println(ex.getMessage() + "i Anvandare.java, deleteAnvandareDb()");
            }
        }
    
    public void deleteAnvandareDb(){
        try{
            idb.update("UPDATE projekt SET projektchef = NULL WHERE projektchef = " + this.getAnstallningsID());
            idb.update("UPDATE handlaggare SET mentor = NULL WHERE mentor = " + this.getAnstallningsID());
            idb.update("UPDATE avdelning SET chef = NULL WHERE chef = " + this.getAnstallningsID());
            idb.delete("DELETE FROM ans_proj WHERE aid = " + this.getAnstallningsID());
            idb.delete("DELETE FROM handlaggare WHERE aid = " + this.getAnstallningsID());
            idb.delete("DELETE FROM admin WHERE aid = " + this.getAnstallningsID()); 
            idb.delete("DELETE FROM anstalld WHERE aid = " + this.getAnstallningsID());
            } 
            catch (InfException ex) {
                System.out.println(ex.getMessage() + "i Anvandare.java, deleteAnvandareDb()");
            }
        }
}



