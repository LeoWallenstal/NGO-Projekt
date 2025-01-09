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
public class StadRegister {
    
    private ArrayList<Stad> allaStader;
    private InfDB idb;
    
    public StadRegister(InfDB idb){
        this.idb = idb;
        allaStader = new ArrayList<>();
        hamtaAllaStader();
    }
    
    public ArrayList<Stad> getLista(){
        return allaStader;
    }
    
    public Stad get(int i){
        if(i >= 0 && i < allaStader.size()){
            return allaStader.get(i);
        }
        else{
            return null;
        }
    }
    
    public int size(){
        return allaStader.size();
    }
    
    public void hamtaAllaStader(){
        String sqlFraga = "SELECT * FROM stad";
        ArrayList<HashMap<String, String>> allaStaderMap = null;
        
        ArrayList<Stad> allaStader = new ArrayList<>();

        try{
            allaStaderMap = idb.fetchRows(sqlFraga);
        } catch (InfException ex) {
            System.out.println(ex.getMessage() 
            + " i PartnerRegister.java, public void hamtaAllaPartners()");
        }
        
        for(HashMap<String, String> enStad : allaStaderMap){
            for(String key : enStad.keySet()){
                String stadID = enStad.get(key);
                allaStader.add(new Stad(enStad, idb));
            }
        }
        this.allaStader = allaStader;
    }
    
    
}
