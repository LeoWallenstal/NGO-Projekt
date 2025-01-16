/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ngo2024;

import com.formdev.flatlaf.FlatDarkLaf;
import ngo2024.fonster.InloggningFonster;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author walle
 */
public class NGO2024 {

    private static InfDB idb;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        FlatDarkLaf.setup();
        
        try{
            idb = new InfDB("ngo_2024","3306","dbAdmin2024","dbAdmin2024PW");
            new InloggningFonster(idb).setVisible(true);
        }catch (InfException ex){
            System.out.println(ex.getMessage());
        }
        
    }
    
}

/*

Till Mathias:

|\---/|
| o_o |
 \_^_/


    :-)

*/