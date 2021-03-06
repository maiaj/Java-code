package logika.prikazy;

import static org.junit.Assert.assertEquals;

import logika.HerniPlan;
import logika.Pes;
import logika.Prostor;
import logika.Pruchod;
import org.junit.Test;

public class PrikazJdiTest {

  @Test
  public void testPesNejdeKdyzNemaDostJidla() {
    // arrange
    Pes hladovyPes = new Pes(0, 3);
    HerniPlan herniPlan = new HerniPlan(hladovyPes);
    IPrikaz prikazJdi = new PrikazJdi(herniPlan);

    // act
    String vysledek = prikazJdi.provedPrikaz("test prostor");

    // assert
    assertEquals("Nemáš dost jídla. Najez se nebo zaštěkej a vrátíš se do kotce.", vysledek);
  }

  @Test
  public void testPesNejdeKdyzNemaKam() {
    // arrange
    HerniPlan herniPlan = new HerniPlan();
    Prostor prostor1 = new Prostor("test nazev 1", "test popis", false, true, false);
    Prostor prostor2 = new Prostor("test nazev 2", "test popis", false, true, false);
    herniPlan.setAktualniProstor(prostor1);
    herniPlan
        .getAktualniProstor()
        .setPruchod(new Pruchod(false, true, prostor2)); // v prostoru je neviditelny pruchod
    IPrikaz prikazJdi = new PrikazJdi(herniPlan);

    // act
    String vysledek = prikazJdi.provedPrikaz("test nazev 1");

    // assert
    assertEquals("Tady není žádný viditelný východ.", vysledek);
  }

  @Test
  public void testPesJde() {
    // arrange
    HerniPlan herniPlan = new HerniPlan();
    Prostor prostor1 = new Prostor("test nazev 1", "test popis", false, true, false);
    Prostor prostor2 = new Prostor("test nazev 2", "test popis", false, true, false);
    herniPlan.setAktualniProstor(prostor1);
    herniPlan
        .getAktualniProstor()
        .setPruchod(new Pruchod(true, true, prostor2)); // v prostoru je neviditelny pruchod
    IPrikaz prikazJdi = new PrikazJdi(herniPlan);

    // act
    String vysledek = prikazJdi.provedPrikaz("test nazev 2");

    // assert
    assertEquals(
        "Jsi v prostoru test popis.\n"
            + "Nejsou zde žádné viditelné východy.. Máš 4 jednotek jídla a 4 jednotek vody.",
        vysledek);
  }

}
