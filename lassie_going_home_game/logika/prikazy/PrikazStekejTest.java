package logika.prikazy;

import static org.junit.Assert.assertEquals;

import logika.HerniPlan;
import logika.Pes;
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
    herniPlan.zalozProstoryHry();

    // act
    prikazStekej.provedPrikaz();

    // assert
    assertEquals(Pes.DEFAULT_JIDLO, herniPlan.getPes().getJidlo());
    assertEquals(Pes.DEFAULT_VODA, herniPlan.getPes().getVoda());
    assertEquals("kotec", herniPlan.getAktualniProstor().getNazev());
  }
}
