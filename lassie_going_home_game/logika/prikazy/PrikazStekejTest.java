package logika.prikazy;

import static org.junit.Assert.assertEquals;

import logika.HerniPlan;
import logika.Prostor;
import org.junit.Test;

public class PrikazStekejTest {

  @Test
  public void testStekaniVKotciNicNeudela() {
    // arrange
    HerniPlan herniPlan = new HerniPlan();
    IPrikaz prikazStekej = new PrikazStekej(herniPlan);
    herniPlan.setAktualniProstor(herniPlan.getPocatecniProstor());

    // act
    String vysledek = prikazStekej.provedPrikaz();

    // assert
    assertEquals("Jsi v kotci. Tady můžeš štěkat kolik chcseš a nic to neudělá.", vysledek);
  }

  @Test
  public void testStekaniVratiPsaNaZacatek() {
    // arrange
    HerniPlan herniPlan = new HerniPlan();
    IPrikaz prikazStekej = new PrikazStekej(herniPlan);
    Prostor prostor1 = new Prostor("test nazev1", "test popis", false, false, false);
    Prostor prostor2 = new Prostor("test nazev2", "test popis", false, false, false);
    herniPlan.setPocatecniProstor(prostor1);
    herniPlan.setAktualniProstor(prostor2);

    // act
    prikazStekej.provedPrikaz();

    // assert
    assertEquals(3, herniPlan.getPes().getJidlo());
    assertEquals(2, herniPlan.getPes().getVoda());
    assertEquals(prostor1, herniPlan.getAktualniProstor());
  }
}
