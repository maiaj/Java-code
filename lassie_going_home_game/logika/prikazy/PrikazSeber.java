package logika.prikazy;

import logika.HerniPlan;

public class PrikazSeber implements IPrikaz {
    private static final String NAZEV = "seber";
    private HerniPlan plan;

    public PrikazSeber(HerniPlan plan) {
        this.plan = plan;
    }

    @Override
    public String provedPrikaz(String... parametry) {
          if (parametry.length == 0) {
            return "Co mám sebrat? Zadej název věci, která je v prostoru.";
        } else {
            String vecVProstoru = parametry[0];
            if (parametry.length == 1 && vecVProstoru.equals("klacek") && plan.getAktualniProstor().obsahujeVec(vecVProstoru)) {
                if (plan.getPes().isMaKlacek() == true) {
                    return "Už jeden klacek máš.";
                }
                else {
                    plan.getPes().setMaKlacek(true);
                    return "Sebral jsi klacek.";
                }
            } else if (parametry.length == 1 && vecVProstoru.equals("obojek") && plan.getAktualniProstor().obsahujeVec(vecVProstoru)) {
                if (plan.getPes().isMaObojek() == true) {
                    return "Obojek už máš.";
                }
                else {
                    plan.getPes().setMaObojek(true);
                    return "Sebral jsi obojek.";
                }          }
        }
        return "Tento předmět neznám.";
    }


    @Override
    public String getNazev() {
        return NAZEV;
    }

}