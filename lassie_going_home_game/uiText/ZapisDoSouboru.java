package uiText;

import java.io.*;

public class ZapisDoSouboru {

    public static void zapisRadek(String soubor, String radek) {
        try (var output = new BufferedWriter(new FileWriter(soubor, true))) {
            output.append(radek);
            output.newLine();
        } catch (IOException e) {
            System.out.println("Can't write to file.");
            e.printStackTrace();
        }
    }
}
