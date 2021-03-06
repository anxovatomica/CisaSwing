package HPComu;

import Functions.SendEmail;
import Functions.DisableSSLVerification;
import Exceptions.CisaExceptions;
import cisa_impresores.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author linusdufol
 */
public class HPComu {

    public static int b,c,m,g;

    public void HPComu() throws MalformedURLException, IOException, CisaExceptions {
        List<String> lines2 = new ArrayList<>(); //Array HP LaserJet 500 colorMFP M570dn&nbsp;&nbsp;&nbsp;192.168.28.8
        String source2 = "https://192.168.28.8/"; //HP LaserJet 500
        URL url2 = new URL(source2);

        String targetDirectory2 = "../index.html";

        DisableSSLVerification disableSsl = new DisableSSLVerification();
        DisableSsl(disableSsl); //Desavilito la verificacio ssl
        
try {
        String fileName2 = source2.substring(source2.lastIndexOf('/') + 1, source2.length());/****************/
        Path targetPath2 = new File(targetDirectory2 + File.separator + fileName2).toPath();/***index.html***/
        Files.copy(url2.openStream(), targetPath2, StandardCopyOption.REPLACE_EXISTING);   /****************/
        
        Scanner HPComun = new Scanner(new File("../index.html"));// Llegim l'arxiu index.html

        

        while (HPComun.hasNext()) {
            lines2.add(HPComun.nextLine()); //A l'array 'lines' afegim una linia a cada posicio de index.html
        }
        
        String askBlack = lines2.get(287).substring(30, 43);
        String askCian = lines2.get(329).substring(30, 43);
        String askMagenta = lines2.get(372).substring(30, 43);
        String askGroc = lines2.get(415).substring(30, 43);
        
        Double black = Double.parseDouble(lines2.get(293).replace(" ", "").substring(0, 2));//Percentatge color negre
        b = Integer.parseInt(lines2.get(293).replace(" ", "").substring(0, 2));
        Double cian = Double.parseDouble(lines2.get(335).replace(" ", "").substring(0, 2));//Percentatge color cian
        c = Integer.parseInt(lines2.get(335).replace(" ", "").substring(0, 2));
        Double magenta = Double.parseDouble(lines2.get(378).replace(" ", "").substring(0, 2));//Percentatge color magenta
        m = Integer.parseInt(lines2.get(378).replace(" ", "").substring(0, 2));
        Double groc = Double.parseDouble(lines2.get(421).replace(" ", "").substring(0, 2));//Percentatge color groc
        g = Integer.parseInt(lines2.get(421).replace(" ", "").substring(0, 2));

        ArrayList<Double> percCol = new ArrayList<>();
        ArrayList<String> colors = new ArrayList<>();
        ArrayList<String> tinta = new ArrayList<>();
        colors.add("negre");
        colors.add("cian");
        colors.add("magenta");
        colors.add("groc");
        percCol.add(black);
        percCol.add(cian);
        percCol.add(magenta);
        percCol.add(groc);
        tinta.add(askBlack);
        tinta.add(askCian);
        tinta.add(askMagenta);
            tinta.add(askGroc);

            SendEmail sendmail = new SendEmail();
            for (int i = 0; i < percCol.size(); i++) {
                if (percCol.get(i) <= 7) {
                    System.out.println("La impresora s'ha quedat sense color " + colors.get(i) + ", " + "percentatge = " + percCol.get(i) + "%, " + "enviant mail ...");
                    String subject = "La impresora: HP Comuna s'ha quedat sense tinta";
                    String messages = "Falta el color: " + colors.get(i) + " (" + percCol.get(i) + "%) \n" + "Cartuxos: " + tinta.get(i);
                    EnviarMail(sendmail, subject, messages);
                } else {
                    System.out.println("Color " + colors.get(i) + " ... OK");
                }
            }
        } catch (IOException | NumberFormatException e) {
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

    private static void DisableSsl(DisableSSLVerification disableSsl) {
        try {
            disableSsl.disableSslVerification();
            System.out.println("SSL Disabled");
        } catch (CisaExceptions ex) {
            System.out.println(ex.getMessage());
        }
    }

}
