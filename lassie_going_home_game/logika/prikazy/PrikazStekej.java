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
        plan.setAktualniProstor(plan.getPocatecniProstor());
        plan.getPes().pridejVodu(2); // TODO: v kotcu nimozesz szczekac, max na jedzyni a wode, a lepszo hlaszka jak se tam wrocisz
        plan.getPes().pridejJidlo(3);
        return "Jsi zase na začátku.";
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
