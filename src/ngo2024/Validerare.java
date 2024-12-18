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
            return telefonnummer.matches("^\\d{10}$");
    }
    
}
