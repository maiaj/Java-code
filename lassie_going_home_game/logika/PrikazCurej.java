package logika;

public class PrikazCurej implements IPrikaz{
    private static final String NAZEV = "curej";
    private HerniPlan plan;

    public PrikazCurej(HerniPlan plan) {
        this.plan = plan;
    }


    @Override
    public String provedPrikaz(String... parametry) {
        return null;
    }

    @Override
    public String getNazev() {
        return null;
    }
}
