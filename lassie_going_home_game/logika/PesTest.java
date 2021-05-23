package logika;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PesTest {

  @Test
  public void testPesUmiJistAPit() {
    Pes pes = new Pes(0, 0);
    pes.pridejJidlo(1);
    pes.pridejVodu(3);
    assertEquals(1, pes.getJidlo());
    assertEquals(3, pes.getVoda());
  }

  @Test
  public void testPesNepijeANejiKdyzMaPlno() {
    Pes pes = new Pes(Pes.MAX_JIDLO, Pes.MAX_VODA - 1);
    pes.pridejVodu(3);
    pes.pridejJidlo(1);
    assertEquals(Pes.MAX_VODA, pes.getVoda());
    assertEquals(Pes.MAX_JIDLO, pes.getJidlo());
  }

  @Test
  public void testPsoviUbyvaJidloAVoda() {
    Pes pes = new Pes(5, 5);
    pes.uberVodu(1);
    pes.uberJidlo();
    assertEquals(4, pes.getVoda());
    assertEquals(4, pes.getJidlo());
  }

  @Test
  public void testPesSeNemuzeDostatDoMinusu() {
    Pes pes = new Pes(0, 0);
    pes.uberVodu(1);
    pes.uberJidlo();
    assertEquals(0, pes.getVoda());
    assertEquals(0, pes.getJidlo());
  }

  @Test
  public void testPesMuzeHasit() {
    Pes pes = new Pes(10, 10);
    assertTrue(pes.muzeHasit());
  }

  @Test
  public void testPesHasi() {
    Pes pes = new Pes(10, 10);
    pes.hasit();
    assertEquals(0, pes.getVoda());
  }

}
