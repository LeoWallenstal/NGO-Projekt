/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngo2024;
import java.util.HashMap;
import oru.inf.InfDB;
import oru.inf.InfException;


/**
 *
 * @author james
 */
public class Partner {
    //Fields
    private String partnerID;
    private String namn;
    private String kontaktperson;
    private String kontaktepost;
    private String telefonnummer;
    private String adress;
    private String bransch;
    private Stad stad;
    private String stadID;
    
    private InfDB idb;
    
    //Constructors
    
    public Partner(String partnerID, InfDB idb){
        this.idb = idb;
        
        HashMap<String, String> enPartner = null;

        String sqlFraga = "SELECT * FROM partner WHERE pid = " + partnerID;

        try{
            enPartner = idb.fetchRow(sqlFraga);
        } catch (InfException ex) {
            System.out.println(ex.getMessage() + "in Partner.java, public Partner()");
        }
        
        if(enPartner != null){
            for(String key : enPartner.keySet()){
                switch(key){
                    case "pid":
                        this.partnerID = enPartner.get(key);
                        break;
                    case "namn":
                        namn = enPartner.get(key);
                        break;
                    case "kontaktperson":
                        kontaktperson = enPartner.get(key);
                        break;
                    case "kontaktepost":
                        kontaktepost = enPartner.get(key);
                        break;
                    case "telefon":
                        telefonnummer = enPartner.get(key);
                        break;
                    case "adress":
                        adress = enPartner.get(key);
                        break;
                    case "bransch":
                        bransch = enPartner.get(key);
                        break;
                    case "stad":
                        stadID = enPartner.get(key);
                        break;
                    default:
                        break;
                }
            }
            stad = new Stad(stadID, idb);
        }
        else{
            System.out.println("Nånting gick fel, kolla IDT?");
            //Byta detta felmeddelande mot något annat senare
        } 
    }
    
    public Partner(HashMap<String, String> enPartner, InfDB idb){
        this.idb = idb;
        
        for(String key : enPartner.keySet()){
                switch(key){
                    case "pid":
                        partnerID = enPartner.get(key);
                        break;
                    case "namn":
                        namn = enPartner.get(key);
                        break;
                    case "kontaktperson":
                        kontaktperson = enPartner.get(key);
                        break;
                    case "kontaktepost":
                        kontaktepost = enPartner.get(key);
                        break;
                    case "telefon":
                        telefonnummer = enPartner.get(key);
                        break;
                    case "adress":
                        adress = enPartner.get(key);
                        break;
                    case "bransch":
                        bransch = enPartner.get(key);
                        break;
                    case "stad":
                        stadID = enPartner.get(key);
                        break;
                    default:
                        break;
                }
            }
            stad = new Stad(stadID, idb);
    }
    
    public Partner(InfDB idb){
        this.idb = idb;
    }
    
    //Getters
    
    public String getPartnerID(){
        return partnerID;
    }
    
    public String getNamn(){
        return namn;
    }
    
    public String getKontaktperson(){
        return kontaktperson;
    }
    
    public String getKontaktepost(){
        return kontaktepost;
    }
    
    public String getTelefonnummer(){
        return telefonnummer;
    }
    
    public String getAdress(){
        return adress;
    }
    
    public String getBransch(){
        return bransch;
    }
    
    public Stad getStad(){
        return stad;
    }
    
    
    //Setters
    public void setNamn(String namn){
        if(!namn.isEmpty() && Validerare.arBokstaver(namn)){
            this.namn = namn;
        }
    }
    
    public void setKontaktperson(String namn){
        if(!namn.isEmpty() && Validerare.arBokstaver(namn)){
            kontaktperson = namn;
        }
    }
    
    public void setKontaktepost(String epost){
        if(!epost.isEmpty() && Validerare.arEpostAdress(epost)){
            kontaktepost = epost;
        }
    }
    
    public void setTelefonnummer(String telNr){
        if(!telNr.isEmpty() && Validerare.arTelefonnummer(telNr)){
            telefonnummer = telNr;
        }
    }
    
    public void setAdress(String adress){
        if(!adress.isEmpty() && Validerare.arAdress(adress)){
            this.adress = adress;
        }
    }
    
    public void setBransch(String bransch){
        if(!bransch.isEmpty() && Validerare.arBokstaver(bransch)){
            this.bransch = bransch;
        }
    }
    
    public void setPartnerID(){
        PartnerRegister allaPartners = new PartnerRegister(idb);
        int nyttID = allaPartners.getHogstaPartnerID() + 1;
        String nyttIDStr = Integer.toString(nyttID);
        
        partnerID = nyttIDStr;
    }
    
    public void setStad(String stadID){
        if(!stadID.isEmpty()){
            this.stad = new Stad(stadID, idb);
        }
    }
    
    public void setStadID(String stadID){
        if(!stadID.isEmpty()){
            this.stadID = stadID;
        }
    }
    
    public void insertPartnerDB(){
        try{
            idb.insert("INSERT INTO partner (pid, namn, kontaktperson, "
                    + "kontaktepost, telefon, adress, branch, stad) " 
                    + "VALUES (" + this.getPartnerID() + ", '" + this.getNamn() + "', '"
                    + this.getKontaktperson() + "', '" + this.getKontaktepost() + "', '"
                    + this.getTelefonnummer() + "', '" + this.getAdress() + "', '" 
                    + this.getBransch() + "', " + this.getStad().getStadID() +");");
            
        } catch (InfException ex) {
            System.out.println(ex.getMessage() + "i Partner.java, insertPartnerDB()");
        }
        
    }
    
}
