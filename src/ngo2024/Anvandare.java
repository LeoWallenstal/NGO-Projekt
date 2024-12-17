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
    //Användarens uppgifter, kanske värt att göra till en Array?
    //Dessa kommer skickas med från anrop
    private String ePost;
    private String losenord;
    //Dessa kommer hämtas från databasen
    private String fornamn;
    private String efternamn;
    private String adress;
    private String telNr;
    private String avdelningsId;
    private String anstallningsId;
    private String anstallningsDatum;
    
    public Anvandare(InfDB idb, String ePost, String losenord) {
        this.idb = idb;
        this.ePost = ePost;
        this.losenord = losenord;
        setUppgifter();
        System.out.println(fornamn+" "+efternamn+" "+adress+" "+telNr+" "+avdelningsId+" "+anstallningsId+" "+anstallningsDatum);
    }

    //Getters
    public String getEPost(){
        return ePost;
    }
    
    public String getLosenord(){
        return losenord;
    }
    
    public String getFornamn() {
        return fornamn;
    }

    public String getEfternamn() {
        return efternamn;
    }

    public String getFullNamn() {
        return fornamn + " " + efternamn;
    }
    
    public String getAdress(){
        return adress;
    }
    
    public String getTelNr(){
        return telNr;
    }
    
    public String getAvdelningsId(){
        return avdelningsId;
    }
    
    public String getAnstallningsId(){
        return anstallningsId;
    }
    
    public String getAnstallningsDatum(){
        return anstallningsDatum;
    }

    //Setters
    private void setUppgifter() {
        HashMap<String, String> uppgifter;
        try {
            String sqlFraga = "SELECT fornamn, efternamn, adress, telefon, avdelning, aid, anstallningsdatum "
                    + "FROM anstalld where epost = '" + ePost + "'";
            uppgifter = idb.fetchRow(sqlFraga);
            for (String kolumn : uppgifter.keySet()) {
                String varde = uppgifter.get(kolumn);
                switch (kolumn) {
                    case "fornamn":
                        fornamn = varde;
                        break;
                    
                    case "efternamn":
                        efternamn = varde;
                        break;
                        
                    case "adress":
                        adress = varde;
                        break;
                    
                    case "telefon":
                        telNr = varde;
                        break;
                        
                    case "avdelning":
                        avdelningsId = varde;
                        break;
                        
                    case "aid":
                        anstallningsId = varde;
                        break;
                    
                    case "anstallningsdatum":
                        anstallningsDatum = varde;
                        break;
                }
            }
        } catch (InfException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
}
