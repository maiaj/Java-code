package logika.prikazy;

import logika.HerniPlan;

/* Tento prikaz umoznuje psovi jist jidlo, ktere je v prostoru.
Jidlo je potreba k tomu, aby pes mohl chodit. Kazdy prikaz jez pridava 1 jednotku jidla.
*/

public class PrikazJez implements IPrikaz {
    private static final String NAZEV = "jez";
    private HerniPlan plan;

    public PrikazJez(HerniPlan plan) {
        this.plan = plan;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        if (!plan.getPes().muzeJestePrijmoutJidlo()) {
            return "Jídla už máš dost.";
        }
        if (!plan.getAktualniProstor().getJeTamJidlo()) {
            return "Tady nic k snědku není.";
        }

        plan.getPes().pridejJidlo(1);
        plan.getAktualniProstor().setJeTamJidlo(false);
        return "Máš " + plan.getPes().getJidlo() + " jednotek jídla.";
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
