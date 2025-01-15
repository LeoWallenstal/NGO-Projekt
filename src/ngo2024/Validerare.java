package ngo2024;

/**
 *
 * @author james
 */
public class Validerare {
    
    public static boolean arEpostAdress(String epost){
        return epost.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    }
    
    //får innehålla +(isåfall i början), - och siffror
    public static boolean arTelefonnummer(String telefonnummer){
    return telefonnummer.matches("^[+]?\\d{1,4}[-]?\\d{1,4}[-]?\\d{1,4}$");
    }
    
    //format XXXX-XX-XX
    public static boolean arDatum(String datum){
            return datum.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$");
    }
    
    public static boolean arBokstaver(String bokstaver){
            return bokstaver.matches("^[a-zA-ZåäöÅÄÖ ]+$");
    }
    
    //Ska innehålla minst en bokstav (stora och små)& minst en siffra.
    //Ska innehålla en eller flera tecken.
    //Kan sluta med antingen bokstäver, siffror eller bindestreck.
    public static boolean arAdress(String adress) {
        return adress.matches("^(?=.*[a-zA-Z])(?=.*\\d).+[-a-zA-Z0-9]+$");
    }
    
    public static boolean arSiffror(String siffror){
            return siffror.matches("^\\d+$");
    }
    
    //ska innehålla en siffra och vara minst 8 tecken långt
    public static boolean formatLosenord(String losenord){
        return losenord.matches("^(?=.*\\d).{8,}$");
    }
    
    //belopp med upp till två decimaler
    public static boolean formatProjektKostnadOK(String kostnad){
        return kostnad.matches("^\\d{1,}(\\.\\d{2})?$");
    }
    //kontroll om namnet är förnamn & efternamn, - får förekomma
    public static boolean formatNamnOK(String namn){
        return namn.matches("^([A-Za-zÅÄÖåäö]+(?:-[A-Za-zÅÄÖåäö]+)?)\\s([A-Za-zÅÄÖåäö]+(?:-[A-Za-zÅÄÖåäö]+)?)$");
    }
   
    //namn får innehålla bokstäver & -
    public static boolean formatEnkeltNamnOK(String namn) {
        return namn.matches("^[A-Za-zÅÄÖåäö]+(?:-[A-Za-zÅÄÖåäö]+)?$");
    }

}

