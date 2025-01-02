package ngo2024;

import java.util.HashMap;
import java.util.ArrayList;
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
    private Anvandare projektchef;
    private String landID;
    private String land;
    private ArrayList<Partner> partners;
    
    private final InfDB idb;


    //Constructors
    /*initialisera ett projekt med en HashMap från idb.fetchRow()
    alterantivt om man gjort idb.fetchRows() kan man kanske iterera över
    ArrayListen med en ForLoop och sen bara skapa ett 'Projekt'-objekt med
    en HashMap i taget*/
    public Projekt(HashMap<String, String> ettProjekt, InfDB idb){
        this.idb = idb;
        
        for(String key : ettProjekt.keySet()){
            switch(key){
                case "pid":
                    projektID = ettProjekt.get(key);
                    break;
                case "projektnamn":
                    projektnamn = ettProjekt.get(key);
                    break;
                case "beskrivning":
                    beskrivning = ettProjekt.get(key);
                    break;
                case "startdatum":
                    startdatum = ettProjekt.get(key);
                    break;
                case "slutdatum":
                    slutdatum = ettProjekt.get(key);
                    break;
                case "kostnad":
                    kostnad = ettProjekt.get(key);
                    break;
                case "status":
                    status = ettProjekt.get(key);
                    break;
                case "prioritet":
                    prioritet = ettProjekt.get(key);
                    break;
                case "projektchef":{
                        if(ettProjekt.get(key) != null){
                            projektchefID = ettProjekt.get(key);
                        }
                        else{
                            projektchefID = null;
                        }
                        break;
                    }
                case "land":
                {
                    landID = ettProjekt.get(key);
                    land = getLand(landID);
                    break;
                }
                default:
                    break;
            }
        }
        if(projektchefID != null && !projektchefID.isEmpty()){
            projektchef = new Anvandare(idb, Projekt.getAnstalldID(idb, projektchefID));
        }
        else{
            projektchef = null;
        }
        
    }

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
        
        
        if(ettProjekt != null){
            for(String key : ettProjekt.keySet()){
                switch(key){
                    case "pid":
                        this.projektID = projektID;
                        break;
                    case "projektnamn":
                        projektnamn = ettProjekt.get(key);
                        break;
                    case "beskrivning":
                        beskrivning = ettProjekt.get(key);
                        break;
                    case "startdatum":
                        startdatum = ettProjekt.get(key);
                        break;
                    case "slutdatum":
                        slutdatum = ettProjekt.get(key);
                        break;
                    case "kostnad":
                        kostnad = ettProjekt.get(key);
                        break;
                    case "status":
                        status = ettProjekt.get(key);
                        break;
                    case "prioritet":
                        prioritet = ettProjekt.get(key);
                        break;
                    case "projektchef":
                    {
                        if(ettProjekt.get(key) != null){
                            projektchefID = ettProjekt.get(key);
                        }
                        else{
                            projektchef = null;
                        }
                        break;
                    }
                    case "land":
                    {
                        landID = ettProjekt.get(key);
                        land = getLand(landID);
                        break;
                    }
                    default:
                        break;
                }
            }
        }
        else{
            System.out.println("Nånting gick fel, kolla IDT?");
            //Byta detta felmeddelande mot något annat senare
        }
        if(projektchefID != null && !projektchefID.isEmpty()){
            projektchef = new Anvandare(idb, this.getAnstalldID(idb, projektchefID));
        }
        else{
            projektchef = null;
        }
    }
    
    public Projekt(InfDB idb){
        this.idb = idb;
    }

    
    //Getters
    public String getProjektID() {
        return projektID;
    }

    public String getProjektnamn() {
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
        return projektchef;
    }

    public String getProjektchefID(){
        return projektchefID;
    }

    public String getLand() {
        return land;
    }

    public String getLandID(){
        return landID;
    }
    
    public ArrayList<Partner> getPartners(){
        return partners;
    }

    public String toString(){
            String outForsta = "[ProjektID]: " + projektID + "\n[Projektnamn]: " + projektnamn
            + "\n[Beskrivning]: " + beskrivning +  "\n[Startdatum]: " + startdatum
            + "\n[Slutdatum]: " + slutdatum + "\n[Kostnad]: " + kostnad
            + "\n[Status]: " + status + "\n[Prioritet]: " + prioritet;
            if(projektchef != null){
                outForsta += "\n[Projektchef]: " + projektchef  
                    + "\n[ProjektchefID]: " + projektchefID;
            }
            
            String outAndra = "\n[Land]: " + land + "\n[Partners]:" + partners;
            
            return outForsta + outAndra;       
    }

    /*den här returnerar en string array med datan som ska visas i
      data-grid fönstret, visuellt, om man sen stoppar in i .addRow()*/
    public String[] getProjektVyData(){
        String[] data = new String[5];
        data[0] = projektID;
        data[1] = projektnamn;
        if(projektchef.getFullNamn() != null){
            data[2] = projektchef.getFullNamn();
        }
        else{
            data[2] = "";
        }
        data[3] = prioritet;
        data[4] = startdatum;

        return data;
    }

    //Den här hämtar namnet från databasen på landet med hjälp av landID
    private String getLand(String landID){
        String land = "";

        String sqlLand = "SELECT namn FROM land "
            + "JOIN projekt on land = lid "
            + "WHERE land = " + landID;

        try{
            land = idb.fetchSingle(sqlLand);
        } catch (InfException ex) {
            System.out.println(ex.getMessage() + "i Projekt.java, getLand()");
        }
        return land;
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
    
    public void setProjektchefsID(){
        ProjektRegister allaProjekt = new ProjektRegister(idb);
        int nyttID = allaProjekt.getHogstaProjektchefID() + 1;
        String nyttIDStr = Integer.toString(nyttID);
        
        projektchefID = nyttIDStr;
    }
    
    private void setProjektchef(){
        projektchef = new Anvandare(idb, Projekt.getAnstalldID(idb, projektchefID));
    }
    
    public void setProjektchef(String anstallningsID){
        projektchef = new Anvandare(idb, Projekt.getAnstalldID(idb, anstallningsID));
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
            startdatum = datum;
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
    
    public void setLandNamn(){
        String landNamn = "";
        
        try{
            landNamn = idb.fetchSingle("SELECT namn FROM land WHERE lid = " 
                + landID);
        }catch(InfException ex){
            System.out.println(ex.getMessage() + "i Projekt.java, setLand()");
        }
        land = landNamn;
    }
    
    public boolean setPartners(ArrayList<Partner> partners){
        boolean partnersOK = true;
        PartnerRegister allaPartners = new PartnerRegister(idb);
        allaPartners.hamtaAllaPartners();
        
        for(Partner enPartner : partners){
            if(!allaPartners.harID(enPartner.getPartnerID())){
                partnersOK = false;
            }
        }
        if(partnersOK){
            this.partners = partners;
            return true;
        }
        return false;
    }
    
    public void insertProjektDB(){
        try{
            idb.insert("INSERT INTO projekt (pid, projektnamn, beskrivning, "
                    + "startdatum, slutdatum, kostnad, status, prioritet, projektchef, land) " 
                    + "VALUES (" + this.getProjektID() + ", '" + this.getProjektnamn() 
                    + "', '" + this.getBeskrivning() + "', '" + this.getStartdatum() 
                    + "', " + null + ", '" + this.getKostnad() + "', '" + this.getStatus() 
                    + "', '" + this.getPrioritet() + "', " + this.getProjektchefID() 
                    + ", " + this.getLandID() + ");");
            
            for(Partner enPartner : partners){
                idb.insert("INSERT INTO projekt_partner (pid, partner_pid) " 
                     + "VALUES (" + this.getProjektID() + ", " + enPartner.getPartnerID() + ");");
            }
            
        } catch (InfException ex) {
            System.out.println(ex.getMessage() + "i LaggTillProjektFonster.java, insertProjektDB()");
        }
        
    }
    
}

