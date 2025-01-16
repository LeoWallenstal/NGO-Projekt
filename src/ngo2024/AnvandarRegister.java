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
public class AnvandarRegister {
    private ArrayList<Anvandare> allaAnvandare;
    private ArrayList<Anvandare> samtligaAnstallda;
    private ArrayList<String> handlaggare;
    private ArrayList<String> administrator;
    private InfDB idb;
    
    public AnvandarRegister(InfDB idb){
        allaAnvandare = new ArrayList<>();
        samtligaAnstallda = new ArrayList<>();
        handlaggare = new ArrayList<>();
        administrator = new ArrayList<>();
        this.idb = idb;
        
    }
    
    public void hamtaAvdelningensAnvandare(String avdelningsID){
        ArrayList<Anvandare> avdelningensAnstallda = new ArrayList<>();
        ArrayList<HashMap<String, String>> avdelningensAnstalldaMap = new ArrayList<>();

        ArrayList<String> adminAid = new ArrayList<>();
        ArrayList<String> handlaggareAid = new ArrayList<>();

        try {
            String sqlFragaAdmin = "SELECT aid FROM admin";
            String sqlFragaHandlaggare = "SELECT aid FROM handlaggare";

            adminAid = idb.fetchColumn(sqlFragaAdmin);
            handlaggareAid = idb.fetchColumn(sqlFragaHandlaggare);

        } catch (InfException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            String sqlFraga = "SELECT * "
                    + "FROM anstalld "
                    + "WHERE avdelning = " + avdelningsID;

            avdelningensAnstalldaMap = idb.fetchRows(sqlFraga);
        } catch (InfException ex) {
            System.out.println(ex.getMessage() + "i Avdelning.java, getAnstallningsID()");
        }

        for (HashMap<String, String> enAnstalld : avdelningensAnstalldaMap) {
            String aid = enAnstalld.get("aid");
            boolean admin = false;
            boolean handlaggare = false;
            if (adminAid.contains(aid)) {
                admin = true;
            }
            if (handlaggareAid.contains(aid)) {
                handlaggare = true;
            }
            avdelningensAnstallda.add(new Anvandare(idb, enAnstalld, admin, handlaggare));
        }
        allaAnvandare = avdelningensAnstallda;
    }
    
    public void hamtaSamtligaAnstallda(){
        ArrayList<Anvandare> allaAnstallda = new ArrayList<>();
        ArrayList<HashMap<String, String>> allaAnstalldaMap = new ArrayList<>();

        ArrayList<String> adminAid = new ArrayList<>();
        ArrayList<String> handlaggareAid = new ArrayList<>();

        try {
            String sqlFragaAdmin = "SELECT aid FROM admin";
            String sqlFragaHandlaggare = "SELECT aid FROM handlaggare";

            /*Två hashmaps där anställningsIDn för de anställda som är admin,
            respektive handläggare, sparas.*/
            adminAid = idb.fetchColumn(sqlFragaAdmin);
            handlaggareAid = idb.fetchColumn(sqlFragaHandlaggare);

        } catch (InfException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            String sqlFraga = "SELECT * "
                    + "FROM anstalld";
               
            allaAnstalldaMap = idb.fetchRows(sqlFraga);
        } catch (InfException ex) {
            System.out.println(ex.getMessage() + "i Avdelning.java, getAnstallningsID()");
        }
        /*Hämtar all data från tabellen anstalld, som sparas i en ArrayList med HashMaps,
        där en HashMap representerar en rad i tabellen. */
        
        for (HashMap<String, String> enAnstalld : allaAnstalldaMap) {
            String aid = enAnstalld.get("aid");
            boolean admin = false;
            boolean handlaggare = false;
            /*Jämför anställningsIDt på en anställd, gentemot listorna där administratörerna 
            och handläggarnas IDn sparats */
            if (adminAid.contains(aid)) {
                admin = true;
            }
            if (handlaggareAid.contains(aid)) {
                handlaggare = true;
            }
            //Lägger till en anställd i den lokala ArrayListan 'samtligaAnstallda
            allaAnstallda.add(new Anvandare(idb, enAnstalld, admin, handlaggare));
        }
        //Tilldelar till sist medlemsfältet 'allaAnstallda', den lokala ArrayListan samtligaAnstallda
        samtligaAnstallda = allaAnstallda;
    }
    
    public Anvandare get(int i){
        return allaAnvandare.get(i);
    }
    
    public ArrayList<Anvandare> getLista(){
        return allaAnvandare;
    }
    
    public ArrayList<Anvandare> getAllaAnstallda(){
        hamtaSamtligaAnstallda();
        return samtligaAnstallda;
    }
    
    public ArrayList<String> hamtaHandlaggare(){
        //Hämtar alla anställningsIDn på de anställda som är handläggare
        ArrayList<String> allaHandlaggare = new ArrayList<>();
        try {
            String sqlFraga = "SELECT aid FROM handlaggare";
            allaHandlaggare = idb.fetchColumn(sqlFraga);
            }
        catch(InfException ex) {
            System.out.println(ex.getMessage());
        }
        return allaHandlaggare;
    }
    
    public void hamtaAdmins(){
        //Hämtar alla anställningsIDn på de anställda som är admins
        ArrayList<HashMap<String, String>> allaAdmins = new ArrayList<>();
        try {
            String sqlFraga = "SELECT aid FROM handlaggare";
            allaAdmins = idb.fetchRows(sqlFraga);
            }
        catch(InfException ex) {
            System.out.println(ex.getMessage());
        }
        ArrayList<String> admins = new ArrayList<>();
        for(HashMap<String, String> enAdmin : allaAdmins){
            handlaggare.add(enAdmin.get("aid)"));
        }
        this.administrator = admins;
    }
    
    
    public ArrayList<String> getAmin(){
        hamtaAdmins();
        return administrator;
    }
    
    public int getMaxAID(){
        int maxAid = 0;
        try{
            //hämtar anställd med högst anst.ID
            String sqlFraga = "SELECT MAX(aid) FROM anstalld";
            
            ArrayList<String> maxAidList = idb.fetchColumn(sqlFraga);
            
            maxAid = Integer.parseInt(maxAidList.get(0));
        }
        catch(InfException ex) {
            System.out.println(ex.getMessage());
        }
        return maxAid;
    }
}
