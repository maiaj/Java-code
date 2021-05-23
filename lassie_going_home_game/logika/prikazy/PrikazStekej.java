package logika.prikazy;

import logika.HerniPlan;

/*
Prikaz stekej umoznuje psovi vratit se v kterekoli fazi hry zpatky do kotce.
Zaroven se mu navysi stav jidla a vody na pocatecni hodnotu.
 */

public class PrikazStekej implements IPrikaz {
    private static final String NAZEV = "stekej";
    private final HerniPlan plan;

    public PrikazStekej(HerniPlan plan) {
        this.plan = plan;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        if (plan.getAktualniProstor().equals(plan.getPocatecniProstor())) {
            return "Jsi v kotci. Tady můžeš štěkat kolik chcseš a nic to neudělá.";
        }
        else {
            plan.resetujHerniPlan();
            plan.setAktualniProstor(plan.getPocatecniProstor());
            plan.getPes().setVoda(2);
            plan.getPes().setJidlo(3);
            return "Tvoje štěkání přivolalo farmáře, který tě zavezl zpátky na farmu a zavřel tě do kotce. Jsi zase na začátku.\n"
                    + plan.getAktualniProstor().dlouhyPopis();
        }
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
