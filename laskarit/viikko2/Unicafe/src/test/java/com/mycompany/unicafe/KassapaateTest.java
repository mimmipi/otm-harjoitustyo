package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KassapaateTest {

    public KassapaateTest() {
    }
    Maksukortti kortti;
    Kassapaate paate;

    @Before
    public void setUp() {
        paate = new Kassapaate();
        kortti = new Maksukortti(1000);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void rahatOikeinAlussa() {

        assertEquals(100000, paate.kassassaRahaa());
    }

    @Test
    public void lounaatOikeinalussa() {
        assertEquals(0, paate.edullisiaLounaitaMyyty());
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void kateinenToimiiEdullisissaKunMaksuRiittävä() {
        assertEquals(260, paate.syoEdullisesti(500));
        assertEquals(100240, paate.kassassaRahaa());
        assertEquals(1, paate.edullisiaLounaitaMyyty());
    }

    @Test
    public void kateinenToimiiEdullisisssaKunMaksuEiRiitä() {
        assertEquals(100, paate.syoEdullisesti(100));
        assertEquals(100000, paate.kassassaRahaa());
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }

    @Test
    public void kateinenToimiiMaukkaissaKunMaksuRiittävä() {
        assertEquals(100, paate.syoMaukkaasti(500));
        assertEquals(100400, paate.kassassaRahaa());
        assertEquals(1, paate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void kateinenToimiiMaukkaissaKunMaksuEiRiitä() {
        assertEquals(200, paate.syoMaukkaasti(200));
        assertEquals(100000, paate.kassassaRahaa());
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void korttiToimiiEdullisissaKunMaksuRiittävä() {
        paate.syoEdullisesti(kortti);
        assertEquals(760, kortti.saldo());
        assertEquals(100000, paate.kassassaRahaa());
        assertEquals(1, paate.edullisiaLounaitaMyyty());
    }

    @Test
    public void korttiToimiiEdullisisssaKunMaksuEiRiitä() {
        kortti.otaRahaa(900);
        assertEquals(false, paate.syoEdullisesti(kortti));
        assertEquals(100000, paate.kassassaRahaa());
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }

    @Test
    public void korttiToimiiMaukkaissaKunMaksuRiittävä() {
        assertEquals(true, paate.syoMaukkaasti(kortti));
        assertEquals(600, kortti.saldo());
        assertEquals(100000, paate.kassassaRahaa());
        assertEquals(1, paate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void korttiToimiiMaukkaissaKunMaksuEiRiitä() {
        kortti.otaRahaa(900);
        assertEquals(false, paate.syoMaukkaasti(kortti));
        assertEquals(100000, paate.kassassaRahaa());
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
    }
    
    @Test 
    public void rahanLatausKortilleOnnistuu() {
        paate.lataaRahaaKortille(kortti, 1000);
        assertEquals(2000, kortti.saldo());
        assertEquals(101000, paate.kassassaRahaa());
    }
    
    @Test
    public void negatiivinenLatausKortilleEiOnnistu() {
        paate.lataaRahaaKortille(kortti, -100);
        assertEquals(1000, kortti.saldo());
        assertEquals(100000, paate.kassassaRahaa());
    }

}
