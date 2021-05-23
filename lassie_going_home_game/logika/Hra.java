package logika;

import java.util.Arrays;
import logika.prikazy.IPrikaz;
import logika.prikazy.PrikazCurej;
import logika.prikazy.PrikazHrabej;
import logika.prikazy.PrikazJdi;
import logika.prikazy.PrikazJez;
import logika.prikazy.PrikazKonec;
import logika.prikazy.PrikazNapoveda;
import logika.prikazy.PrikazPij;
import logika.prikazy.PrikazPsiOci;
import logika.prikazy.PrikazSeber;
import logika.prikazy.PrikazStekej;
import logika.prikazy.PrikazZjistiStav;

/**
 * Třída Hra - třída představující logiku adventury. Toto je hlavní třída logiky aplikace. Tato
 * třída vytváří instanci třídy HerniPlan, která inicializuje mistnosti hry a vytváří seznam
 * platných příkazů a instance tříd provádějící jednotlivé příkazy. Vypisuje uvítací a ukončovací
 * text hry. Také vyhodnocuje jednotlivé příkazy zadané uživatelem.
 */
public class Hra implements IHra {
  private final SeznamPrikazu platnePrikazy; // obsahuje seznam přípustných příkazů
  private final HerniPlan herniPlan;
  private boolean konecHry;

  /**
   * Vytváří hru a inicializuje místnosti (prostřednictvím třídy HerniPlan) a seznam platných
   * příkazů.
   */
  public Hra() {
    herniPlan = new HerniPlan();
    platnePrikazy = new SeznamPrikazu();
    platnePrikazy.vlozPrikaz(new PrikazNapoveda(platnePrikazy));
    platnePrikazy.vlozPrikaz(new PrikazJdi(herniPlan));
    platnePrikazy.vlozPrikaz(new PrikazKonec(this));
    platnePrikazy.vlozPrikaz(new PrikazStekej(herniPlan));
    platnePrikazy.vlozPrikaz(new PrikazJez(herniPlan));
    platnePrikazy.vlozPrikaz(new PrikazSeber(herniPlan));
    platnePrikazy.vlozPrikaz(new PrikazHrabej(herniPlan));
    platnePrikazy.vlozPrikaz(new PrikazPij(herniPlan));
    platnePrikazy.vlozPrikaz(new PrikazPsiOci(herniPlan));
    platnePrikazy.vlozPrikaz(new PrikazZjistiStav(herniPlan));
    platnePrikazy.vlozPrikaz(new PrikazCurej(herniPlan));
  }

  /** Vrátí úvodní zprávu pro hráče. */
  public String vratUvitani() {
    return "Vítejte!\n"
        + "Toto je příběh o fence Lassie, která se chce vrátit domů.\n"
        + "Napište 'nápověda', pokud si nevíte rady, jak hrát dál.\n"
        + "\n"
        + herniPlan.getAktualniProstor().dlouhyPopis();
  }

  /** Vrátí závěrečnou zprávu pro hráče. */
  public String vratEpilog() {
    return "Dík, že jste si zahráli.  Ahoj.";
  }

  /** Vrací true, pokud hra skončila. */
  public boolean konecHry() {
    return konecHry;
  }

  /**
   * Metoda zpracuje řetězec uvedený jako parametr, rozdělí ho na slovo příkazu a další parametry.
   * Pak otestuje zda příkaz je klíčovým slovem např. jdi. Pokud ano spustí samotné provádění
   * příkazu.
   *
   * @param radek text, který zadal uživatel jako příkaz do hry.
   * @return vrací se řetězec, který se má vypsat na obrazovku
   */
  public String zpracujPrikaz(String radek) {
    String[] slova = radek.split("[ \t]+");
    String slovoPrikazu = slova[0];
    if (!platnePrikazy.jePlatnyPrikaz(slovoPrikazu)) {
      return "Nevím co tím myslíš? Tento příkaz neznám. ";
    }

    String[] parametry = Arrays.stream(slova).skip(1).toArray(String[]::new);
    IPrikaz prikaz = platnePrikazy.vratPrikaz(slovoPrikazu);
    return prikaz.provedPrikaz(parametry);
  }

  /**
   * Nastaví, že je konec hry, metodu využívá třída PrikazKonec, mohou ji použít i další
   * implementace rozhraní Prikaz.
   *
   * @param konecHry hodnota false= konec hry, true = hra pokračuje
   */
  public void setKonecHry(boolean konecHry) {
    this.konecHry = konecHry;
  }

  /**
   * Metoda vrátí odkaz na herní plán, je využita hlavně v testech, kde se jejím prostřednictvím
   * získává aktualní místnost hry.
   *
   * @return odkaz na herní plán
   */
  public HerniPlan getHerniPlan() {
    return herniPlan;
  }
}
