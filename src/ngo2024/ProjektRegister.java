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
public class ProjektRegister {
    private ArrayList<Projekt> allaProjekt;
    private InfDB idb;
    
    public ProjektRegister(InfDB idb){
        allaProjekt = new ArrayList<>();
        this.idb = idb;
        hamtaAllaProjekt();
    }
    
    public void hamtaAllaProjekt(){
        this.tomLista();
        
        ArrayList<Projekt> allaProjekt = new ArrayList<>();
        ArrayList<HashMap<String, String>> projektMap = new ArrayList<>();
        
        try{
            projektMap = idb.fetchRows("SELECT pid FROM projekt");
        } catch (InfException ex) {
            System.out.println(ex.getMessage());
        }
        
        if(projektMap != null){
            for(HashMap<String, String> ettProjekt : projektMap){
                String projektID = ettProjekt.get("pid");
                allaProjekt.add(new Projekt(projektID, idb));
            }
            if(!allaProjekt.isEmpty()){
                this.allaProjekt = allaProjekt;
            }
        }
    }
    
    public void hamtaAvdelningensProjekt(String avdelningsID){
        
        ArrayList<HashMap<String, String>> avdelningensProjekt = new ArrayList<>();
        try {
            //Hämtar bara ut projektIDt här
            String sqlFraga = 
                  "SELECT DISTINCT projekt.pid "
                + "FROM projekt "
                + "JOIN ans_proj ON projekt.pid = ans_proj.pid "
                + "JOIN anstalld ON ans_proj.aid = anstalld.aid "
                + "JOIN avdelning on anstalld.avdelning = avdelning.avdid "
                + "WHERE avdelning.avdid = " + avdelningsID;
            
            avdelningensProjekt = idb.fetchRows(sqlFraga);
            
        }catch (InfException ex) {
            System.out.println(ex.getMessage());
        }
        
        ArrayList<Projekt> avdelningensProj = new ArrayList<>();
        for(HashMap<String, String> ettProjekt : avdelningensProjekt){
            //Här skapar jag ett Projekt-objekt med det hämtade ProjektIDt från förut
            avdelningensProj.add(new Projekt(ettProjekt.get("pid"), idb));
        }
        
        allaProjekt = avdelningensProj;
    }
    
    public void hamtaMinaProjekt(String anstallningsID){
       
        ArrayList<HashMap<String, String>> minaProjekt = new ArrayList<>();
        try {
            //Hämtar bara ut projektIDt här
            String sqlFraga = 
                  "SELECT DISTINCT projekt.pid from projekt "
                + "JOIN ans_proj on projekt.pid = ans_proj.pid "
                + "JOIN anstalld on ans_proj.aid = anstalld.aid "
                + "WHERE ans_proj.aid = " + anstallningsID + " "
                + "OR projektchef = " + anstallningsID;
            
            minaProjekt = idb.fetchRows(sqlFraga);     
        } catch (InfException ex) {
            System.out.println(ex.getMessage());
        }
         
        ArrayList<Projekt> minaProj = new ArrayList<>();
        for(HashMap<String, String> ettProjekt : minaProjekt){
            //Här skapar jag ett Projekt-objekt med det hämtade ProjektIDt från förut
            minaProj.add(new Projekt(ettProjekt.get("pid"), idb));
        }
        
        this.tomLista();
        allaProjekt = minaProj;
    }
    
    public void getListaStatus(Projektstatus status){
        
        ArrayList<Projekt> listaStatus = new ArrayList<>();
        if(status.equals("Alla")){
            return;
        }
        
        for(Projekt ettProjekt : allaProjekt){
            if(ettProjekt.getStatus().equals(status.toString())){
                listaStatus.add(ettProjekt);
            }
        }
        allaProjekt = listaStatus;
    }
    
    public void getSoktLista(SokKategori kategori, String sokStr){
        
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
                if(ettProjekt.getProjektnamn().startsWith(sokStr)){
                    resultat.add(ettProjekt);
                }
            }
        }
        allaProjekt = resultat;
    }
    
    public Projekt getProjekt(String pid){
        for(Projekt ettProjekt : allaProjekt){
            if(pid.equals(ettProjekt.getProjektID())){
                return ettProjekt;
            }
        }
        return null;
    }
    
    public ArrayList<Projekt> getLista(){
        return allaProjekt;
    }
    
    public int getHogstaProjektchefID(){
        int hogstaID = Integer.parseInt(allaProjekt.getFirst().getProjektchefID());
        
        for(Projekt ettProjekt : allaProjekt){
            int ettID = Integer.parseInt(ettProjekt.getProjektchefID());
            if(ettID > hogstaID){
                hogstaID = ettID;
            }
        }
        return hogstaID;
    }
    
    public int getHogstaProjektID(){
        int hogstaID = Integer.parseInt(allaProjekt.getFirst().getProjektID());
        
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
