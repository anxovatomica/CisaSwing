package cisa_impresores;

import HPComu.HPComu;
import cisa_impresores.swing.Comu;
import cisa_impresores.swing.Comu;
import cisa_impresores.*;
import ImpresoraJordi.BrotherJordi;
import ImpresoraLauraCristina.BrotherLC;
import Exceptions.CisaExceptions;
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 *
 * @author linusdufol
 */
public class CisaSwing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, MalformedURLException, CisaExceptions {
        
        System.out.println("Processant dades ...");

        Main f = new Main();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        
        System.out.println("FUNCIONA");
    }

}
