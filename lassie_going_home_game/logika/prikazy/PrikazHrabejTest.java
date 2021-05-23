package logika.prikazy;

import logika.HerniPlan;
import logika.Prostor;
import logika.Pruchod;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrikazHrabejTest {

    @Test
    public void testVProstoruSeNedaHrabat() {
        // arrange
        HerniPlan herniPlan = new HerniPlan();
        herniPlan.setAktualniProstor(new Prostor("test nazev", "test popis", false, false, false));
        IPrikaz prikazHrabej = new PrikazHrabej(herniPlan);

        // act
        String vysledek = prikazHrabej.provedPrikaz();

        // assert
        assertEquals("Tady nic nevyhrabeš.", vysledek);
    }

    @Test
    public void testVProstoruSeDaHrabat() {
        // arrange
        HerniPlan herniPlan = new HerniPlan();
        herniPlan.setAktualniProstor(new Prostor("test nazev", "test popis", false, false, true));
        IPrikaz prikazHrabej = new PrikazHrabej(herniPlan);

        // act
        String vysledek = prikazHrabej.provedPrikaz();

        // assert
        assertEquals(true, herniPlan.getAktualniProstor().getJeTamJidlo());
        assertEquals(false, herniPlan.getAktualniProstor().getJeHrabatelny());
        assertEquals("Vyhrabal jsi mrtvou veverku. Pochutnej si. Jsi v prostoru test popis.\n" +
                        "Východy: Nejsou zde žádné viditelné východy.",
                vysledek);
    }
    @Test
    public void testPruchodSeNedaHrabat() {
        // arrange
        HerniPlan herniPlan = new HerniPlan();
        Prostor prostor1 = new Prostor("test nazev", "test popis", false, false, false);
        Prostor prostor2 = new Prostor("test nazev", "test popis", false, false, false);
        herniPlan.setAktualniProstor(prostor1);
        herniPlan.getAktualniProstor().setPruchod(new Pruchod(true, false, prostor2));
        IPrikaz prikazHrabej = new PrikazHrabej(herniPlan);

        // act
        String vysledek = prikazHrabej.provedPrikaz();

        // assert
        assertEquals("Tady nic nevyhrabeš.", vysledek);
    }

    @Test
    public void testPruchodSeDaHrabat() {
        // arrange
        HerniPlan herniPlan = new HerniPlan();
        Prostor prostor1 = new Prostor("test nazev 1", "test popis", false, false, false);
        Prostor prostor2 = new Prostor("test nazev 2", "test popis", false, false, false);
        herniPlan.setAktualniProstor(prostor1);
        herniPlan.getAktualniProstor().setPruchod(new Pruchod(false, true, prostor2));
        IPrikaz prikazHrabej = new PrikazHrabej(herniPlan);

        // act
        String vysledek = prikazHrabej.provedPrikaz();

        // assert
        assertEquals("Podařilo se ti vyhrabat dost velkou díru. Dobrá práce! \n" +
                "Východy: test nazev 2", vysledek);
    }
}