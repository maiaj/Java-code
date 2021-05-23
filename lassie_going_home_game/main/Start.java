/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package main;

import logika.Hra;
import logika.IHra;
import uiText.TextoveRozhrani;

/*******************************************************************************
 * Třída  Start je hlavní třídou projektu,
 * který představuje jednoduchou textovou adventuru určenou k dalším úpravám a rozšiřování
 */
public class Start {

  public static void main(String[] args) {

    IHra hra = new Hra();
    TextoveRozhrani ui = new TextoveRozhrani(hra);
    ui.hraj();
  }
}
