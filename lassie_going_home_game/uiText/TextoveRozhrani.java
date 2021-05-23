package uiText;

import java.util.Scanner;
import logika.IHra;
/**
 * Class TextoveRozhrani
 *
 * <p>Toto je uživatelského rozhraní aplikace Adventura Tato třída vytváří instanci třídy Hra, která
 * představuje logiku aplikace. Čte vstup zadaný uživatelem a předává tento řetězec logice a
 * vypisuje odpověď logiky na konzoli.
 */
public class TextoveRozhrani {
  private static final String PROMPT = "> ";
  private final IHra hra;

  public TextoveRozhrani(IHra hra) {
    this.hra = hra;
  }

  /**
   * Hlavní metoda hry. Vypíše úvodní text a pak opakuje čtení a zpracování příkazu od hráče do
   * konce hry (dokud metoda konecHry() z logiky nevrátí hodnotu true). Nakonec vypíše text epilogu.
   */
  public void hraj() {
    System.out.println(
        "Výstup ze hry se ti automaticky zapíše do souboru. Zadej cestu k souboru (default je output.txt): ");
    String soubor = this.prectiNazevSouboru();
    ZapisDoSouboru.zapisRadek(soubor, this.hra.vratUvitani());
    System.out.println(this.hra.vratUvitani());

    // základní cyklus programu - opakovaně se čtou příkazy a poté
    // se provádějí do konce hry.

    while (!this.hra.getKonecHry()) {
      String radek = this.prectiString();
      ZapisDoSouboru.zapisRadek(soubor, PROMPT + radek);
      String vysledek = this.hra.zpracujPrikaz(radek);
      ZapisDoSouboru.zapisRadek(soubor, vysledek);
      System.out.println(vysledek);
    }

    ZapisDoSouboru.zapisRadek(soubor, this.hra.vratEpilog());
    System.out.println(this.hra.vratEpilog());
  }

  private String prectiNazevSouboru() {
    String soubor = this.prectiString();
    if (soubor.isEmpty()) {
      soubor = "output.txt";
    }
    return soubor;
  }
  /**
   * Metoda přečte příkaz z příkazového řádku
   *
   * @return Vrací přečtený příkaz jako instanci třídy String
   */
  private String prectiString() {
    Scanner scanner = new Scanner(System.in);
    System.out.print(PROMPT);
    return scanner.nextLine();
  }
}
