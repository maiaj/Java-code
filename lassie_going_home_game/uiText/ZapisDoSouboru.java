package uiText;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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
