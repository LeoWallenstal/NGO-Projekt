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
public class PartnerRegister {
    private ArrayList<Partner> allaPartners;
    private InfDB idb;
    
    public PartnerRegister(InfDB idb){
        this.idb = idb;
        allaPartners = new ArrayList<>();
        
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
    
    public int size(){
        return allaPartners.size();
    }
    
    public void hamtaAllaPartners(){
        String sqlFraga = "SELECT pid FROM partner";
        ArrayList<HashMap<String, String>> allaPartnersMap = null;
        
        ArrayList<Partner> allaPartners = new ArrayList<>();

        try{
            allaPartnersMap = idb.fetchRows(sqlFraga);
        } catch (InfException ex) {
            System.out.println(ex.getMessage() 
            + " i PartnerRegister.java, public void hamtaAllaPartners()");
        }
        
        for(HashMap<String, String> enPartner : allaPartnersMap){
            for(String key : enPartner.keySet()){
                String partnerID = enPartner.get(key);
                allaPartners.add(new Partner(partnerID, idb));
            }
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
    
    public boolean harID(String partnerID){
        for(Partner enPartner : allaPartners){
            if(partnerID.equals(enPartner.getPartnerID())){
                return true;
            }
        }
        return false;
    }
}
