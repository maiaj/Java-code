package logika.prikazy;

import logika.HerniPlan;
import logika.Pes;
import logika.Pruchod;

public class PrikazPsiOci implements IPrikaz {
    private static final String NAZEV = "oci";
    private HerniPlan plan;
    private Pes pes;

    public PrikazPsiOci(HerniPlan plan) {
        this.plan = plan;
        this.pes = pes;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        String novyText = null;
        if (plan.getAktualniProstor().getJeTamClovek() == true && plan.getAktualniProstor().getPostava().getFungujiPsiOci() == true) {
            if (plan.getAktualniProstor().getPostava().isOdtajnujeVychod() == true) {
                for (Pruchod pruchod : plan.getAktualniProstor().getTajneVychody()) {
                    pruchod.setJeViditelny(true);
                    plan.getAktualniProstor().setPruchod(pruchod);
                    novyText = "Tvoje psí oči zabraly, " + plan.getAktualniProstor().getPostava().getPopis() + " tě podrbe za uchem a pustí tě ven! " + plan.getAktualniProstor().dlouhyPopis();
                }
            } else if (plan.getAktualniProstor().getPostava().isZavezeDoCile() == true) {
                if (pes.isMaObojek() == true) {
                    plan.setAktualniProstor(plan.getKonecnyProstor());
                    novyText = plan.getAktualniProstor().getPostava().getPopis() + " se podívá na tvůj obojek a zaveze tě domů."; // TODO: pisac teksty w past tense
                } else {
                    plan.getAktualniProstor().setJeTamJidlo(true);
                    novyText = "Bohužel nemáš obojek s adresou. " + plan.getAktualniProstor().getPostava().getPopis() + " neví, co s tebou, dá ti svou svačinu a nechá tě být.";
                }
            } else if (plan.getAktualniProstor().getPostava().isDavaJidloAVodu() == true) {
                plan.getAktualniProstor().setJeTamJidlo(true);
                plan.getAktualniProstor().setJeTamVoda(true);
                novyText = "Máš štěstí, " + plan.getAktualniProstor().getPostava().getPopis() + " tě nakrmí a dá ti vodu.";
            }
        } else {
            novyText = "Tady ti psí oči nepomůžou.";

        }
        return novyText;
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
