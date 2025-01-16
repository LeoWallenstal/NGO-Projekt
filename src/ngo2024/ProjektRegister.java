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
            projektMap = idb.fetchRows("SELECT * FROM projekt");
        } catch (InfException ex) {
            System.out.println(ex.getMessage());
        }
        
            for(HashMap<String, String> ettProjekt : projektMap){
                allaProjekt.add(new Projekt(ettProjekt, idb));
            }
        this.allaProjekt = allaProjekt;
    }
    
    public ArrayList<Projekt> hamtaAllaProjekt(){
        
        ArrayList<Projekt> allaProjekt = new ArrayList<>();
        ArrayList<HashMap<String, String>> projektMap = new ArrayList<>();
        
        try{
            projektMap = idb.fetchRows("SELECT * FROM projekt");
        } catch (InfException ex) {
            System.out.println(ex.getMessage());
        }
        
        for(HashMap<String, String> ettProjekt : projektMap){
            allaProjekt.add(new Projekt(ettProjekt, idb));
        }
        return allaProjekt;
    }
    
    public ArrayList<Projekt> getAllaProjekt(){
        return allaProjekt;
    }
    
    /*Returnerar en lista med projekt från den avdelningen som den inloggade
    användaren tillhör.*/
    public ArrayList<Projekt> getAvdelningensProjekt(String avdelningsID){
        
        ArrayList<Projekt> resultat = new ArrayList<>();
        for(Projekt ettProjekt : allaProjekt){
            if(ettProjekt.getProjektchef().getAvdelningsID().equals(avdelningsID)){
                resultat.add(ettProjekt);
            }
        }
        return resultat;
    }
    
    /*Returnerar en lista med projekt där den inloggade användaren antingen
    är med som handläggare, eller är projektchef.*/
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
    
    //Returnerar true om ett projektID finns i listan allaProjekt
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
    
    public Projekt get(int i){
        if(i >= 0 && i < allaProjekt.size()){
            return allaProjekt.get(i);
        }
        return null;
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
    
    /*Returnerar en lista där användaren har valt en viss status att filtrera efter.*/
    public ArrayList<Projekt> getListaStatus(Projektstatus status, ArrayList <Projekt> attFiltrera){
        Iterator<Projekt> it = attFiltrera.iterator();
        while(it.hasNext()){
            Projekt ettProjekt = it.next();
            if(!ettProjekt.getStatus().equals(status.toString())){
                it.remove();
            }
        }

        return attFiltrera;
    }
    
    /*Returnerar en lista som är filtrerad efter ett söksträng som användaren stoppar in.
    Vid inmatning så specifierar användaren även om de söker efter projektchef eller projektnamn*/
    public ArrayList<Projekt> getSoktLista(SokKategori kategori, String sokStr, ArrayList<Projekt> attFiltrera){
        
        if(kategori == SokKategori.PROJEKTCHEF){
            Iterator<Projekt> it = attFiltrera.iterator();
            while(it.hasNext()){
                Projekt ettProjekt = it.next();
                if(!ettProjekt.getProjektchef().getFornamn().toLowerCase().startsWith(sokStr.toLowerCase())){
                    it.remove();
                }
            }
        }
        else if(kategori == SokKategori.PROJEKTNAMN){
            Iterator<Projekt> it = attFiltrera.iterator();
            while(it.hasNext()){
                Projekt ettProjekt = it.next();
                if(!ettProjekt.getNamn().toLowerCase().contains(sokStr.toLowerCase())){
                    it.remove();
                }
            }
        }
        return attFiltrera;
    }
    
    //Returnerar en lista som är filtrerad på start- och slutdatum
    public ArrayList<Projekt> getListaDatumSpann(String startdatum, String slutdatum,
            ArrayList<Projekt> attFiltrera)
    {
        Iterator<Projekt> it = attFiltrera.iterator();
        
        while(it.hasNext()){
            Projekt ettProjekt = it.next();
            if(ettProjekt.arFore(slutdatum) && ettProjekt.arEfter(startdatum)){
                it.remove();
            }
        }
        return attFiltrera;
    }
    
    //Returnerar en lista som är filtrerad på startdatum
    public ArrayList<Projekt> getListaStartdatum(String startdatum, ArrayList<Projekt> attFiltrera){
        Iterator<Projekt> it = attFiltrera.iterator();
        
        while(it.hasNext()){
            Projekt ettProjekt = it.next();
            if(ettProjekt.arFore(startdatum)){
                it.remove();
            }
        }
        return attFiltrera;
    }
    
    //Returnerar en lista som är filtrerad på slutdatum
    public ArrayList<Projekt> getListaSlutdatum(String slutdatum, ArrayList<Projekt> attFiltrera){
        Iterator<Projekt> it = attFiltrera.iterator();
        
        while(it.hasNext()){
            Projekt ettProjekt = it.next();
            if(ettProjekt.arEfter(slutdatum)){
                it.remove();
            }
        }
        return attFiltrera;
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
