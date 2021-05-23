package logika.prikazy;

import static org.junit.Assert.assertEquals;

import logika.HerniPlan;
import logika.Pes;
import logika.Postava;
import logika.Prostor;
import logika.Pruchod;
import logika.SchopnostPostavy;
import org.junit.Test;

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

    prostor1.setPostava(new Postava("postava pro test", false, SchopnostPostavy.ODTAJNUJE_VYCHOD));
    assertEquals("Tady ti psí oči nepomůžou.", vysledek);
  }

  @Test
  public void testPostavaOdtajnujeVychod() {
    // arrange
    HerniPlan herniPlan = new HerniPlan();
    Prostor prostor1 = new Prostor("test nazev 1", "test popis", false, false, false);
    Prostor prostor2 = new Prostor("test nazev 2", "test popis", false, false, false);
    prostor1.setPostava(new Postava("postava pro test", true, SchopnostPostavy.ODTAJNUJE_VYCHOD));
    prostor1.setPruchod(new Pruchod(false, false, prostor2));
    herniPlan.setAktualniProstor(prostor1);
    IPrikaz prikazPsiOci = new PrikazPsiOci(herniPlan);

    // act
    String vysledek = prikazPsiOci.provedPrikaz();

    // assert
    assertEquals(
        "Tvoje psí oči zabraly, postava pro test tě podrbe za uchem a můžeš jít ven! Jsi v prostoru test popis.\n"
            + "Východy: test nazev 2",
        vysledek);
  }

  @Test
  public void testPostavaDavaJidloAVodu() {
    // arrange
    HerniPlan herniPlan = new HerniPlan();
    Prostor prostor1 = new Prostor("test nazev", "test popis", false, false, false);
    prostor1.setPostava(new Postava("postava pro test", true, SchopnostPostavy.DAVA_JIDLO_A_VODU));
    herniPlan.setAktualniProstor(prostor1);
    IPrikaz prikazPsiOci = new PrikazPsiOci(herniPlan);

    // act
    String vysledek = prikazPsiOci.provedPrikaz();

    // assert
    assertEquals(true, herniPlan.getAktualniProstor().getMaJidlo());
    assertEquals(true, herniPlan.getAktualniProstor().getMaVodu());
    assertEquals("Máš štěstí, postava pro test tí dá něco k snědku a vodu.", vysledek);
  }

  @Test
  public void testPostavaDovezePsaDoCileKdyzMaObojek() {
    // arrange
    Pes pesSObojkem = new Pes(3, 2);
    pesSObojkem.seberVec("obojek");
    HerniPlan herniPlan = new HerniPlan(pesSObojkem);
    Prostor prostor1 = new Prostor("test nazev", "test popis", false, false, false);
    prostor1.setPostava(new Postava("postava pro test", true, SchopnostPostavy.ZAVEZE_DO_CILE));
    herniPlan.setAktualniProstor(prostor1);
    IPrikaz prikazPsiOci = new PrikazPsiOci(herniPlan);

    // act
    String vysledek = prikazPsiOci.provedPrikaz();

    // assert
    assertEquals(
        "Výborně, řidič se podívá na tvůj obojek, na kterém máš svou starou adresu a zaveze tě domů.\n"
            + "Jsi v cíli! Čekají tě zde prémiové psí dobroty, vychlazená voda, měkký pelíšek a hlavně zasloužené vítězství.",
        vysledek);
  }

  @Test
  public void testPostavaNakrmiPsaKdyzNemaObojek() {
    // arrange
    HerniPlan herniPlan = new HerniPlan();
    Prostor prostor1 = new Prostor("test nazev", "test popis", false, false, false);
    prostor1.setPostava(new Postava("postava pro test", true, SchopnostPostavy.ZAVEZE_DO_CILE));
    herniPlan.setAktualniProstor(prostor1);
    IPrikaz prikazPsiOci = new PrikazPsiOci(herniPlan);

    // act
    String vysledek = prikazPsiOci.provedPrikaz();

    // assert
    assertEquals(true, herniPlan.getAktualniProstor().getMaJidlo());
    assertEquals(
        "Bohužel nemáš obojek s adresou. postava pro test neví, co s tebou, dá ti svou svačinu, kterou můžeš sníst a nechá tě být.",
        vysledek);
  }
}
