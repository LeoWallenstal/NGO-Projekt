/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package ngo2024;

/**
 *
 * @author james
 */
public enum Projektstatus {
    ALLA ("Alla"),
    PÅGÅENDE ("Pågående"),
    PLANERAT ("Planerat"),
    AVSLUTAT ("Avslutat"),
    PAUSAT ("Pausat");
    
    private final String beteckning;
    
    Projektstatus(String beteckning){
        this.beteckning = beteckning;
    }
    
    @Override
    public String toString(){
        return beteckning;
    }
    
    public boolean equals(String beteckning){
        return beteckning.equals(this.beteckning);
    }
    
    public String getBeteckning(){
        return beteckning;
    }
}
