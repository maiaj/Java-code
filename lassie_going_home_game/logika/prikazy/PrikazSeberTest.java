package logika.prikazy;

import logika.HerniPlan;
import logika.Pes;
import logika.Prostor;
import logika.Vec;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PrikazSeberTest {

    @Test
    public void testSebereVec() {
        // arrange
        HerniPlan herniPlan = new HerniPlan();
        Prostor prostor = new Prostor("test nazev", "test popis", false, true, false);
        prostor.vlozVec(new Vec("klacek", true));
        herniPlan.setAktualniProstor(prostor);
        IPrikaz prikazSeber = new PrikazSeber(herniPlan);

        // act
        String vysledek = prikazSeber.provedPrikaz("klacek");

        // assert
        assertTrue(herniPlan.getPes().isMaKlacek());
        assertEquals("Sebral jsi klacek.", vysledek);
    }

    @Test
    public void testNesebereDalsiVecStejnehoTypu() {
        // arrange
        Pes pesSKlackem = new Pes(3, 2);
        pesSKlackem.seberVec("klacek");
        HerniPlan herniPlan = new HerniPlan(pesSKlackem);
        Prostor prostor = new Prostor("test nazev", "test popis", false, true, false);
        prostor.vlozVec(new Vec("klacek", true));
        herniPlan.setAktualniProstor(prostor);
        IPrikaz prikazSeber = new PrikazSeber(herniPlan);

        // act
        String vysledek = prikazSeber.provedPrikaz("klacek");

        // assert
        assertTrue(pesSKlackem.isMaKlacek());
        assertEquals("klacek už máš.", vysledek);
    }

}