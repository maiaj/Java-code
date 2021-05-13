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
        Prostor kotec = new Prostor("kotec", "kotec, do kterého tě zavřel farmář. Podlaha kotce je z hlíny.", false, false, false);
        Prostor staj = new Prostor("stáj", "stáj, ve které je miska s vodou, jídlo a tvůj starý obojek. U dveří stáje stojí farmářka.", true, true, false);
        Prostor dvur = new Prostor("dvůr", "dvůr, na kterém je voda a jídlo. Dvůr je ohraničený plotem, za který je slyšet hluk cesty.", true, true, false);
        Prostor cesta = new Prostor("cesta", "cesta vde dvěma směry.", false, false, false);
        Prostor parkoviste = new Prostor("parkoviště", "parkoviště plné aut. U jedenoho z nich stojí člověk.", false, false, false);
        Prostor les1 = new Prostor("les", "hluboký les s pramenem vody.", true, true, true);
        Prostor les2 = new Prostor("háj", "malý lesík s pár stromy.", false, true, true);
        Prostor pole1 = new Prostor("pole", "suché, neúrodné pole, na kterém se dá najít klacek.", false, false, false);
        Prostor pole2 = new Prostor("louka", "suché, neúrodné pole, na kterém se dá najít klacek.", false, false, false);
        Prostor pole3 = new Prostor("políčko", "suché, neúrodné pole, na kterém se dá najít klacek.", false, false, false);
        Prostor hospoda = new Prostor("hospoda", "hospoda u lesa. Za barem stojí hospodská.", false, false, false);
        Prostor staveniste = new Prostor("staveniště", "staveniště, na kterém hoří. Přes kouř nevidíš co je dál.", false, false, false);
        Prostor domov = new Prostor("domov", "domov, jsi v cíli, čekají tě zde prémiové psí dobroty, vychlazená voda, měkký pelíšek a hlavně zasloužené vítězství.", false, false, false);


        // přiřazují se průchody mezi prostory (sousedící prostory)
        kotec.setPruchod(new Pruchod(false, true, staj));

        dvur.setPruchod(new Pruchod(true, false, parkoviste));
        dvur.setPruchod(new Pruchod(true, false, hospoda));
        dvur.setPruchod(new Pruchod(true, false, staveniste));


        staj.setPruchod(new Pruchod(true, false, kotec));
        staj.setPruchod(new Pruchod(false, false, dvur));
        dvur.setPruchod(new Pruchod(true, false, staj));
        dvur.setPruchod(new Pruchod(false, true, cesta));
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
        staveniste.setPruchod(new Pruchod(true, false, pole3));
        staveniste.setPruchod(new Pruchod(false, false, domov));

        // vkládají se do prostoru věci
        staj.vlozVec(new Vec("obojek", true));
        pole1.vlozVec(new Vec("klacek", true));
        pole2.vlozVec(new Vec("klacek", true));
        pole3.vlozVec(new Vec("klacek", true));

        staveniste.vlozVec(new Vec( "ohen", false));

        // vkládají se do prostoru postavy
        staj.setPostava(new Postava("farmarka", "farmářka", true, true, false, false));
        parkoviste.setPostava(new Postava("ridic", "řidič", true, false, false, true));
        domov.setPostava(new Postava("ridic", "řidič", true, false, false, true));
        hospoda.setPostava(new Postava("hospodska", "hospodská", true, false, true, false));


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
