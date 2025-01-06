/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngo2024;
import java.util.ArrayList;
import java.util.HashMap;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author james
 */
public class LandRegister {
    
    private InfDB idb;
    private ArrayList<Land> allaLand;
    
    public LandRegister(InfDB idb){
        this.idb = idb;
        hamtaAllaLand();
    }
    
    public ArrayList<Land> getLista(){
        return allaLand;
    }
    
    public Land get(int i){
        return allaLand.get(i);
    }
    
    public void hamtaAllaLand(){
        String sqlFraga = "SELECT lid FROM land";
        ArrayList<HashMap<String, String>> allaLandMap = null;
        
        ArrayList<Land> allaLand = new ArrayList<>();

        try{
            allaLandMap = idb.fetchRows(sqlFraga);
        } catch (InfException ex) {
            System.out.println(ex.getMessage() 
                + " i LandRegister.java, public void hamtaAllaLand()");
        }
        
        for(HashMap<String, String> ettLand : allaLandMap){
            for(String key : ettLand.keySet()){
                String landID = ettLand.get(key);
                allaLand.add(new Land(landID, idb));
            }
        }
        this.allaLand = allaLand;
    }
 
    public boolean harID(String landID){
        for(Land ettLand : allaLand){
            if(ettLand.getLandID().equals(landID)){
                return true;
            }
        }
        return false;
    }
    
    public int getHogstaLandID(){
        int hogstaID = Integer.parseInt(allaLand.getFirst().getLandID());
        
        for(Land ettLand : allaLand){
            int ettID = Integer.parseInt(ettLand.getLandID());
            if(ettID > hogstaID){
                hogstaID = ettID;
            }
        }
        return hogstaID;
    }  
}
