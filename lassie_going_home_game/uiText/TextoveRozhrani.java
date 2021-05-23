package uiText;


import logika.IHra;

import java.util.Scanner;
/**
 *  Class TextoveRozhrani
 * 
 *  Toto je uživatelského rozhraní aplikace Adventura
 *  Tato třída vytváří instanci třídy Hra, která představuje logiku aplikace.
 *  Čte vstup zadaný uživatelem a předává tento řetězec logice a vypisuje odpověď logiky na konzoli.
 */

public class TextoveRozhrani {
    private static final String PROMPT = "> ";
    private final IHra hra;

    /**
     *  Vytváří hru.
     */
    public TextoveRozhrani(IHra hra) {
        this.hra = hra;
    }

    /**
     *  Hlavní metoda hry. Vypíše úvodní text a pak opakuje čtení a zpracování
     *  příkazu od hráče do konce hry (dokud metoda konecHry() z logiky nevrátí
     *  hodnotu true). Nakonec vypíše text epilogu.
     */
    public void hraj() {
        System.out.println("Výstup ze hry se ti automaticky zapíše do souboru. Zadej název souboru (default je output.txt): ");
        String soubor = prectiString();
        if (soubor.isEmpty()) {
            soubor = "output.txt";
        }
        ZapisDoSouboru.zapisRadek(soubor, hra.vratUvitani());
        System.out.println(hra.vratUvitani());

        // základní cyklus programu - opakovaně se čtou příkazy a poté
        // se provádějí do konce hry.

        while (!hra.konecHry()) {
            String radek = prectiString();
            ZapisDoSouboru.zapisRadek(soubor, PROMPT + radek);
            String vysledek = hra.zpracujPrikaz(radek);
            ZapisDoSouboru.zapisRadek(soubor, vysledek);
            System.out.println(vysledek);
        }

        ZapisDoSouboru.zapisRadek(soubor, hra.vratEpilog());
        System.out.println(hra.vratEpilog());
    }

    /**
     *  Metoda přečte příkaz z příkazového řádku
     *
     *@return    Vrací přečtený příkaz jako instanci třídy String
     */
    private String prectiString() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(PROMPT);
        return scanner.nextLine();
    }

}
