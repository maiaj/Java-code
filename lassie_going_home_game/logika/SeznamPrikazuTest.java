package logika;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import logika.prikazy.PrikazJdi;
import logika.prikazy.PrikazKonec;
import org.junit.Before;
import org.junit.Test;

/*******************************************************************************
 * Testovací třída SeznamPrikazuTest slouží ke komplexnímu otestování třídy
 * SeznamPrikazu
 */
public class SeznamPrikazuTest {
  private Hra hra;
  private PrikazKonec prKonec;
  private PrikazJdi prJdi;

  @Before
  public void setUp() {
    this.hra = new Hra();
    this.prKonec = new PrikazKonec(this.hra);
    this.prJdi = new PrikazJdi(this.hra.getHerniPlan());
  }

  @Test
  public void testVlozeniVybrani() {
    SeznamPrikazu seznPrikazu = new SeznamPrikazu();
    seznPrikazu.vlozPrikaz(this.prKonec);
    seznPrikazu.vlozPrikaz(this.prJdi);
    assertEquals(this.prKonec, seznPrikazu.vratPrikaz("konec"));
    assertEquals(this.prJdi, seznPrikazu.vratPrikaz("jdi"));
    assertNull(seznPrikazu.vratPrikaz("nápověda"));
  }

  @Test
  public void testJePlatnyPrikaz() {
    SeznamPrikazu seznPrikazu = new SeznamPrikazu();
    seznPrikazu.vlozPrikaz(this.prKonec);
    seznPrikazu.vlozPrikaz(this.prJdi);
    assertTrue(seznPrikazu.jePlatnyPrikaz("konec"));
    assertTrue(seznPrikazu.jePlatnyPrikaz("jdi"));
    assertFalse(seznPrikazu.jePlatnyPrikaz("nápověda"));
    assertFalse(seznPrikazu.jePlatnyPrikaz("Konec"));
  }

  @Test
  public void testNazvyPrikazu() {
    SeznamPrikazu seznPrikazu = new SeznamPrikazu();
    seznPrikazu.vlozPrikaz(this.prKonec);
    seznPrikazu.vlozPrikaz(this.prJdi);
    String nazvy = seznPrikazu.vratNazvyPrikazu();
    assertTrue(nazvy.contains("konec"));
    assertTrue(nazvy.contains("jdi"));
    assertFalse(nazvy.contains("nápověda"));
    assertFalse(nazvy.contains("Konec"));
  }
}
