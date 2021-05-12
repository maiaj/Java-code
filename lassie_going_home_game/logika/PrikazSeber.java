package logika;

public class PrikazSeber implements IPrikaz {
    private static final String NAZEV = "seber";
    private HerniPlan plan;

    public PrikazSeber(HerniPlan plan) {
        this.plan = plan;
    }

    @Override
    public String provedPrikaz(String... parametry) {
          if (parametry.length == 0) {
            // pokud chybí druhé slovo, tak ....
            return "Co mám sebrat? Zadej název věci, která je v prostoru.";
        } else {
            String vecVProstoru = parametry[0];
            if (parametry.length == 1 && vecVProstoru.equals("klacek") && plan.getAktualniProstor().obsahujeVec(vecVProstoru)) {
                plan.getPes().pridejKlacek();
                plan.getAktualniProstor().odeberVec(parametry[0]);
                return plan.getPes().pridejKlacek();
            } else if (parametry.length == 1 && vecVProstoru.equals("obojek") && plan.getAktualniProstor().obsahujeVec(vecVProstoru)) {
                plan.getPes().pridejObojek();
                plan.getAktualniProstor().odeberVec(parametry[0]);
                return plan.getPes().pridejObojek();            }
        }
        return "Tento předmět neznám.";
    }


    @Override
    public String getNazev() {
        return NAZEV;
    }

}