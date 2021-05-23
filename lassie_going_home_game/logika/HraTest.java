package logika;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/*******************************************************************************
 * Testovací třída HraTest slouží ke komplexnímu otestování
 * třídy Hra
 */
public class HraTest {
  private Hra hra1;

  @Before
  public void setUp() {
    this.hra1 = new Hra();
  }

  @Test
  public void testPrubehHry() {
    assertEquals("kotec", this.hra1.getHerniPlan().getAktualniProstor().getNazev());
    this.hra1.zpracujPrikaz("hrabej");
    this.hra1.zpracujPrikaz("jdi stáj");
    assertFalse(this.hra1.getKonecHry());
    assertEquals("stáj", this.hra1.getHerniPlan().getAktualniProstor().getNazev());
    this.hra1.zpracujPrikaz("oci");
    this.hra1.zpracujPrikaz("jdi dvůr");
    assertFalse(this.hra1.getKonecHry());
    assertEquals("dvůr", this.hra1.getHerniPlan().getAktualniProstor().getNazev());
    // otestuju dva zpusoby ukonceni hry:
    this.hra1.zpracujPrikaz("konec");
    assertTrue(this.hra1.getKonecHry());
    this.hra1.getHerniPlan().setAktualniProstor(this.hra1.getHerniPlan().getKonecnyProstor());
    assertTrue(this.hra1.getKonecHry());
  }

  @Test
  public void testLzeVyhratZkratkou() {
    this.hra1.zpracujPrikaz("hrabej");
    this.hra1.zpracujPrikaz("jdi stáj");
    this.hra1.zpracujPrikaz("seber obojek");
    this.hra1.zpracujPrikaz("oci");
    this.hra1.zpracujPrikaz("jdi dvůr");
    this.hra1.zpracujPrikaz("hrabej");
    this.hra1.zpracujPrikaz("jdi cesta");
    this.hra1.zpracujPrikaz("jdi parkoviště");
    this.hra1.zpracujPrikaz("oci");
    assertTrue(this.hra1.getKonecHry());
  }

  @Test
  public void testLzeVyhratDelsiCestou() {
    this.hra1.zpracujPrikaz("hrabej");
    this.hra1.zpracujPrikaz("jdi stáj");
    this.hra1.zpracujPrikaz("jez");
    this.hra1.zpracujPrikaz("pij");
    this.hra1.zpracujPrikaz("oci");
    this.hra1.zpracujPrikaz("jdi dvůr");
    this.hra1.zpracujPrikaz("jez");
    this.hra1.zpracujPrikaz("pij");
    this.hra1.zpracujPrikaz("hrabej");
    this.hra1.zpracujPrikaz("jdi cesta");
    this.hra1.zpracujPrikaz("jdi les");
    this.hra1.zpracujPrikaz("hrabej");
    this.hra1.zpracujPrikaz("jez");
    this.hra1.zpracujPrikaz("jdi suché_pole");
    this.hra1.zpracujPrikaz("seber klacek");
    this.hra1.zpracujPrikaz("jdi staveniště");
    this.hra1.zpracujPrikaz("curej");
    this.hra1.zpracujPrikaz("jdi domov");
    assertTrue(this.hra1.getKonecHry());
  }
}
