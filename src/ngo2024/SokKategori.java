/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package ngo2024;

/**
 *
 * @author james
 */
/*Enumklass som hjälper funktionaliteten att filtrera
om man vill söka efter projektchef eller projektnamn */
public enum SokKategori {
    PROJEKTCHEF("Projektchef"),
    PROJEKTNAMN("Projektnamn"),
    ALLA("Alla");
    
    private final String beteckning;
    
    SokKategori(String beteckning){
        this.beteckning = beteckning;
    }
    
    public String getBeteckning(){
        return beteckning;
    }
    
    public boolean equals(String beteckning){
        return beteckning.equals(this.beteckning);
    }
}
