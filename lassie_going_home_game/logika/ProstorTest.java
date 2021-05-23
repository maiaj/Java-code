package logika;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*******************************************************************************
 * Testovací třída ProstorTest slouží ke komplexnímu otestování
 * třídy Prostor
 */
public class ProstorTest
{
    //== Datové atributy (statické i instancí)======================================

    //== Konstruktory a tovární metody =============================================
    //-- Testovací třída vystačí s prázdným implicitním konstruktorem ----------

    //== Příprava a úklid přípravku ================================================

    /***************************************************************************
     * Metoda se provede před spuštěním každé testovací metody. Používá se
     * k vytvoření tzv. přípravku (fixture), což jsou datové atributy (objekty),
     * s nimiž budou testovací metody pracovat.
     */
    @Before
    public void setUp() {
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každé testovací metody.
     */
    @After
    public void tearDown() {
    }

    //== Soukromé metody používané v testovacích metodách ==========================

    //== Vlastní testovací metody ==================================================

    /**
     * Testuje, zda jsou správně nastaveny průchody mezi prostory hry. Prostory
     * nemusí odpovídat vlastní hře, 
     */
    @Test
    public  void testLzeProjit() {		
        Prostor prostor1 = new Prostor("kotec", "kotec, do kterého tě zavřel farmář.", false, false, false);
        Prostor prostor2 = new Prostor("stáj", "stáj, ve které je miska s vodou, jídlo a tvůj starý obojek.", true, true, false);
        Prostor prostor3 = new Prostor("dvůr", "dvůr s jídlem.", true, true, false);
        Prostor prostor4 = new Prostor("pole", "pole s klackem.", true, true, false);
        prostor1.setPruchod(new Pruchod(true, true, prostor2));
        prostor3.setPruchod(new Pruchod(false, true, prostor4));
        prostor2.setPruchod(new Pruchod(true, true, prostor1)); // otestujeme neviditelny pruchod
        assertEquals(prostor2, prostor1.vratMoznyPruchod("stáj").getCilovyProstor());
        assertEquals(null, prostor3.vratMoznyPruchod("pole"));
        assertEquals(null, prostor2.vratMoznyPruchod("pokoj"));
    }

}
