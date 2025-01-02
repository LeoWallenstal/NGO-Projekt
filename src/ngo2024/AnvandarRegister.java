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
    private InfDB idb;
    
    public AnvandarRegister(InfDB idb){
        allaAnvandare = new ArrayList<>();
        this.idb = idb;
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
    
    public Anvandare get(int i){
        return allaAnvandare.get(i);
    }
    
    public ArrayList<Anvandare> getLista(){
        return allaAnvandare;
    }
}
