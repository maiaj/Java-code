package logika;

/**
 * Tato třída inicializuje prvky ze kterých se hra skládá: vytváří všechny prostory, propojuje je
 * vzájemně pomocí východů a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 */
public class HerniPlan {

  private final Pes pes;
  private Prostor aktualniProstor;
  private Prostor pocatecniProstor;
  private Prostor konecnyProstor;

  public HerniPlan() {
    this(new Pes());
  }

  /*
   * Druhý konstruktor vyrvořen pro účely testování, aby bylo možné předávat custom vytvořeného psa.
   */
  public HerniPlan(Pes pes) {
    this.zalozProstoryHry();
    this.pes = pes;
  }

  /*
   * Vytváří jednotlivé prostory a propojuje je pomocí východů.
   */
  public void zalozProstoryHry() {
    // vytvářejí se jednotlivé prostory
    Prostor kotec =
        new Prostor(
            "kotec",
            "kotec, do kterého tě zavřel farmář. Podlaha kotce je z hlíny.",
            false,
            false,
            false);
    Prostor staj =
        new Prostor(
            "stáj",
            "stáj, ve které je miska s vodou, jídlo a tvůj starý obojek. U dveří stáje stojí farmářka.",
            true,
            true,
            false);
    Prostor dvur =
        new Prostor(
            "dvůr",
            "dvůr, na kterém je voda a jídlo. Dvůr je ohraničený plotem, za který je slyšet hluk cesty.",
            true,
            true,
            false);
    Prostor cesta = new Prostor("cesta", "cesta vede dvěma směry.", false, false, false);
    Prostor parkoviste =
        new Prostor(
            "parkoviště",
            "parkoviště plné aut. U jedenoho z nich stojí člověk.",
            false,
            false,
            false);
    Prostor les1 = new Prostor("les", "hluboký les s pramenem vody.", true, false, true);
    Prostor les2 = new Prostor("háj", "malý lesík s pár stromy.", false, false, true);
    Prostor pole1 =
        new Prostor(
            "pole", "suché, neúrodné pole, na kterém se dá najít klacek.", false, false, false);
    Prostor pole2 =
        new Prostor(
            "louka", "suché, neúrodné pole, na kterém se dá najít klacek.", false, false, false);
    Prostor pole3 =
        new Prostor(
            "suché_pole",
            "suché, neúrodné pole, na kterém se dá najít klacek.",
            false,
            false,
            false);
    Prostor hospoda =
        new Prostor("hospoda", "hospoda u lesa. Za barem stojí hospodská.", false, false, false);
    Prostor staveniste =
        new Prostor(
            "staveniště",
            "staveniště, na kterém hoří. Přes kouř nevidíš co je dál.",
            false,
            false,
            false);
    Prostor domov =
        new Prostor(
            "domov",
            "Jsi v cíli! Čekají tě zde prémiové psí dobroty, vychlazená voda, měkký pelíšek a hlavně zasloužené vítězství.",
            false,
            false,
            false);

    // přiřazují se průchody mezi prostory (sousedící prostory)
    kotec.setPruchod(new Pruchod(false, true, staj));
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

    staveniste.vlozVec(new Vec("ohen", false));

    // vkládají se do prostoru postavy
    staj.setPostava(new Postava("farmářka", true, SchopnostPostavy.ODTAJNUJE_VYCHOD));
    parkoviste.setPostava(new Postava("řidič", true, SchopnostPostavy.ZAVEZE_DO_CILE));
    hospoda.setPostava(new Postava("hospodská", true, SchopnostPostavy.DAVA_JIDLO_A_VODU));

    // určuje se aktuální, počáteční a konecny prostor
    this.aktualniProstor = kotec;
    this.pocatecniProstor = kotec; // hra začíná v kotci
    this.konecnyProstor = domov; // hra končí doma
  }

  public Prostor getAktualniProstor() {
    return this.aktualniProstor;
  }

  public void setAktualniProstor(Prostor prostor) {
    aktualniProstor = prostor;
  }

  public Prostor getPocatecniProstor() {
    return this.pocatecniProstor;
  }

  public Prostor getKonecnyProstor() {
    return this.konecnyProstor;
  }

  public Pes getPes() {
    return this.pes;
  }

  public void resetujHerniPlan() {
    this.zalozProstoryHry();
  }
}
