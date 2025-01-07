/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngo2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author james
 */
public class ProjektRegister {
    private ArrayList<Projekt> allaProjekt;
    private InfDB idb;
    
    public ProjektRegister(InfDB idb){
        this.idb = idb;
        allaProjekt = hamtaAllaProjekt();
    }
    
    public void refreshaAllaProjekt(){
        ArrayList<Projekt> allaProjekt = new ArrayList<>();
        ArrayList<HashMap<String, String>> projektMap = new ArrayList<>();
        
        try{
            projektMap = idb.fetchRows("SELECT pid FROM projekt");
        } catch (InfException ex) {
            System.out.println(ex.getMessage());
        }
        
            for(HashMap<String, String> ettProjekt : projektMap){
                allaProjekt.add(new Projekt(ettProjekt.get("pid"), idb));
            }
        this.allaProjekt = allaProjekt;
    }
    
    public ArrayList<Projekt> hamtaAllaProjekt(){
        
        ArrayList<Projekt> allaProjekt = new ArrayList<>();
        ArrayList<HashMap<String, String>> projektMap = new ArrayList<>();
        
        try{
            projektMap = idb.fetchRows("SELECT pid FROM projekt");
        } catch (InfException ex) {
            System.out.println(ex.getMessage());
        }
        
            for(HashMap<String, String> ettProjekt : projektMap){
                allaProjekt.add(new Projekt(ettProjekt.get("pid"), idb));
            }
        return allaProjekt;
    }
    
    public ArrayList<Projekt> getAllaProjekt(){
        return allaProjekt;
    }
    
    public ArrayList<Projekt> getAvdelningensProjekt(String avdelningsID){
        
        ArrayList<Projekt> resultat = new ArrayList<>();
        for(Projekt ettProjekt : allaProjekt){
            if(ettProjekt.getProjektchef().getAvdelningsID().equals(avdelningsID)){
                resultat.add(ettProjekt);
            }
        }
        return resultat;
    }
    
    public ArrayList<Projekt> getMinaProjekt(String anstallningsID){
       
        ArrayList<Projekt> resultat = new ArrayList<>();
        for(Projekt ettProjekt : allaProjekt){
            if(ettProjekt.getProjektchefID().equals(anstallningsID) ||
                ettProjekt.harHandlaggare(anstallningsID))
            {
                resultat.add(ettProjekt);
            }
        }
        return resultat;
    }
    
    public boolean contains(String projektID){
        for(Projekt ettProjekt : allaProjekt){
            if(ettProjekt.getProjektID().equals(projektID)){
                return true;
            }
        }
        return false;
    }
    
    public boolean add(Projekt ettProjekt){
        if(!this.contains(ettProjekt.getProjektID())){
            allaProjekt.add(ettProjekt);
            return true;
        }
        else{
            System.out.println(ettProjekt.getNamn() + " finns redan!");
            return false;
        }
    }
    
    public boolean remove(String projektID){
        Iterator<Projekt> it = allaProjekt.iterator();
        while(it.hasNext()){
            Projekt ettProjekt = it.next();
            if(ettProjekt.getProjektID().equals(projektID)){
                allaProjekt.remove(ettProjekt);
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Projekt> getListaStatus(Projektstatus status){
        
        ArrayList<Projekt> listaStatus = new ArrayList<>();
        if(status.equals("Alla")){
            //return getAllaProjekt();
        }
        
        for(Projekt ettProjekt : allaProjekt){
            if(ettProjekt.getStatus().equals(status.toString())){
                listaStatus.add(ettProjekt);
            }
        }
        return listaStatus;
    }
    
    public ArrayList<Projekt> getSoktLista(SokKategori kategori, String sokStr){
        
        ArrayList<Projekt> resultat = new ArrayList<>();
        if(kategori == SokKategori.PROJEKTCHEF){
            for(Projekt ettProjekt : allaProjekt){
                if(ettProjekt.getProjektchef().getFullNamn().startsWith(sokStr)){
                    resultat.add(ettProjekt);
                }
            }
        }
        else if(kategori == SokKategori.PROJEKTNAMN){
            for(Projekt ettProjekt : allaProjekt){
                if(ettProjekt.getNamn().startsWith(sokStr)){
                    resultat.add(ettProjekt);
                }
            }
        }
        return resultat;
    }
    
    public ArrayList<Projekt> getListaDatumSpann(String startdatum, String slutdatum){
        ArrayList<Projekt> resultat = new ArrayList<>();
        for(Projekt ettProjekt : allaProjekt){
            if((ettProjekt.arEfter(startdatum) || ettProjekt.arSamma(startdatum))
                && (ettProjekt.arFore(slutdatum) || ettProjekt.arSamma(slutdatum))){
                resultat.add(ettProjekt);
            }
        }
        return resultat;
    }
    
    public ArrayList<Projekt> getListaStartdatum(String startdatum){
        ArrayList<Projekt> resultat = new ArrayList<>();
        for(Projekt ettProjekt : allaProjekt){
            if(ettProjekt.arSamma(startdatum) || ettProjekt.arEfter(startdatum)){
                resultat.add(ettProjekt);
            }
        }
        return resultat;
    }
    
    public ArrayList<Projekt> getListaSlutdatum(String slutdatum){
        ArrayList<Projekt> resultat = new ArrayList<>();
        for(Projekt ettProjekt : allaProjekt){
            if(ettProjekt.arSamma(slutdatum) || ettProjekt.arFore(slutdatum)){
                resultat.add(ettProjekt);
            }
        }
        return resultat;
    }
    
    
    public Projekt getProjekt(String projektID){
        for(Projekt ettProjekt : allaProjekt){
            if(projektID.equals(ettProjekt.getProjektID())){
                return ettProjekt;
            }
        }
        return null;
    }
    
    public ArrayList<Projekt> getLista(){
        return allaProjekt;
    }
    
    public int getHogstaProjektchefID(){
        int hogstaID = 0;
        
        for(Projekt ettProjekt : allaProjekt){
            int ettID = Integer.parseInt(ettProjekt.getProjektchefID());
            if(ettID > hogstaID){
                hogstaID = ettID;
            }
        }
        return hogstaID;
    }
    
    public int getHogstaProjektID(){
        int hogstaID = 0;
        
        for(Projekt ettProjekt : allaProjekt){
            int ettID = Integer.parseInt(ettProjekt.getProjektID());
            if(ettID > hogstaID){
                hogstaID = ettID;
            }
        }
        return hogstaID;
    }
    
    public void tomLista(){
        allaProjekt.clear();
    }
    
}
