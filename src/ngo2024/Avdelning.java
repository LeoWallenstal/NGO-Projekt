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
public class Avdelning {

    private String avdelningsID;
    private String namn;
    private String beskrivning;
    private String adress;
    private String epost;
    private String telefonnummer;
    private Stad stad;
    private String stadID;
    private Anvandare chef;
    private String chefID;
    private ArrayList<Anvandare> anstallda;

    private InfDB idb;

    public Avdelning(HashMap<String, String> enAvdelning, InfDB idb) {
        this.idb = idb;  
        avdelningsID = enAvdelning.get("avdid");
        namn = enAvdelning.get("namn");
        beskrivning = enAvdelning.get("beskrivning");
        adress = enAvdelning.get("adress");
        epost = enAvdelning.get("epost");
        telefonnummer = enAvdelning.get("telefon");
        stadID = enAvdelning.get("stad");
        stad = new Stad(stadID, idb);
        chefID = enAvdelning.get("chef");
        if (chefID != null) {
            this.chef = new Anvandare(idb, this.getAnstalldID());
        } else {
            chef = null;
        }
        hamtaAnstallda();
    }

    public Avdelning(String avdelningsID, InfDB idb) {
        this.idb = idb;
        this.anstallda = new ArrayList<>();

        HashMap<String, String> enAvdelning = new HashMap<>();

        try {
            enAvdelning = idb.fetchRow("SELECT * FROM avdelning "
                    + " WHERE avdid = " + avdelningsID);
        } catch (InfException ex) {
            System.out.println(ex.getMessage() + "i Avdelning.java, Avdelning()");
        }

        for (String key : enAvdelning.keySet()) {
            switch (key) {
                case "avdid":
                    this.avdelningsID = enAvdelning.get(key);
                    break;
                case "namn":
                    this.namn = enAvdelning.get(key);
                    break;
                case "beskrivning":
                    this.beskrivning = enAvdelning.get(key);
                    break;
                case "adress":
                    this.adress = enAvdelning.get(key);
                    break;
                case "epost":
                    this.epost = enAvdelning.get(key);
                    break;
                case "telefon":
                    telefonnummer = enAvdelning.get(key);
                    break;
                case "stad": {
                    this.stadID = enAvdelning.get(key);
                    this.stad = new Stad(stadID, idb);
                    break;
                }
                case "chef": {
                    String chefID = enAvdelning.get(key);
                    if (chefID != null) {
                        this.chefID = chefID;
                        this.chef = new Anvandare(idb, this.getAnstalldID());
                    } else {
                        chef = null;
                    }
                    break;
                }
            }
        }
        hamtaAnstallda();
    }

    public String toString() {
        return "[AvdelningsID]: " + avdelningsID + "\n[Avdelningens namn]: " + namn
                + "\n[Beskrivning]: " + beskrivning + "\n[Adress]: " + adress
                + "\n[Epost]: " + epost + "\n[Telefonnummer]: " + telefonnummer
                + "\n[StadID]: " + stadID + "\n[Stad]: " + stad.getNamn()
                + "\n[ChefID]: " + chefID + "\n[Chef]: " + chef.getFullNamn();
    }

    public String getAvdelningsID() {
        return avdelningsID;
    }

    public String getNamn() {
        return namn;
    }

    public String getBeskrivning() {
        return beskrivning;
    }

    public String getAdress() {
        return adress;
    }

    public String getEpost() {
        return epost;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public Stad getStad() {
        return stad;
    }

    public String getStadID() {
        return stadID;
    }

    public Anvandare getChef() {
        return chef;
    }

    private String getAnstalldID() {
        String anstallningsID = "";

        try {
            String sqlFraga = "SELECT anstalld.aid "
                    + "FROM anstalld "
                    + "JOIN avdelning ON avdelning.chef = anstalld.aid "
                    + "WHERE avdelning.avdId = " + avdelningsID;

            anstallningsID = idb.fetchSingle(sqlFraga);
        } catch (InfException ex) {
            System.out.println(ex.getMessage() + "i Avdelning.java, getAnstallningsID()");
        }

        return anstallningsID;
    }

    public ArrayList<Anvandare> getAvdelningensAnstallda() {
        return anstallda;
    }

    public Anvandare getAnstalld(int i) {
        if (i >= 0 && i < anstallda.size()) {
            return anstallda.get(i);
        } else {
            return null;
        }
    }

    public boolean harAnstalld(String anstallningsID) {
        for (Anvandare enAnstalld : anstallda) {
            if (enAnstalld.getAnstallningsID().equals(anstallningsID)) {
                return true;
            }
        }
        return false;
    }

    public boolean removeAnstalld(String anstallningsID) {
        Iterator<Anvandare> it = anstallda.iterator();
        while (it.hasNext()) {
            Anvandare enAnstalld = it.next();
            if (enAnstalld.getAnstallningsID().equals(anstallningsID)) {
                anstallda.remove(enAnstalld);
                return true;
            }
        }
        return false;
    }

    public boolean equals(Avdelning annan) {
        return this.avdelningsID.equals(annan.getAvdelningsID());
    }

    public void hamtaSokNamn(String sokord) {
        ArrayList<Anvandare> resultat = new ArrayList<>();

        for (Anvandare enAnstalld : anstallda) {
            if (enAnstalld.getFullNamn().startsWith(sokord)) {
                resultat.add(enAnstalld);
            }
        }
        anstallda = resultat;
    }

    public void hamtaSokEpost(String sokord) {
        ArrayList<Anvandare> resultat = new ArrayList<>();

        for (Anvandare enAnstalld : anstallda) {
            if (enAnstalld.getEPost().startsWith(sokord)) {
                resultat.add(enAnstalld);
            }
        }
        anstallda = resultat;
    }

    public void hamtaAnstallda() {
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
        anstallda = avdelningensAnstallda;
    }

    public boolean updateUppgifter(String namn, String beskrivning, String adress, String stadId, String epost, String telefon, String chefId) {
        String sqlFraga = "UPDATE avdelning SET "
                + "namn = '" + namn + "', "
                + "beskrivning = '" + beskrivning + "', "
                + "adress = '" + adress + "', "
                + "stad = " + stadId + ", "
                + "epost = '" + epost + "', "
                + "telefon = '" + telefon + "', "
                + "chef = " + chefId + " "
                + "WHERE avdid = " + avdelningsID;
        System.out.println(sqlFraga);

        try {
            idb.update(sqlFraga);
            this.namn = namn;
            this.beskrivning = beskrivning;
            this.adress = adress;
            this.stad = new Stad(stadId,idb);
            this.epost = epost;
            this.telefonnummer = telefon;
            this.chefID = chefId;
            this.chef = new Anvandare(idb, chefID);
            return true;
        } catch (InfException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
}
