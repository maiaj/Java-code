package logika;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
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
  private final Set<Pruchod> pruchody = new HashSet<>();
  private final Map<String, Vec> veci = new HashMap<>();
  private Boolean maVodu;
  private Boolean maJidlo;
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
    maJidlo = jeTamJidlo;
    maVodu = jeTamVoda;
    this.jeHrabatelny = jeHrabatelny;
  }

  public Boolean getMaVodu() {
    return this.maVodu;
  }

  public void setMaVodu(Boolean maVodu) {
    this.maVodu = maVodu;
  }

  public Boolean getMaJidlo() {
    return this.maJidlo;
  }

  public void setMaJidlo(Boolean maJidlo) {
    this.maJidlo = maJidlo;
  }

  public Boolean getJeHrabatelny() {
    return this.jeHrabatelny;
  }

  public void setJeHrabatelny(Boolean jeHrabatelny) {
    this.jeHrabatelny = jeHrabatelny;
  }

  public Postava getPostava() {
    return this.postava;
  }

  public void setPostava(Postava postava) {
    this.postava = postava;
  }

  public void setPruchod(Pruchod vedlejsi) {
    this.pruchody.add(vedlejsi);
  }

  public String getNazev() {
    return nazev;
  }

  public String getPopis() {
    return popis;
  }

  /**
   * Vrací "dlouhý" popis prostoru, který může vypadat následovně: Jsi v mistnosti/prostoru vstupni
   * hala budovy VSE na Jiznim meste. vychody: chodba bufet ucebna
   *
   * @return Dlouhý popis prostoru
   */
  public String dlouhyPopis() {
    return "Jsi v prostoru " + this.popis + ".\n" + this.popisVychodu();
  }

  /**
   * Vrací textový řetězec, který popisuje sousední východy, například: "vychody: hala ".
   *
   * @return Popis východů - názvů sousedních prostorů
   */
  public String popisVychodu() {
    Collection<Pruchod> viditelnePruchody = this.getViditelnePruchody();
    if (viditelnePruchody.isEmpty()) {
      return "Nejsou zde žádné viditelné východy.";
    }

    String vychody =
        viditelnePruchody.stream()
            .map(pruchod -> pruchod.getCilovyProstor().getNazev())
            .collect(Collectors.joining(" "));
    return "Východy: " + vychody;
  }

  /**
   * Vrací prostor, který sousedí s aktuálním prostorem a jehož název je zadán jako parametr. Pokud
   * prostor s udaným jménem nesousedí s aktuálním prostorem, vrací se hodnota null.
   *
   * @param nazevSouseda Jméno sousedního prostoru (východu)
   * @return Prostor, který se nachází za příslušným východem, nebo hodnota null, pokud prostor
   *     zadaného jména není sousedem.
   */
  public Optional<Pruchod> vratMoznyPruchod(String nazevSouseda) {
    return this.getViditelnePruchody().stream()
        .filter(sousedni -> sousedni.getCilovyProstor().getNazev().equals(nazevSouseda))
        .findFirst();
  }

  /**
   * Vrací kolekci obsahující prostory, se kterými tento prostor sousedí. Takto získaný seznam
   * sousedních prostor nelze upravovat (přidávat, odebírat východy) protože z hlediska správného
   * návrhu je to plně záležitostí třídy Prostor.
   *
   * @return Nemodifikovatelná kolekce prostorů (východů), se kterými tento prostor sousedí.
   */
  public Collection<Pruchod> getViditelnePruchody() {
    return this.pruchody.stream().filter(Pruchod::jeViditelny).collect(Collectors.toUnmodifiableList());
  }

  public Collection<Pruchod> getTajnePruchody() {
    return this.pruchody.stream().filter(pruchod -> !pruchod.jeViditelny()).collect(Collectors.toUnmodifiableList());
  }

  public boolean obsahujeVec(String nazev) {
    return this.veci.containsKey(nazev);
  }

  public boolean obsahujeSebratelouVec(String nazev) {
    return this.veci.containsKey(nazev) && this.veci.get(nazev).jdeSebrat();
  }

  public void vlozVec(Vec vec) {
    this.veci.put(vec.getNazev(), vec);
  }

  public void odeberVec(String nazev) {
    this.veci.remove(nazev);
  }

  public boolean jeOznaceny() {
    return this.jeOznaceny;
  }

  public void setJeOznaceny(boolean jeOznaceny) {
    this.jeOznaceny = jeOznaceny;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Prostor)) {
      return false; // pokud parametr není typu Prostor, vrátíme false
    }
    Prostor druhy = (Prostor) o;
    return java.util.Objects.equals(nazev, druhy.nazev);
  }

  @Override
  public int hashCode() {
    int vysledek = 3;
    int hashNazvu = java.util.Objects.hashCode(nazev);
    vysledek = 37 * vysledek + hashNazvu;
    return vysledek;
  }
}
