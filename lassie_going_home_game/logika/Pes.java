package logika;

import java.util.HashSet;
import java.util.Set;

public class Pes {
  public static final int MAX_JIDLO = 10;
  public static final int MAX_VODA = 10;
  public static final int DEFAULT_JIDLO = 5;
  public static final int DEFAULT_VODA = 4;
  private final Set<String> sebraneVeci = new HashSet<>();
  private int jidlo;
  private int voda;

  public Pes() {
    this(DEFAULT_JIDLO, DEFAULT_VODA);
  }

  public Pes(int jidlo, int voda) {
    this.jidlo = jidlo;
    this.voda = voda;
  }

  public boolean maKlacek() {
    return this.sebraneVeci.contains("klacek");
  }

  public boolean maObojek() {
    return this.sebraneVeci.contains("obojek");
  }

  public int getJidlo() {
    return jidlo;
  }

  public int getVoda() {
    return voda;
  }

  public void pridejJidlo(int jednotka) {
    jidlo = Math.min(jidlo + jednotka, MAX_JIDLO);
  }

  public void uberJidlo() {
    if (jidlo <= 0) {
      return;
    }
    jidlo--;
  }

  public void pridejVodu(int jednotka) {
    voda = Math.min(voda + jednotka, MAX_VODA);
  }

  public void uberVodu(int jednotka) {
    if (voda >= jednotka) {
      voda = voda - jednotka;
    } else {
      voda = 0;
    }
  }

  public boolean muzeJestePrijmoutJidlo() {
    return jidlo < MAX_JIDLO;
  }

  public boolean muzeJestePrijmoutVodu() {
    return voda < MAX_VODA;
  }

  public boolean muzeHasit() {
    return voda >= this.getVodaPotrebnaKHaseni();
  }

  public void hasit() {
    this.uberVodu(this.getVodaPotrebnaKHaseni());
  }

  private int getVodaPotrebnaKHaseni() {
    return this.maKlacek() ? 5 : 10;
  }

  public boolean seberVec(String nazevVeci) {
    return this.sebraneVeci.add(nazevVeci);
  }

  public void resetujJidloAVodu() {
    jidlo = DEFAULT_JIDLO;
    voda = DEFAULT_VODA;
  }
}
