package logika.prikazy;

import logika.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrikazCurejTest {

    @Test
    public void testNemuzeCuratKdyzNemaDostVody() {
        // arrange
        Pes pesBezVody = new Pes(3, 0);
        HerniPlan herniPlan = new HerniPlan(pesBezVody);
        IPrikaz prikazCurej = new PrikazCurej(herniPlan);

        // act
        String vysledek = prikazCurej.provedPrikaz();

        // assert
        assertEquals("Nemáš dost vody. Napij se.", vysledek);
    }

    @Test
    public void testKdyzVProstoruNeniOhenAPesTamJesteNebyl() {
        // arrange
        Pes pesSVodou = new Pes(3, 10);
        HerniPlan herniPlan = new HerniPlan(pesSVodou);
        Prostor prostor = new Prostor("test nazev", "test popis", false, true, false);
        herniPlan.setAktualniProstor(prostor);
        IPrikaz prikazCurej = new PrikazCurej(herniPlan);

        // act
        String vysledek = prikazCurej.provedPrikaz();

        // assert
        assertEquals(9, herniPlan.getPes().getVoda());
        assertEquals("Označkoval sis tento prostor. Příště tak poznáš, že už jsi tady byl.", vysledek);
    }

    @Test
    public void testKdyzVProstoruNeniOhenAPesTamUzByl() {
        // arrange
        Pes pesSVodou = new Pes(3, 10);
        HerniPlan herniPlan = new HerniPlan(pesSVodou);
        Prostor prostor = new Prostor("test nazev", "test popis", false, true, false);
        herniPlan.setAktualniProstor(prostor);
        herniPlan.getAktualniProstor().setJeOznaceny(true);
        IPrikaz prikazCurej = new PrikazCurej(herniPlan);

        // act
        String vysledek = prikazCurej.provedPrikaz();

        // assert
        assertEquals(10, herniPlan.getPes().getVoda());
        assertEquals("Tady už jsi byl.", vysledek);
    }

    @Test
    public void testPesNeuhasiOhenKdyzNemaDostVody() {
        // arrange
        Pes pesBezVody = new Pes(3, 7);
        HerniPlan herniPlan = new HerniPlan(pesBezVody);
        Prostor prostor = new Prostor("test nazev", "test popis", false, true, false);
        prostor.vlozVec(new Vec( "ohen", false));
        herniPlan.setAktualniProstor(prostor);
        IPrikaz prikazCurej = new PrikazCurej(herniPlan);

        // act
        String vysledek = prikazCurej.provedPrikaz();

        // assert
        assertEquals("Nemáš dost vody na to, abys oheň uhasil.", vysledek);
    }

    @Test
    public void testPesUhasiOhenKdyzMaDostVody() {
        // arrange
        Pes pesSVodou = new Pes(3, 10);
        HerniPlan herniPlan = new HerniPlan(pesSVodou);
        Prostor prostor1 = new Prostor("test nazev 1", "test popis", false, true, false);
        Prostor prostor2 = new Prostor("test nazev 2", "test popis", false, false, false);
        prostor1.vlozVec(new Vec( "ohen", false));
        herniPlan.setAktualniProstor(prostor1);
        herniPlan.getAktualniProstor().setPruchod(new Pruchod(false, false, prostor2));
        IPrikaz prikazCurej = new PrikazCurej(herniPlan);

        // act
        String vysledek = prikazCurej.provedPrikaz();

        // assert
        assertEquals(0, herniPlan.getPes().getVoda());
        assertEquals("Hurá! Uhasil si oheň! Konečně vidíš co je na druhé straně staveniště. Východy: test nazev 2", vysledek);
    }

    @Test
    public void testPesUhasiOhenSKlackem() {
        // arrange
        Pes pesSVodou = new Pes(3, 7);
        pesSVodou.setMaKlacek(true);
        HerniPlan herniPlan = new HerniPlan(pesSVodou);
        Prostor prostor1 = new Prostor("test nazev 1", "test popis", false, true, false);
        Prostor prostor2 = new Prostor("test nazev 2", "test popis", false, false, false);
        prostor1.vlozVec(new Vec( "ohen", false));
        herniPlan.setAktualniProstor(prostor1);
        herniPlan.getAktualniProstor().setPruchod(new Pruchod(false, false, prostor2));
        IPrikaz prikazCurej = new PrikazCurej(herniPlan);

        // act
        String vysledek = prikazCurej.provedPrikaz();

        // assert
        assertEquals(2, herniPlan.getPes().getVoda());
        assertEquals("Hurá! Uhasil si oheň! Konečně vidíš co je na druhé straně staveniště. Východy: test nazev 2", vysledek);
    }



}