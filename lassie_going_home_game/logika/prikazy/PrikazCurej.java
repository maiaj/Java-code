package logika.prikazy;

import logika.HerniPlan;
import logika.Pruchod;

public class PrikazCurej implements IPrikaz {
    private static final String NAZEV = "curej";
    private HerniPlan plan;

    public PrikazCurej(HerniPlan plan) {
        this.plan = plan;
    }


    @Override
    public String provedPrikaz(String... parametry) {
        if (plan.getAktualniProstor().obsahujeVec("ohen")) {
            if (plan.getPes().zjistiStavVody() >= 10 || (plan.getPes().zjistiStavVody() >= 5 && plan.getPes().isMaKlacek())) {
                plan.getAktualniProstor().odeberVec("ohen");
                if (plan.getPes().isMaKlacek()) {
                    plan.getPes().uberVodu(5);
                } else {
                    plan.getPes().uberVodu(10);
                }
                for (Pruchod pruchod : plan.getAktualniProstor().getTajnePruchody()) {
                    pruchod.setJeViditelny(true);
                    plan.getAktualniProstor().setPruchod(pruchod);
                }
                return "Hurá! Uhasil si oheň! Konečně vidíš co je na druhé straně staveniště. " + plan.getAktualniProstor().popisVychodu();
            } else {
                return "Nemáš dost vody na to, abys oheň uhasil.";
            }
        } else {
            if (plan.getAktualniProstor().isJeOznaceny() == false) {
                plan.getAktualniProstor().setJeOznaceny(true);
                plan.getPes().uberVodu(1);
                return "Označkoval sis tento prostor. Příště tak poznáš, že už jsi tady byl.";
            } else {
                return "Tady už jsi byl.";

            }
        }
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
