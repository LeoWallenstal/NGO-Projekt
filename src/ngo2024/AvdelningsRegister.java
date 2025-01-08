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
public class AvdelningsRegister {
    private HashMap<String, Avdelning> avdelningMap;
    private InfDB idb;
    
    
    public AvdelningsRegister(InfDB idb){
        this.idb = idb;
        avdelningMap = new HashMap<>();
        hamtaAllaAvdelningar();
    }
    
    public void hamtaAllaAvdelningar(){
        this.tomLista();
        ArrayList<HashMap<String, String>> avdelningLista = new ArrayList<>();
        
        
        try{
            avdelningLista = idb.fetchRows("SELECT * FROM avdelning");
            if(avdelningLista != null){
            for(HashMap<String,String> enAvdelning : avdelningLista){
                Avdelning avdelning = new Avdelning(enAvdelning, idb);
                avdelningMap.put(avdelning.getAvdelningsID(), avdelning);
            }
        }
        } catch (InfException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public Avdelning getAvdelningFranId(String avdid){
        return avdelningMap.get(avdid);
    }
    
    public void tomLista(){
        avdelningMap.clear();
    }
    
    public ArrayList<Avdelning> getLista(){
        return new ArrayList<>(avdelningMap.values());
    }
}
