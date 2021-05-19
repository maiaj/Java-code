package logika.prikazy;

import logika.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrikazPsiOciTest {
    @Test
    public void testPesNemuzeUdelatPsiOciKdyzVProstoruNeniPostavaNaKterouFunguji() {
        // arrange
        HerniPlan herniPlan = new HerniPlan();
        Prostor prostor1 = new Prostor("test nazev", "test popis", false, false, false);
        herniPlan.setAktualniProstor(prostor1);
        IPrikaz prikazPsiOci = new PrikazPsiOci(herniPlan);

        // act
        String vysledek = prikazPsiOci.provedPrikaz();

        // assert
        assertEquals("Tady ti psí oči nepomůžou.", vysledek);

        prostor1.setPostava(new Postava("postava 1", "postava pro test", false, Schopnosti.odtajnujeVychod));
        assertEquals("Tady ti psí oči nepomůžou.", vysledek);
    }

    @Test
    public void testPostavaOdtajnujeVychod() {
        // arrange
        HerniPlan herniPlan = new HerniPlan();
        Prostor prostor1 = new Prostor("test nazev 1", "test popis", false, false, false);
        Prostor prostor2 = new Prostor("test nazev 2", "test popis", false, false, false);
        prostor1.setPostava(new Postava("postava 1", "postava pro test", true, Schopnosti.odtajnujeVychod));
        prostor1.setPruchod(new Pruchod(false, false, prostor2));
        herniPlan.setAktualniProstor(prostor1);
        IPrikaz prikazPsiOci = new PrikazPsiOci(herniPlan);

        // act
        String vysledek = prikazPsiOci.provedPrikaz();

        // assert
        assertEquals("Tvoje psí oči zabraly, postava pro test tě podrbe za uchem a pustí tě ven! Jsi v prostoru test popis.\n" +
                "Východy: test nazev 2", vysledek);
    }

    @Test
    public void testPostavaDavaJidloAVodu() {
        // arrange
        HerniPlan herniPlan = new HerniPlan();
        Prostor prostor1 = new Prostor("test nazev", "test popis", false, false, false);
        prostor1.setPostava(new Postava("postava 1", "postava pro test", true, Schopnosti.davaJidloAVodu));
        herniPlan.setAktualniProstor(prostor1);
        IPrikaz prikazPsiOci = new PrikazPsiOci(herniPlan);

        // act
        String vysledek = prikazPsiOci.provedPrikaz();

        // assert
        assertEquals(true, herniPlan.getAktualniProstor().getJeTamJidlo());
        assertEquals(true, herniPlan.getAktualniProstor().getJeTamVoda());
        assertEquals("Máš štěstí, postava pro test tě nakrmí a dá ti vodu.", vysledek);
    }

    @Test
    public void testPostavaDovezePsaDoCileKdyzMaObojek() {
        // arrange
        Pes pesSObojkem = new Pes(3,2);
        pesSObojkem.setMaObojek(true);
        HerniPlan herniPlan = new HerniPlan(pesSObojkem);
        Prostor prostor1 = new Prostor("test nazev", "test popis", false, false, false);
        prostor1.setPostava(new Postava("postava 1", "postava pro test", true, Schopnosti.zavezeDoCile));
        herniPlan.setAktualniProstor(prostor1);
        IPrikaz prikazPsiOci = new PrikazPsiOci(herniPlan);

        // act
        String vysledek = prikazPsiOci.provedPrikaz();

        // assert
        assertEquals("Výborně, řidič se podívá na tvůj obojek a zaveze tě domů.", vysledek);
    }

    @Test
    public void testPostavaNakrmiPsaKdyzNemaObojek() {
        // arrange
        HerniPlan herniPlan = new HerniPlan();
        Prostor prostor1 = new Prostor("test nazev", "test popis", false, false, false);
        prostor1.setPostava(new Postava("postava 1", "postava pro test", true, Schopnosti.zavezeDoCile));
        herniPlan.setAktualniProstor(prostor1);
        IPrikaz prikazPsiOci = new PrikazPsiOci(herniPlan);

        // act
        String vysledek = prikazPsiOci.provedPrikaz();

        // assert
        assertEquals(true, herniPlan.getAktualniProstor().getJeTamJidlo());
        assertEquals("Bohužel nemáš obojek s adresou. postava pro test neví, co s tebou, dá ti svou svačinu a nechá tě být.", vysledek);
    }
}

