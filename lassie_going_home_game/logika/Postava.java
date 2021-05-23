package logika;

public class Postava {
  private final String popis;
  private final boolean fungujiPsiOci;
  private final SchopnostPostavy schopnost;

  public Postava(String popis, Boolean fungujiPsiOci, SchopnostPostavy schopnost) {
    this.popis = popis;
    this.fungujiPsiOci = fungujiPsiOci;
    this.schopnost = schopnost;
  }

  public String getPopis() {
    return this.popis;
  }

  public Boolean getFungujiPsiOci() {
    return this.fungujiPsiOci;
  }

  public SchopnostPostavy getSchopnost() {
    return this.schopnost;
  }
}
