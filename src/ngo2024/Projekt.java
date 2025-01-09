package ngo2024;

import java.util.HashMap;
import java.util.ArrayList;
import java.time.LocalDate;
import oru.inf.InfDB;
import oru.inf.InfException;

public class Projekt {
    private String projektID;
    private String projektnamn;
    private String beskrivning;
    private String startdatum;
    private String slutdatum;
    private String kostnad;
    private String status;
    private String prioritet;
    private String projektchefID;
    private String landID;
    private ArrayList<String> partners;
    
    //OKLART OM DETTA ÄR RÄTT TERMINOLOGI?? ASSÅ DE SOM JOBBAR PÅ PROJEKTET
    //ÄNDRA ANNARS OCKSÅ hamtaHandlaggare() KRING RAD 434
    private ArrayList<String> handlaggare;
    
    private final InfDB idb;

    //En konstruktor som gör ett 'projekt'-objekt från ett pid
    public Projekt(String projektID, InfDB idb){
        this.idb = idb;
        HashMap<String, String> ettProjekt = null;

        String sqlFraga = "SELECT * FROM projekt WHERE pid = " + projektID;

        try{
            ettProjekt = idb.fetchRow(sqlFraga);
        } catch (InfException ex) {
            System.out.println(ex.getMessage());
        }     
        this.projektID = ettProjekt.get("pid");
        this.projektnamn = ettProjekt.get("projektnamn");
        this.beskrivning = ettProjekt.get("beskrivning");
        this.startdatum = ettProjekt.get("startdatum");
        this.slutdatum = ettProjekt.get("slutdatum");
        this.kostnad = ettProjekt.get("kostnad");
        this.status = ettProjekt.get("status");
        this.prioritet = ettProjekt.get("prioritet");
        this.projektchefID = ettProjekt.get("projektchef");
        this.landID = ettProjekt.get("land");
        
        hamtaPartners();
        hamtaHandlaggare();
    }
    
    public Projekt(InfDB idb){
        this.idb = idb;
        this.partners = new ArrayList<>();
        this.handlaggare = new ArrayList<>();
    }

    
    //Getters
    public String getProjektID() {
        return projektID;
    }

    public String getNamn() {
        return projektnamn;
    }

    public String getBeskrivning() {
        return beskrivning;
    }

    public String getStartdatum() {
        return startdatum;
    }

    public String getSlutdatum() {
        return slutdatum;
    }

    public String getKostnad() {
        return kostnad;
    }

    public String getStatus() {
        return status;
    }

    public String getPrioritet() {
        return prioritet;
    }

    public Anvandare getProjektchef() {
        return new Anvandare(idb, projektchefID);
    }

    public String getProjektchefID(){
        return projektchefID;
    }

    public Land getLand() {
        return new Land(landID, idb);
    }

    public String getLandID(){
        return landID;
    }
    
    public ArrayList<String> getPartnersID(){
        return partners;
    }
    
    public ArrayList<Partner> getPartners(){
        ArrayList<Partner> projektetsPartners = new ArrayList<>();
        for(String ettID : partners){
            projektetsPartners.add(new Partner(ettID, idb));
        }
        return projektetsPartners;
    }

    public ArrayList<Anvandare> getHandlaggare(){
        ArrayList<Anvandare> projektetsHandlaggare = new ArrayList<>();
        for(String ettID : handlaggare){
            projektetsHandlaggare.add(new Anvandare(idb, ettID));
        }
        
        return projektetsHandlaggare;
    }
    
    public ArrayList<String> getHandlaggareID(){
        return handlaggare;
    }
    
    public Partner getPartner(String partnerID){
        for(String ettPartnerID : partners){
            if(partnerID.equals(ettPartnerID)){
                return new Partner(ettPartnerID, idb);
            }
        }
        System.out.println("getPartner() misslyckades, ID fanns inte!");
        return null;
    }
    
    public boolean removePartner(String partnerID){
        for(String ettPartnerID : partners){
            if(partnerID.equals(ettPartnerID)){
                partners.remove(ettPartnerID);
                return true;
            }
        }
        System.out.println("removePartner() misslyckades, IDt fanns inte!");
        return false;
    }
    
    public boolean harPartner(String partnerID){
        for(String ettID : partners){
            if(partnerID.equals(ettID)){
                return true;
            }
        }
        return false;
    }
    
