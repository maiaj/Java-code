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
        if (plan.getPes().zjistiStavJidla() < plan.getPes().getMaxJidlo()) {
            if (plan.getAktualniProstor().getJeTamJidlo() == true) {
                plan.getPes().pridejJidlo(1);
                plan.getAktualniProstor().setJeTamJidlo(false);
                return "Máš " + plan.getPes().zjistiStavJidla() + " jednotek jídla.";
            } else {
                return "Tady nic k snědku není.";
            }
        } else {
            return "Jídla už máš dost.";
        }
    }

        @Override
        public String getNazev () {
            return NAZEV;
        }
    }
