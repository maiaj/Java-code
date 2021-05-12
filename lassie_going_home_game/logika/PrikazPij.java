package logika;

public class PrikazPij implements IPrikaz {
    private static final String NAZEV = "pij";
    private HerniPlan plan;

    public PrikazPij(HerniPlan plan) {
        this.plan = plan;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        String novyText = null;
        if (plan.getAktualniProstor().getJeTamVoda() == true) {
            plan.getPes().pridejVodu(1);
            plan.getAktualniProstor().setJeTamVoda(false);
            novyText = "Máš " + plan.getPes().zjistiStav("voda") + " jednotek vody.";
        }
        else {
            novyText = "Tady se bohužel ničeho nenapiješ.";
        }
        return novyText;
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
