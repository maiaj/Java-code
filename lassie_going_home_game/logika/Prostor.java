package logika;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Trida Prostor - popisuje jednotlivé prostory (místnosti) hry
 *
 * <p>Tato třída je součástí jednoduché textové hry.
 *
 * <p>"Prostor" reprezentuje jedno místo (místnost, prostor, ..) ve scénáři hry. Prostor může mít
 * sousední prostory připojené přes východy. Pro každý východ si prostor ukládá odkaz na sousedící
 * prostor.
 */
public class Prostor {

  private final String nazev;
  private final String popis;
  private final Set<Pruchod> pruchody;
  private final Map<String, Vec> veci;
  private Boolean jeTamVoda;
  private Boolean jeTamJidlo;
  private Boolean jeHrabatelny;
  private Postava postava;
  private boolean jeOznaceny;

  /**
   * Vytvoření prostoru se zadaným popisem, např. "kuchyň", "hala", "trávník před domem"
   *
   * @param nazev nazev prostoru, jednoznačný identifikátor, jedno slovo nebo víceslovný název bez
   *     mezer.
   * @param popis Popis prostoru.
   */
  public Prostor(
      String nazev, String popis, Boolean jeTamVoda, Boolean jeTamJidlo, Boolean jeHrabatelny) {
    this.nazev = nazev;
    this.popis = popis;
    this.jeTamJidlo = jeTamJidlo;
    this.jeTamVoda = jeTamVoda;
    this.jeHrabatelny = jeHrabatelny;
    pruchody = new HashSet<>();
    veci = new HashMap<>();
  }

  public Boolean getJeTamVoda() {
    return jeTamVoda;
  }

  public void setJeTamVoda(Boolean jeTamVoda) {
    this.jeTamVoda = jeTamVoda;
  }

  public Boolean getJeTamJidlo() {
    return jeTamJidlo;
  }

  public void setJeTamJidlo(Boolean jeTamJidlo) {
    this.jeTamJidlo = jeTamJidlo;
  }

  public Boolean getJeHrabatelny() {
    return jeHrabatelny;
  }

  public void setJeHrabatelny(Boolean jeHrabatelny) {
    this.jeHrabatelny = jeHrabatelny;
  }

  public Postava getPostava() {
    return postava;
  }

  public void setPostava(Postava postava) {
    this.postava = postava;
  }

  /**
   * Definuje východ z prostoru (sousední/vedlejsi prostor). Vzhledem k tomu, že je použit Set pro
   * uložení východů, může být sousední prostor uveden pouze jednou (tj. nelze mít dvoje dveře do
   * stejné sousední místnosti). Druhé zadání stejného prostoru tiše přepíše předchozí zadání
   * (neobjeví se žádné chybové hlášení). Lze zadat též cestu ze do sebe sama.
   *
   * @param vedlejsi prostor, který sousedi s aktualnim prostorem.
   */
  public void setPruchod(Pruchod vedlejsi) {
    pruchody.add(vedlejsi);
  }

  /**
   * Metoda equals pro porovnání dvou prostorů. Překrývá se metoda equals ze třídy Object. Dva
   * prostory jsou shodné, pokud mají stejný název. Tato metoda je důležitá z hlediska správného
   * fungování seznamu východů (Set).
   */
  @Override
  public boolean equals(Object o) {
    // porovnáváme zda se nejedná o dva odkazy na stejnou instanci
    if (this == o) {
      return true;
    }
    // porovnáváme jakého typu je parametr
    if (!(o instanceof Prostor)) {
      return false; // pokud parametr není typu Prostor, vrátíme false
    }
    // přetypujeme parametr na typ Prostor
    Prostor druhy = (Prostor) o;

    // metoda equals třídy java.util.Objects porovná hodnoty obou názvů.
    // Vrátí true pro stejné názvy a i v případě, že jsou oba názvy null,
    // jinak vrátí false.

    return java.util.Objects.equals(this.nazev, druhy.nazev);
  }

