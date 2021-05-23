package logika;

public class Vec {
  private final String nazev;
  private final boolean jdeSebrat;

  public Vec(String nazev, boolean jdeSebrat) {
    this.nazev = nazev;
    this.jdeSebrat = jdeSebrat;
  }

  public String getNazev() {
    return this.nazev;
  }

  public boolean jdeSebrat() {
    return this.jdeSebrat;
  }
}
