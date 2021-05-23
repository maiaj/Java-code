package logika.prikazy;

public interface IPrikaz {

    /**
     * Metoda pro provedení příkazu ve hře.
     * Počet parametrů je závislý na konkrétním příkazu,
     * např. příkazy konec a napoveda nemají parametry
     * příkazy jdi, seber, polož mají jeden parametr
     * příkaz pouzij může mít dva parametry.
     *
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     */
    String provedPrikaz(String... parametry);

    /**
     * Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *
     * @return nazev prikazu
     */
    String getNazev();

}
