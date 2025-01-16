/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngo2024;
import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author james
 */
public class PartnerRegister {
    private ArrayList<Partner> allaPartners;
    private InfDB idb;
    
    public PartnerRegister(InfDB idb){
        this.idb = idb;
        allaPartners = new ArrayList<>();
        hamtaAllaPartners();
    }
    
    public ArrayList<Partner> getLista(){
        return allaPartners;
    }
    
    public Partner get(int i){
        if(i >= 0 && i < allaPartners.size()){
            return allaPartners.get(i);
        }
        else{
            return null;
        }
    }
    
    public boolean add(Partner enPartner){
        if(this.contains(enPartner.getPartnerID())){
            return false;
        }
        else{
            allaPartners.add(enPartner);
            return true;
        }
    }
    
    public boolean remove(int i){
        if(i >= 0 && i < allaPartners.size()){
            allaPartners.remove(i);
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean remove(String partnerID){
        Iterator<Partner> it = allaPartners.iterator();
        while(it.hasNext()){
            Partner enPartner = it.next();
            if(enPartner.getPartnerID().equals(partnerID)){
                allaPartners.remove(enPartner);
                return true;
            }
        }
        return false;
    }
    
    public int size(){
        return allaPartners.size();
    }
    
    public boolean contains(String partnerID){
        for(Partner enPartner : allaPartners){
            if(partnerID.equals(enPartner.getPartnerID())){
                return true;
            }
        }
        return false;
    }
    
    public void hamtaAllaPartners(){
        //Se hamtaAllaLand() i LandRegister.java, eller HamtaAllaProjekt i ProjektRegister.java
        //Samma princip.
        String sqlFraga = "SELECT DISTINCT * FROM partner";
        ArrayList<HashMap<String, String>> allaPartnersMap = null;
        
        ArrayList<Partner> allaPartners = new ArrayList<>();

        try{
            allaPartnersMap = idb.fetchRows(sqlFraga);
        } catch (InfException ex) {
            System.out.println(ex.getMessage() 
            + " i PartnerRegister.java, public void hamtaAllaPartners()");
        }
        
        for(HashMap<String, String> enPartner : allaPartnersMap){
            allaPartners.add(new Partner(enPartner, idb));
        }
        this.allaPartners = allaPartners;
    }
    
    public String[] getListData(){
        String[] partnerNamn = new String[allaPartners.size()];
        for(int i = 0; i < allaPartners.size(); i++){
            partnerNamn[i] = allaPartners.get(i).getNamn();
        }
        return partnerNamn;
    }
    
    //Söker efter ett partnerID
    public boolean harID(String partnerID){
        for(Partner enPartner : allaPartners){
            if(partnerID.equals(enPartner.getPartnerID())){
                return true;
            }
        }
        return false;
    }
    
    //Returnerar högsta partnerIDt
    public int getHogstaPartnerID(){
        int hogstaID = Integer.parseInt(allaPartners.getFirst().getPartnerID());
        
        for(Partner enPartner : allaPartners){
            int ettID = Integer.parseInt(enPartner.getPartnerID());
            if(ettID > hogstaID){
                hogstaID = ettID;
            }
        }
        return hogstaID;
    }
    
}
