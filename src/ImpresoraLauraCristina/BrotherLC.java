package ImpresoraLauraCristina;

import Exceptions.CisaExceptions;
import Functions.SendEmail;
import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.*;

/**
 *
 * @author linusdufol
 */
public class BrotherLC {
    public static int a;
    public static void BrotherLC() throws MalformedURLException, IOException, CisaExceptions {
        
        String source1 = "http://192.168.28.234/general/status.html"; //Brother HL-L2340D
        URL url1 = new URL(source1);
        try{
            
        String targetDirectory1 = "src";
        String fileName = source1.substring(source1.lastIndexOf('/') + 1, source1.length()); /**************/
        Path targetPath = new File(targetDirectory1 + File.separator + fileName).toPath();  /*status.html*/
        Files.copy(url1.openStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);    /**************/
        
        
        Scanner Brother = new Scanner(new File("src/status.html")); //Llegim l'arxiu status.html
        
        
        List<String> lines = new ArrayList<>(); //Array Brother HL-L2340D series
        while (Brother.hasNext()) {
            lines.add(Brother.nextLine()); //A l'array 'lines' afegim una linia a cada posicio de status.html
        }
        
        int int1 = lines.get(8).charAt(218); //Agafem la 1a unitat del height de la barra de percentatge de tinta
        int int2 = lines.get(8).charAt(219); //Agafem la 2a unitat del height de la barra de percentatge de tinta
        int total = ((int1 + int2) * 100) / 170; //Els sumem
        a = total; 
        SendEmail sendmail = new SendEmail();
        if(total <= 7){
             System.out.println("La impresora s'ha quedat sense tinta, enviant mail ...");
             String subject = "La impresora: Brother Laura & Cristina s'ha quedat sense tinta";
             String messages = "Falta el color: Negre (unic color)";
             EnviarMail(sendmail, subject, messages);
        }else{
            System.out.println("Color negre ... OK");
        }
        }catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void EnviarMail(SendEmail sendmail, String subject, String messages) {
        try {
            sendmail.Email(subject, messages);
        } catch (CisaExceptions ex) {
            System.out.println(ex.getMessage());
        }
    }
   
}
