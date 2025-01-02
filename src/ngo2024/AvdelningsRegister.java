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
    private ArrayList<Avdelning> allaAvdelningar;
    private InfDB idb;
    
    
    public AvdelningsRegister(InfDB idb){
        
    }
    
    public void hamtaAllaAvdelningar(){
        this.tomLista();
        
        ArrayList<Avdelning> allaAvdelningar = new ArrayList<>();
        ArrayList<HashMap<String, String>> avdelningMap = new ArrayList<>();
        
        try{
            avdelningMap = idb.fetchRows("SELECT avdid FROM avdelning");
        } catch (InfException ex) {
            System.out.println(ex.getMessage());
        }
        
        if(avdelningMap != null){
            for(HashMap<String, String> enAvdelning : avdelningMap){
                String avdelningsID = enAvdelning.get("avdid");
                allaAvdelningar.add(new Avdelning(avdelningsID, idb));
            }
            if(!allaAvdelningar.isEmpty()){
                this.allaAvdelningar = allaAvdelningar;
            }
        }
    }
    
    public void tomLista(){
        allaAvdelningar.clear();
    }
}
