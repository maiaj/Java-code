package logika.prikazy;

import logika.HerniPlan;

public class PrikazJez implements IPrikaz {
    private static final String NAZEV = "jez";
    private HerniPlan plan;

    public PrikazJez(HerniPlan plan) {
        this.plan = plan;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        String novyText = null;
        if (plan.getAktualniProstor().getJeTamJidlo() == true) {
            plan.getPes().pridejJidlo(1);
            plan.getAktualniProstor().setJeTamJidlo(false);
            novyText = "Máš " + plan.getPes().zjistiStav("jidlo") + " jednotek jídla.";
        }
        else {
            novyText = "Tady nic k snědku není.";
        }
        return novyText;
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
