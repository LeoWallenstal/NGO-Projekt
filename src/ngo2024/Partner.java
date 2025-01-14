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
        
        this.idb = idb;
        this.partnerID = enPartner.get("pid");
        this.namn = enPartner.get("namn");
        this.kontaktperson = enPartner.get("kontaktperson");
        this.kontaktepost = enPartner.get("kontaktepost");
        this.telefonnummer = enPartner.get("telefon");
        this.adress = enPartner.get("adress");
        this.bransch = enPartner.get("branch");
        this.stadID = enPartner.get("stad");
    }
    
    public Partner(HashMap<String, String> enPartner, InfDB idb){
        this.idb = idb;
        this.partnerID = enPartner.get("pid");
        this.namn = enPartner.get("namn");
        this.kontaktperson = enPartner.get("kontaktperson");
        this.kontaktepost = enPartner.get("kontaktepost");
        this.telefonnummer = enPartner.get("telefon");
        this.adress = enPartner.get("adress");
        this.bransch = enPartner.get("branch");
        this.stadID = enPartner.get("stad");
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
        return new Stad(stadID, idb);
    }
    
    public boolean equals(Partner annan){
        return this.partnerID.equals(annan.partnerID);
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
    
    public void setStadID(String stadID){
        if(!stadID.isEmpty()){
            this.stadID = stadID;
        }
    }
    
    public void uppdateraPartnerDB(){
        try{
            String sqlFraga = "UPDATE partner " +
                "SET kontaktperson = '" + this.getKontaktperson() + "', kontaktepost = '" +
                this.getKontaktepost() + "', telefon = '" + this.getTelefonnummer() + "', adress = '" + this.getAdress() +
                "', branch = '" + this.getBransch() + "', stad = " + this.getStad().getStadID() + 
                " WHERE pid = " + this.getPartnerID();
            
            idb.update(sqlFraga);
        }
        catch (InfException ex) {
            System.out.println(ex.getMessage() + "i LaggTillProjektFonster.java, insertProjektDB()");
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
    
    public void deletePartnerDB(){
        try{
            idb.delete("DELETE FROM projekt_partner WHERE partner_pid = " + this.getPartnerID());
            idb.delete("DELETE FROM partner WHERE pid = " + this.getPartnerID()); 
        } catch (InfException ex) {
            System.out.println(ex.getMessage() + "i LaggTillProjektFonster.java, insertProjektDB()");
        }
    }
    
}
