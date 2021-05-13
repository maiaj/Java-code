package logika.prikazy;

import logika.HerniPlan;
import logika.Pes;
import logika.Pruchod;

public class PrikazPsiOci implements IPrikaz {
    private static final String NAZEV = "oci";
    private HerniPlan plan;

    public PrikazPsiOci(HerniPlan plan) {
        this.plan = plan;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        if (plan.getAktualniProstor().getPostava() != null && plan.getAktualniProstor().getPostava().getFungujiPsiOci() == true) {
            if (plan.getAktualniProstor().getPostava().isOdtajnujeVychod() == true) {
                for (Pruchod pruchod : plan.getAktualniProstor().getTajnePruchody()) {
                    pruchod.setJeViditelny(true);
                    plan.getAktualniProstor().setPruchod(pruchod);
                    return "Tvoje psí oči zabraly, " + plan.getAktualniProstor().getPostava().getPopis() + " tě podrbe za uchem a pustí tě ven! " + plan.getAktualniProstor().dlouhyPopis();
                }
            } else if (plan.getAktualniProstor().getPostava().isZavezeDoCile() == true) {
                if (plan.getPes().isMaObojek() == true) {
                    plan.setAktualniProstor(plan.getKonecnyProstor());
                    return "Výborně, " + plan.getAktualniProstor().getPostava().getPopis() + " se podívá na tvůj obojek a zaveze tě domů.";
                } else {
                    plan.getAktualniProstor().setJeTamJidlo(true);
                    return "Bohužel nemáš obojek s adresou. " + plan.getAktualniProstor().getPostava().getPopis() + " neví, co s tebou, dá ti svou svačinu a nechá tě být.";
                }
            } else if (plan.getAktualniProstor().getPostava().isDavaJidloAVodu() == true) {
                plan.getAktualniProstor().setJeTamJidlo(true);
                plan.getAktualniProstor().setJeTamVoda(true);
                return "Máš štěstí, " + plan.getAktualniProstor().getPostava().getPopis() + " tě nakrmí a dá ti vodu.";
            }
        } else {
            return "Tady ti psí oči nepomůžou.";

        }
        return "Tady ti psí oči nepomůžou.";
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
