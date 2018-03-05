package ImpresoraJordi;

import Exceptions.CisaExceptions;
import Functions.SendEmail;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.*;

/**
 *
 * @author linusdufol
 */
public class BrotherJordi {
 public static int per = 0, per2, per3, per4;
    public void BrotherJordi() throws FileNotFoundException, IOException, CisaExceptions {
        
        String source1 = "http://192.168.28.233/etc/view_config.html"; //Brother HL-L2340D
        URL url1 = new URL(source1);
        String targetDirectory1 = "src";
        String fileName = source1.substring(source1.lastIndexOf('/') + 1, source1.length()); /**************/
        Path targetPath = new File(targetDirectory1 + File.separator + fileName).toPath();  /*status.html*/
        Files.copy(url1.openStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);
        
        List<String> lines3 = new ArrayList<>(); //Array Brother Jordi
        List<Character> percCian = new ArrayList<>();
        List<Character> percMagenta = new ArrayList<>();
        List<Character> percGroc = new ArrayList<>();
        List<Character> percNegre = new ArrayList<>();
        try{
        Scanner info = new Scanner(new File("src/view_config.html")); //Llegim l'arxiu status.html

        while (info.hasNext()) {
            lines3.add(info.nextLine()); //A l'array 'lines' afegim una linia a cada posicio de status.html
        }

        for (int i = 6; percCian.size() <= 9;) {
            percCian.add(lines3.get(141).charAt(i));
            percMagenta.add(lines3.get(155).charAt(i));
            percGroc.add(lines3.get(169).charAt(i));
            percNegre.add(lines3.get(183).charAt(i));
            i += 8;
        }
            System.out.println(percCian);
            System.out.println(percMagenta);
            System.out.println(percGroc);
            System.out.println(percNegre);
        for (int i = 0; i < percCian.size(); i++) {
            if (percCian.get(i) == '0') {
                per += 1 * 10;
                System.out.println(per);
            }
            if (percMagenta.get(i) == '0') {
                per2 += 1 * 10;
            }
            if (percGroc.get(i) == '0') {
                per3 += 1 * 10;
            }
            if (percNegre.get(i) == '0') {
                per4 += 1 * 10;
            }
        }
        ArrayList<Integer> percCol = new ArrayList<>();
        ArrayList<String> colors = new ArrayList<>();
        SendEmail sendmail = new SendEmail();
        colors.add("negre");
        colors.add("cian");
        colors.add("magenta");
        colors.add("groc");
        percCol.add(per);
        percCol.add(per2);
        percCol.add(per3);
        percCol.add(per4);
        
        for (int i = 0; i < percCol.size(); i++) {
            if (percCol.get(i) <= 7) {
                System.out.println("La impresora s'ha quedat sense color " + colors.get(i) + ", " + "percentatge = " + percCol.get(i) + "%, " + "enviant mail ...");
                String subject = "La impresora: Brother Jordi s'ha quedat sense tinta";
                String messages = "Falta el color: " + colors.get(i);
                EnviarMail(sendmail, subject, messages);
            } else {
                System.out.println("Color " + colors.get(i) + " ... OK");
            }
        }

        String cian = lines3.get(144);
        String magenta = lines3.get(158);
        String yellow = lines3.get(172);
        String black = lines3.get(186);
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
