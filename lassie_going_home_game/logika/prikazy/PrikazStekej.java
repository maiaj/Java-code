package logika.prikazy;

import logika.HerniPlan;

public class PrikazStekej implements IPrikaz {
    private static final String NAZEV = "stekej";
    private HerniPlan plan;

    public PrikazStekej(HerniPlan plan) {
        this.plan = plan;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        if (plan.getAktualniProstor().equals(plan.getPocatecniProstor())) {
            return "Jsi v kotci. Zaštěkal jsi, ale nic to neudělalo.";
        }
        else {
            plan.setAktualniProstor(plan.getPocatecniProstor());
            plan.getPes().pridejVodu(2);
            plan.getPes().pridejJidlo(3);
            return "Tvoje štěkání přivolalo farmáře, který tě zavezl zpátky na farmu a zavřel tě do kotce. Jsi zase na začátku.";
        }
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
