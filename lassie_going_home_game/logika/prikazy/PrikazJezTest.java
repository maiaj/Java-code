package logika.prikazy;

import static org.junit.Assert.assertEquals;

import logika.HerniPlan;
import logika.Pes;
import logika.Prostor;
import org.junit.Test;

public class PrikazJezTest {
  @Test
  public void testNeprijmeJidloKdyzJePesPlny() {
    // arrange
    Pes plnyPes = new Pes(Pes.MAX_JIDLO, 3);
    HerniPlan herniPlan = new HerniPlan(plnyPes);
    IPrikaz prikazJez = new PrikazJez(herniPlan);

    // act
    String vysledek = prikazJez.provedPrikaz();

    // assert
    assertEquals("Jídla už máš dost.", vysledek);
  }

  @Test
  public void testNeprijmeJidloKdyzVAktualnimProstoruNeni() {
    // arrange
    HerniPlan herniPlan = new HerniPlan();
    herniPlan.setAktualniProstor(new Prostor("test nazev", "test popis", false, false, false));
    IPrikaz prikazJez = new PrikazJez(herniPlan);

    // act
    String vysledek = prikazJez.provedPrikaz();

    // assert
    assertEquals("Tady nic k snědku není.", vysledek);
  }

  @Test
  public void testPrijmeJidlo() {
    // arrange
    Pes pes = new Pes(3, 0);
    HerniPlan herniPlan = new HerniPlan(pes);
    Prostor prostor = new Prostor("test nazev", "test popis", false, true, false);
    herniPlan.setAktualniProstor(prostor);
    IPrikaz prikazJez = new PrikazJez(herniPlan);

    // act
    String vysledek = prikazJez.provedPrikaz();

    // assert
    assertEquals(4, pes.getJidlo());
    assertEquals(false, prostor.getMaJidlo());
    assertEquals("Máš 4 jednotek jídla.", vysledek);
  }
}
