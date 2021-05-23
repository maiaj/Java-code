package logika;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
        Pes pes = new Pes(10, 9);
        pes.pridejVodu(3);
        pes.pridejJidlo(1);
        assertEquals(9, pes.getVoda());
        assertEquals(10, pes.getJidlo());
    }

    @Test
    public void testPsoviUbyvaJidloAVoda() {
        Pes pes = new Pes(5, 5);
        pes.uberVodu(1);
        pes.uberVodu(6);
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

}