    public boolean equals(Projekt annat){
        return this.projektID.equals(annat.projektID);
    }
    
    //Jämför this.partners mot en annan partnerlista
    public boolean partnersEquals(ArrayList<Partner> annanPartnerLista){
        //Är de inte samma storlek kan det inte vara samma lista
        if(partners.size() != annanPartnerLista.size()){
            return false;
        }
        //Kollar om en partner från den andra listan finns i this.partners
        for(Partner enPartner : annanPartnerLista){
            if(!this.harPartner(enPartner.getPartnerID())){
                return false;
            }
        }
        return true;
    }
    
    public boolean handlaggareEquals(ArrayList<Anvandare> annanHandlaggareLista){
        //Är de inte samma storlek kan det inte vara samma lista
        if(handlaggare.size() != annanHandlaggareLista.size()){
            return false;
        }
        //Kollar om en partner från den andra listan finns i this.partners
        for(Anvandare enHandlaggare : annanHandlaggareLista){
            if(!this.harHandlaggare(enHandlaggare.getAnstallningsID())){
                return false;
            }
        }
        return true;
    }

    
    public boolean taBortPartner(int i){
        if(i >= 0 && i < partners.size()){
            partners.remove(i);
            return true;
        }
        return false;
    }
    
    //Se kommentar kring rad 24-25 ang. namn
    public Anvandare getHandlaggare(int i){
        if(i >= 0 && i < handlaggare.size()){
            return new Anvandare(idb, handlaggare.get(i));
        }
        else{
            return null;
        }
    }
    
    public boolean harHandlaggare(String anstallningsID){
        for(String ettAnstallningsID : handlaggare){
            if(anstallningsID.equals(ettAnstallningsID)){
                return true;
            }
        }
        return false;
    }
    
    public boolean taBortHandlaggare(int i){
        if(i >= 0 && i < handlaggare.size()){
            handlaggare.remove(i);
            return true;
        }
        return false;
    }
    
    public String toString(){
            String outForsta = "[ProjektID]: " + projektID + "\n[Projektnamn]: " + projektnamn
            + "\n[Beskrivning]: " + beskrivning +  "\n[Startdatum]: " + startdatum
            + "\n[Slutdatum]: " + slutdatum + "\n[Kostnad]: " + kostnad
            + "\n[Status]: " + status + "\n[Prioritet]: " + prioritet;
            if(projektchefID != null){
                outForsta += "\n[Projektchef]: " + getProjektchef().getFullNamn()
                    + "\n[ProjektchefID]: " + projektchefID;
            }
            
            String outAndra = "\n[Land]: " + getLand().getNamn() + "\n[Partners]:" + partners;
            
            return outForsta + outAndra;       
    }
    
    //Hämtar ett anstallningsID från ett projektchefID
    public static String getAnstalldID(InfDB idb, String projektchefID){
        String aID = "";
        
        try{
            aID = idb.fetchSingle("SELECT anstalld.aid FROM anstalld "
                        + "JOIN projekt ON projekt.projektchef = anstalld.aid "  
                        + "where projekt.projektchef = " + projektchefID);
        }catch(InfException ex){
            System.out.println(ex.getMessage() + "i Projekt.java, getAnstalldID()");
        }
        if(aID == null){
            return "";
        }
        else{
            return aID;
        }
    }
    
    public boolean setProjektnamn(String projektnamn){
        if(projektnamn.isEmpty()){
            return false;
        }
        else{
            this.projektnamn = projektnamn;
            return true;
        }
    }
    
    public void setProjektID(){
        ProjektRegister allaProjekt = new ProjektRegister(idb);
        int nyttID = allaProjekt.getHogstaProjektID() + 1;
        String nyttIDStr = Integer.toString(nyttID);
        
        projektID = nyttIDStr;
    }
    
    public void setProjektchefsID(String anstallningsID){
        projektchefID = anstallningsID;
    }
    
    public boolean setBeskrivning(String beskrivning){
        if(beskrivning.isEmpty()){
           return false; 
        }
        else{
            this.beskrivning = beskrivning;
            return true;
        }
    }
    
