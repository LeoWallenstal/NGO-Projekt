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
        this.idb = idb;
        allaAvdelningar = new ArrayList<>();
        hamtaAllaAvdelningar();
    }
    
    public void hamtaAllaAvdelningar(){
        this.tomLista();
        ArrayList<String> avdelningLista = new ArrayList<>();
        
        try{
            avdelningLista = idb.fetchColumn("SELECT avdid FROM avdelning");
        } catch (InfException ex) {
            System.out.println(ex.getMessage());
        }
        
        if(avdelningLista != null){
            for(String avdid : avdelningLista){
                allaAvdelningar.add(new Avdelning(avdid, idb));
            }
        }
    }
    
    public void tomLista(){
        allaAvdelningar.clear();
    }
    
    public ArrayList<Avdelning> getLista(){
        return allaAvdelningar;
    }
}
