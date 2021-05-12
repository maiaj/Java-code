package logika;

public class PrikazHrabej implements IPrikaz {
    private static final String NAZEV = "hrabej";
    private HerniPlan plan;

    public PrikazHrabej(HerniPlan plan) {
        this.plan = plan;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        if (plan.getAktualniProstor().getJeHrabatelny() == true) {
            plan.getAktualniProstor().setJeTamJidlo(true);
            plan.getAktualniProstor().setJeHrabatelny(false);
            return "Vyhrabal jsi mrtvou veverku. Pochutnej si. " + plan.getAktualniProstor().dlouhyPopis();
        } else {
            for (Pruchod pruchod : plan.getAktualniProstor().getTajneVychody()) {
                if (pruchod.isJeHrabatelny() == true) {
                    pruchod.setJeViditelny(true);
                    plan.getAktualniProstor().setPruchod(pruchod);
                    return "Podařilo se ti vyhrabat dost velkou díru. Dobrá práce! " + plan.getAktualniProstor().dlouhyPopis();
                }
            }
        }
        return "Tady nic nevyhrabeš.";
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
