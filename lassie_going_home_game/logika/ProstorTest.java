package logika;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/*******************************************************************************
 * Testovací třída ProstorTest slouží ke komplexnímu otestování
 * třídy Prostor
 */
public class ProstorTest {

  @Test
  public void testLzeProjit() {
    Prostor prostor1 =
        new Prostor("kotec", "test popis", false, false, false);
    Prostor prostor2 = new Prostor("stáj", "test popis", true, true, false);
    prostor1.setPruchod(new Pruchod(true, true, prostor2));
    assertEquals(prostor2, prostor1.vratMoznyPruchod("stáj").get().getCilovyProstor());
    assertTrue(prostor2.vratMoznyPruchod("pokoj").isEmpty());
  }

  @Test
  public void testNelzeProjitNeviditelnymPruchodem() {
    Prostor prostor1 =
        new Prostor("kotec", "test popis", false, false, false);
    Prostor prostor2 = new Prostor("stáj", "test popis", true, true, false);
    prostor1.setPruchod(new Pruchod(false, true, prostor2));
    assertTrue(prostor2.vratMoznyPruchod("stáj").isEmpty());
  }

}
