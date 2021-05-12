package logika.prikazy;

import logika.HerniPlan;
import logika.Prostor;
import logika.Pruchod;

/**
 * Třída PrikazJdi implementuje pro hru příkaz jdi.
 */
public class PrikazJdi implements IPrikaz {
    private static final String NAZEV = "jdi";
    private HerniPlan plan;

    /**
     * Konstruktor třídy
     *
     * @param plan herní plán, ve kterém se bude ve hře "chodit"
     */
    public PrikazJdi(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     * Provádí příkaz "jdi". Zkouší se vyjít do zadaného prostoru. Pokud prostor
     * existuje, vstoupí se do nového prostoru. Pokud zadaný sousední prostor
     * (východ) není, vypíše se chybové hlášení.
     *
     * @param parametry - jako  parametr obsahuje jméno prostoru (východu),
     *                  do kterého se má jít.
     * @return zpráva, kterou vypíše hra hráči
     */
    @Override
    public String provedPrikaz(String... parametry) {
        if (plan.getPes().zjistiStav("jidlo") == 0) {
            return "Nemáš dost jídla. Najez se nebo zaštěkej a vrátíš se do kotce.";
        } else {
            if (parametry.length == 0) {
                // pokud chybí druhé slovo (sousední prostor), tak ....
                return "Kam mám jít? Musíš zadat jméno východu";
            }

            String smer = parametry[0];

            // zkoušíme přejít do sousedního prostoru
            Pruchod moznyPruchod = plan.getAktualniProstor().vratMoznyPruchod(smer); // TODO: oszetrzic jak gdosi napisze prostor kiery nieegzystuje
            Prostor sousedniProstor = moznyPruchod.getCilovyProstor();

            if (sousedniProstor == null) {
                return "Tam se odsud jít nedá!";
            } else {
                plan.setAktualniProstor(sousedniProstor);
                plan.getPes().uberJidlo();
                return sousedniProstor.dlouhyPopis();
            }
        }
    }

    /**
     * Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *
     * @ return nazev prikazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }

}
