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
public class AnvandarRegister {
    private ArrayList<Anvandare> allaAnvandare;
    private ArrayList<Anvandare> samtligaAnstallda;
    private ArrayList<String> handlaggare;
    private ArrayList<String> administrator;
    private InfDB idb;
    
    public AnvandarRegister(InfDB idb){
        allaAnvandare = new ArrayList<>();
        samtligaAnstallda = new ArrayList<>();
        handlaggare = new ArrayList<>();
        administrator = new ArrayList<>();
        this.idb = idb;
        
        hamtaSamtligaAnstallda();
    }
    
    public void hamtaAvdelningensAnvandare(String avdelningsID){
        ArrayList<HashMap<String, String>> avdelningensProjekt = new ArrayList<>();
        try {
            //Hämtar bara ut projektIDt här
            String sqlFraga = 
                   "SELECT anstalld.aid "
                +  "FROM anstalld "
                +  "JOIN avdelning ON avdelning.avdid = anstalld.avdelning " 
                +  "WHERE avdelning.avdid = " + avdelningsID;
            
            avdelningensProjekt = idb.fetchRows(sqlFraga);
            
        }catch (InfException ex) {
            System.out.println(ex.getMessage());
        }
        
        ArrayList<Anvandare> avdelningensAnvandare = new ArrayList<>();
        for(HashMap<String, String> enAnvandare : avdelningensProjekt){
            //Här skapar jag ett Projekt-objekt med det hämtade ProjektIDt från förut
            avdelningensAnvandare.add(new Anvandare(idb, enAnvandare.get("aid")));
        }
        
        allaAnvandare = avdelningensAnvandare;
    }
    
    public void hamtaSamtligaAnstallda(){
        ArrayList<HashMap<String, String>> anstallda = new ArrayList<>();
        
        try {
            
            String sqlFraga = "SELECT aid FROM anstalld ORDER BY aid ASC";
            
            anstallda = idb.fetchRows(sqlFraga);
         }
        catch(InfException ex) {
            System.out.println(ex.getMessage());
        }
        ArrayList<Anvandare> allaAnstallda = new ArrayList<>();
        
        for(HashMap<String, String> enAnstalld : anstallda) {
            allaAnstallda.add(new Anvandare(idb, enAnstalld.get("aid")));
        }
        
        samtligaAnstallda = allaAnstallda;
    }
    
    public Anvandare get(int i){
        return allaAnvandare.get(i);
    }
    
    public ArrayList<Anvandare> getLista(){
        return allaAnvandare;
    }
    
    public ArrayList<Anvandare> getAllaAnstallda(){
        return samtligaAnstallda;
    }
    
    public void hamtaHandlaggare(){
        ArrayList<HashMap<String, String>> allaHandlaggare = new ArrayList<>();
        try {
            String sqlFraga = "SELECT aid FROM handlaggare";
            allaHandlaggare = idb.fetchRows(sqlFraga);
            }
        catch(InfException ex) {
            System.out.println(ex.getMessage());
        }
        ArrayList<String> handlaggare = new ArrayList<>();
        for(HashMap<String, String> enHandlaggare : allaHandlaggare){
            handlaggare.add(enHandlaggare.get("aid)"));
        }
        this.handlaggare = handlaggare;
    }
    
    public void hamtaAdmins(){
        ArrayList<HashMap<String, String>> allaAdmins = new ArrayList<>();
        try {
            String sqlFraga = "SELECT aid FROM handlaggare";
            allaAdmins = idb.fetchRows(sqlFraga);
            }
        catch(InfException ex) {
            System.out.println(ex.getMessage());
        }
        ArrayList<String> admins = new ArrayList<>();
        for(HashMap<String, String> enAdmin : allaAdmins){
            handlaggare.add(enAdmin.get("aid)"));
        }
        this.administrator = admins;
    }
    
    public ArrayList<String> getHandlaggare(){
        return handlaggare;
    }
    
    public ArrayList<String> getAmin(){
        return administrator;
    }
    
    public int getMaxAID(){
        int maxAid = 0;
        try{
            //hämtar anställd med högst anst.ID
            String sqlFraga = "SELECT MAX(aid) FROM anstalld";
            
            ArrayList<String> maxAidList = idb.fetchColumn(sqlFraga);
            
            maxAid = Integer.parseInt(maxAidList.get(0));
        }
        catch(InfException ex) {
            System.out.println(ex.getMessage());
        }
        return maxAid;
    }
}
