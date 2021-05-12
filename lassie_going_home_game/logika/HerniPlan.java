package logika;

/**
 * Tato třída inicializuje prvky ze kterých se hra skládá:
 * vytváří všechny prostory,
 * propojuje je vzájemně pomocí východů
 * a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 */
public class HerniPlan {

    private Prostor aktualniProstor;
    private Prostor pocatecniProstor;
    private Prostor konecnyProstor;
    private Pes pes;

    /**
     * Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     * Jako výchozí aktuální prostor nastaví halu.
     */
    public HerniPlan() {

        zalozProstoryHry();
        pes = new Pes(3, 2, false, false);
    }

    /**
     * Vytváří jednotlivé prostory a propojuje je pomocí východů.
     * Jako výchozí aktuální prostor nastaví domeček.
     */
    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory
        Prostor kotec = new Prostor("kotec", "kotec, do kterého tě zavřel farmář. Podlaha kotce je z hlíny.", false, false, false, false);
        Prostor staj = new Prostor("stáj", "stáj, ve které je miska s vodou, jídlo a tvůj starý obojek. U dveří stáje stojí farmářka.", true, true, false, true);
        Prostor dvur = new Prostor("dvůr", "dvůr, na kterém je voda a jídlo. Dvůr je ohraničený plotem, kolem kterého se prochází kočka.", true, true, false, false);
        Prostor cesta = new Prostor("cesta", "cesta.", false, false, false, false);
        Prostor parkoviste = new Prostor("parkoviště", "parkoviště. U jedenoho z aut stojí člověk.", false, false, false, true);
        Prostor les1 = new Prostor("les", "hluboký les s pramenem vody", true, true, true, false);
        Prostor les2 = new Prostor("les", "malý lesík s pár stromy", false, true, true, false);
        Prostor pole1 = new Prostor("pole", "suché, neúrodné pole, na kterém se dá najít klacek.", false, false, false, false);
        Prostor pole2 = new Prostor("pole", "suché, neúrodné pole, na kterém se dá najít klacek.", false, false, false, false);
        Prostor pole3 = new Prostor("pole", "suché, neúrodné pole, na kterém se dá najít klacek.", false, false, false, false);
        Prostor hospoda = new Prostor("hospoda", "hospoda u lesa. Před vstupem je značka “Psům vstup zakázán”.", false, false, false, true);
        Prostor staveniste = new Prostor("staveniště", "staveniště, na kterém hoří.", false, false, false, false);
        Prostor domov = new Prostor("domov", "domov, jsi v cíli, čekají tě zde prémiové psí dobroty, vychlazená voda, měkký pelíšek a hlavně zasloužené vítězství.", false, false, false, false);


        // přiřazují se průchody mezi prostory (sousedící prostory)
        kotec.setTajnyPruchod(new Pruchod(false, true, staj));
        staj.setPruchod(new Pruchod(true, false, kotec));
        staj.setTajnyPruchod(new Pruchod(false, false, dvur));
        dvur.setPruchod(new Pruchod(true, false, staj));
        dvur.setTajnyPruchod(new Pruchod(false, true, cesta));
        cesta.setPruchod(new Pruchod(true, false, dvur));
        cesta.setPruchod(new Pruchod(true, true, les1));
        cesta.setPruchod(new Pruchod(true, true, parkoviste));
        parkoviste.setPruchod(new Pruchod(true, false, pole1));
        parkoviste.setPruchod(new Pruchod(true, false, les2));
        parkoviste.setPruchod(new Pruchod(true, false, les1));
        parkoviste.setPruchod(new Pruchod(true, false, cesta));
        pole1.setPruchod(new Pruchod(true, false, parkoviste));
        pole1.setPruchod(new Pruchod(true, false, les2));
        les2.setPruchod(new Pruchod(true, false, pole1));
        les2.setPruchod(new Pruchod(true, false, parkoviste));
        les1.setPruchod(new Pruchod(true, false, cesta));
        les1.setPruchod(new Pruchod(true, false, pole2));
        les1.setPruchod(new Pruchod(true, false, hospoda));
        les1.setPruchod(new Pruchod(true, false, pole3));
        pole2.setPruchod(new Pruchod(true, false, les1));
        pole2.setPruchod(new Pruchod(true, false, hospoda));
        pole3.setPruchod(new Pruchod(true, false, les1));
        pole3.setPruchod(new Pruchod(true, false, hospoda));
        pole3.setPruchod(new Pruchod(true, false, staveniste));
        hospoda.setPruchod(new Pruchod(true, false, pole2));
        hospoda.setPruchod(new Pruchod(true, false, les1));
        hospoda.setPruchod(new Pruchod(true, false, pole3));
        staveniste.setTajnyPruchod(new Pruchod(false, false, domov));

        // vkládají se do prostoru věci
        staj.vlozVec(new Vec("obojek", false));
        pole1.vlozVec(new Vec("klacek", false));
        pole2.vlozVec(new Vec("klacek", false));
        pole3.vlozVec(new Vec("klacek", false));


        staveniste.vlozVec(new Vec("ohen", true));

        // vkládají se do prostoru postavy
        staj.setPostava(new Postava("farmarka", "farmářka", true, true, false, false));
        dvur.setPostava(new Postava("kocka", "kočka", false, true, false, false));
        parkoviste.setPostava(new Postava("ridic", "řidič", true, true, false, false));
        hospoda.setPostava(new Postava("hospodska", "hospodská", true, true, false, false));


        // určuje se aktuální a počáteční prostor
        aktualniProstor = kotec;
        pocatecniProstor = kotec;  // hra začíná v kotci
        konecnyProstor = domov; //hra končí doma
    }

    /**
     * Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     * @return aktuální prostor
     */

    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }

    public Prostor getPocatecniProstor() {

        return pocatecniProstor;
    }

    public Prostor getKonecnyProstor() {
        return konecnyProstor;
    }

    /**
     * Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     * @param prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
        aktualniProstor = prostor;
    }

    public Pes getPes() {
        return pes;
    }
}