    public boolean setStartdatum(String datum){
        if(!datum.isEmpty() && Validerare.arDatum(datum)){
            startdatum = datum;
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean setSlutdatum(String datum){
         if(!datum.isEmpty() && Validerare.arDatum(datum)){
            slutdatum = datum;
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean setKostnad(String kostnad){
        if(!kostnad.isEmpty() && Validerare.formatProjektKostnadOK(kostnad)){
            this.kostnad = kostnad;
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean setStatus(String status){
        switch(status){
            case "Planerat":
            case "Pågående":
            case "Avslutat":
                this.status = status;
                return true;
            default:
                return false;
        }
    }
    
    public boolean setPrioritet(String prioritet){
        switch(prioritet){
            case "Hög":
            case "Medel":
            case "Låg":
                this.prioritet = prioritet;
                return true;
            default:
                return false;
        }
    }
    
    public boolean setLandID(String lid){
        LandRegister landregister = new LandRegister(idb);
        landregister.hamtaAllaLand();
        
        if(Validerare.arSiffror(lid) && landregister.harID(lid)){
            this.landID = lid;
            return true;
        }
        else{
            return false;
        }
    }
    
    public void setPartners(ArrayList<Partner> annanPartnerLista){
        if(partners != null){
            partners.clear();
        }
        for(Partner enPartner : annanPartnerLista){
            partners.add(enPartner.getPartnerID());
        }
    }
   
    public void setHandlaggare(ArrayList<Anvandare> annanHandlaggareLista){
        if(handlaggare != null){
            handlaggare.clear();
        }
        for(Anvandare enHandlaggare : annanHandlaggareLista){
            handlaggare.add(enHandlaggare.getAnstallningsID());
        }
    }
    
    public void hamtaPartners(){
        ArrayList<HashMap<String, String>> partnerMap = new ArrayList<>();
        ArrayList<String> hamtadePartners = new ArrayList<>();
        
        try{
            partnerMap = idb.fetchRows("SELECT partner.pid FROM partner "
                + "JOIN projekt_partner ON projekt_partner.partner_pid = partner.pid "
                + "JOIN projekt ON projekt.pid = projekt_partner.pid "
                + "WHERE projekt.pid = " + projektID );
        }catch(InfException ex){
            System.out.println(ex.getMessage() + "i Projekt.java, hamtaPartners()");
        }
        
        for(HashMap<String, String> enPartner : partnerMap){
            for(String key : enPartner.keySet()){
                String partnerID = enPartner.get(key);
                hamtadePartners.add(enPartner.get(key));
            }
        }
        partners = hamtadePartners;
    }

    private void hamtaHandlaggare(){
        ArrayList<String> handlaggare = new ArrayList<>();
        ArrayList<HashMap<String, String>> handlaggareMap = new ArrayList<>();
        
        try{
            handlaggareMap = idb.fetchRows("SELECT anstalld.aid FROM anstalld " +
                "JOIN ans_proj ON anstalld.aid = ans_proj.aid " +
                "JOIN projekt ON ans_proj.pid = projekt.pid " +
                "WHERE projekt.pid = " + projektID);
        }catch(InfException ex){
            System.out.println(ex.getMessage() + "i Projekt.java, hamtahandlaggare()");
        }
        
        for(HashMap<String, String> enHandlaggare : handlaggareMap){
            for(String key : enHandlaggare.keySet()){
                handlaggare.add(enHandlaggare.get(key));
            }
        }
        this.handlaggare = handlaggare;
    }
    
    public boolean arFore(String datum){
        LocalDate startdatum1 = LocalDate.parse(this.getStartdatum());
        LocalDate startdatum2 = LocalDate.parse(datum);
        
        return startdatum1.isBefore(startdatum2);
    }
    
    public boolean arSamma(String datum){
        LocalDate startdatum1 = LocalDate.parse(this.getStartdatum());
        LocalDate startdatum2 = LocalDate.parse(datum);
        
        return startdatum1.isEqual(startdatum2);
    }
    
    public boolean arEfter(String datum){
        LocalDate startdatum1 = LocalDate.parse(this.getStartdatum());
        LocalDate startdatum2 = LocalDate.parse(datum);
        
        return startdatum1.isAfter(startdatum2);
    }
    
    
    public void insertProjektDB(){
        String sqlFraga;
        
        try{
            sqlFraga = "INSERT INTO projekt (pid, projektnamn, beskrivning, "
                + "startdatum, slutdatum, kostnad, status, prioritet, projektchef, land) " 
                + "VALUES (" + this.getProjektID() + ", '" + this.getNamn() 
                + "', '" + this.getBeskrivning() + "', '" + this.getStartdatum() 
                + "', " + null + ", '" + this.getKostnad() + "', '" + this.getStatus() 
                + "', '" + this.getPrioritet() + "', " + this.getProjektchefID() 
                + ", " + this.getLandID() + ");";
            
            idb.insert(sqlFraga);
            
            if(!handlaggare.isEmpty()){
                for(String ettHandlaggareID : handlaggare){
                    sqlFraga = "INSERT INTO ans_proj (pid, aid) "
                        + "VALUES (" + this.projektID + ", " + ettHandlaggareID + ");";
                    idb.insert(sqlFraga);
                }
            }
            if(!partners.isEmpty()){
                for(String ettPartnerID  : partners){
                    sqlFraga = "INSERT INTO projekt_partner (pid, partner_pid) "
                            + "VALUES (" + this.projektID + ", " + ettPartnerID + ");";
                    idb.insert(sqlFraga);
                }
            }
                
            
            
        } catch (InfException ex) {
            System.out.println(ex.getMessage() + "i LaggTillProjektFonster.java, insertProjektDB()");
        }
        
    }
    
    public void updateProjektDB(){
        String sqlFraga;
        
        if(this.slutdatum == null || this.slutdatum.isEmpty()){
            sqlFraga = "UPDATE projekt SET "
            + "projektnamn = '" + this.projektnamn + "', "
            + "beskrivning = '" + this.beskrivning + "', " 
            + "startdatum = '" + this.startdatum + "', "
            + "slutdatum = NULL, "
            + "kostnad = '" + this.kostnad + "', "    
            + "status = '" + this.status + "', "
            + "prioritet = '" + this.prioritet + "', "
            + "projektchef = " + this.projektchefID + " "
            + "WHERE pid = " + this.getProjektID();
        }
        else{
            sqlFraga = "UPDATE projekt SET "
            + "projektnamn = '" + this.projektnamn + "', "
            + "beskrivning = '" + this.beskrivning + "', " 
            + "startdatum = '" + this.startdatum + "', "
            + "slutdatum = '" + this.slutdatum + "', "
            + "kostnad = '" + this.kostnad + "', "    
            + "status = '" + this.status + "', "
            + "prioritet = '" + this.prioritet + "', "
            + "projektchef = " + this.projektchefID + " "
            + "WHERE pid = " + this.getProjektID();
        }
        
            
        try{
            idb.update(sqlFraga);
            if(!handlaggare.isEmpty()){
                sqlFraga = "DELETE from ans_proj WHERE pid = " + this.getProjektID();
                idb.delete(sqlFraga);
                for(String ettHandlaggareID : handlaggare){
                    sqlFraga = "INSERT INTO ans_proj (pid, aid) "
                        + "VALUES (" + this.projektID + ", " + ettHandlaggareID + ");";
                    idb.insert(sqlFraga);
                }
            }
            if(!partners.isEmpty()){
                sqlFraga = "DELETE from projekt_partner WHERE pid = " + this.getProjektID();
                idb.delete(sqlFraga);
                for(String ettPartnerID  : partners){
                    sqlFraga = "INSERT INTO projekt_partner (pid, partner_pid) "
                            + "VALUES (" + this.projektID + ", " + ettPartnerID + ");";
                    idb.insert(sqlFraga);
                }
            }
            
        } catch (InfException ex) {
            System.out.println(ex.getMessage());
        }     
    }
    
    public void deleteProjektDB(){
        try{
            idb.delete("DELETE FROM ans_proj WHERE pid = " + this.getProjektID());
            idb.delete("DELETE FROM proj_hallbarhet WHERE pid = " + this.getProjektID());
            idb.delete("DELETE FROM projekt_partner WHERE pid = " + this.getProjektID()); 
            idb.delete("DELETE FROM projekt WHERE pid = " + this.getProjektID());
        } catch (InfException ex) {
            System.out.println(ex.getMessage() + "i LaggTillProjektFonster.java, insertProjektDB()");
        }
    }
    
}

