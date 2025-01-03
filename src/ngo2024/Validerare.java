package ngo2024;

/**
 *
 * @author james
 */
public class Validerare {
    
    public static boolean arEpostAdress(String epost){
        return epost.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    }
    
    public static boolean arTelefonnummer(String telefonnummer){
            return telefonnummer.matches("^\\d{3}-\\d{3}-\\d{4}$");
    }
    
    public static boolean arDatum(String datum){
            return datum.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$");
    }
    
    public static boolean arBokstaver(String bokstaver){
            return bokstaver.matches("^[a-zA-ZåäöÅÄÖ ]+$");
    }
    
    //Kollar formatet på en adress där kommatecken mellan stad är optional
    //e.g. "123 Main Street, Anytown", men även "123 Main Street Anytown" ska funka
    public static boolean arAdress(String adress){
            return adress.matches("^(\\d+)\\s([A-Za-z\\s-]+)(?:,\\s)?([A-Za-z\\s-]+)$");
    }
    
    public static boolean arSiffror(String siffror){
            return siffror.matches("^\\d+$");
    }
    
    public static boolean formatLosenord(String losenord){
        return losenord.matches("^(?=.*\\d).{8,}$");
    }
    
    public static boolean formatProjektKostnadOK(String kostnad){
        return kostnad.matches("^\\d{1,}(\\.\\d{2})?$");
    }
    
    public static boolean formatNamnOK(String namn){
        return namn.matches("^([A-Za-zÅÄÖåäö]+(?:-[A-Za-zÅÄÖåäö]+)?)\\s([A-Za-zÅÄÖåäö]+(?:-[A-Za-zÅÄÖåäö]+)?)$");
    }

}