  /**
   * metoda hashCode vraci ciselny identifikator instance, ktery se pouziva pro optimalizaci
   * ukladani v dynamickych datovych strukturach. Pri prekryti metody equals je potreba prekryt i
   * metodu hashCode. Podrobny popis pravidel pro vytvareni metody hashCode je u metody hashCode ve
   * tride Object
   */
  @Override
  public int hashCode() {
    int vysledek = 3;
    int hashNazvu = java.util.Objects.hashCode(this.nazev);
    vysledek = 37 * vysledek + hashNazvu;
    return vysledek;
  }

  public String getNazev() {
    return nazev;
  }

  public String getPopis() {
    return this.popis;
  }

  /**
   * Vrací "dlouhý" popis prostoru, který může vypadat následovně: Jsi v mistnosti/prostoru vstupni
   * hala budovy VSE na Jiznim meste. vychody: chodba bufet ucebna
   *
   * @return Dlouhý popis prostoru
   */
  public String dlouhyPopis() {
    return "Jsi v prostoru " + popis + ".\n" + popisVychodu();
  }

  /**
   * Vrací textový řetězec, který popisuje sousední východy, například: "vychody: hala ".
   *
   * @return Popis východů - názvů sousedních prostorů
   */
  public String popisVychodu() {
    String vracenyText = "Východy:";
    Collection<Pruchod> viditelnePruchody = getViditelnePruchody();
    if (viditelnePruchody.isEmpty()) {
      vracenyText += " Nejsou zde žádné viditelné východy.";
    } else {
      for (Pruchod sousedni : viditelnePruchody) {
        vracenyText += " " + sousedni.getCilovyProstor().getNazev();
      }
    }
    return vracenyText;
  }

  /**
   * Vrací prostor, který sousedí s aktuálním prostorem a jehož název je zadán jako parametr. Pokud
   * prostor s udaným jménem nesousedí s aktuálním prostorem, vrací se hodnota null.
   *
   * @param nazevSouseda Jméno sousedního prostoru (východu)
   * @return Prostor, který se nachází za příslušným východem, nebo hodnota null, pokud prostor
   *     zadaného jména není sousedem.
   */
  public Pruchod vratMoznyPruchod(String nazevSouseda) {
    return getViditelnePruchody().stream()
        .filter(sousedni -> sousedni.getCilovyProstor().getNazev().equals(nazevSouseda))
        .findFirst()
        .orElse(null);
  }

  /**
   * Vrací kolekci obsahující prostory, se kterými tento prostor sousedí. Takto získaný seznam
   * sousedních prostor nelze upravovat (přidávat, odebírat východy) protože z hlediska správného
   * návrhu je to plně záležitostí třídy Prostor.
   *
   * @return Nemodifikovatelná kolekce prostorů (východů), se kterými tento prostor sousedí.
   */
  public Collection<Pruchod> getViditelnePruchody() {
    return Collections.unmodifiableCollection(
        pruchody.stream().filter(pruchod -> pruchod.isJeViditelny()).collect(Collectors.toList()));
  }

  public Collection<Pruchod> getTajnePruchody() {
    return Collections.unmodifiableCollection(
        pruchody.stream().filter(pruchod -> !pruchod.isJeViditelny()).collect(Collectors.toList()));
  }

  public boolean obsahujeVec(String nazev) {
    return veci.containsKey(nazev);
  }

  public boolean obsahujeSebratelouVec(String nazev) {
    return veci.containsKey(nazev) && veci.get(nazev).isJdeSebrat();
  }

  public void vlozVec(Vec vec) {
    veci.put(vec.getNazev(), vec);
  }

  public void odeberVec(String nazev) {
    veci.remove(nazev);
  }

  public boolean isJeOznaceny() {
    return jeOznaceny;
  }

  public void setJeOznaceny(boolean jeOznaceny) {
    this.jeOznaceny = jeOznaceny;
  }
}
