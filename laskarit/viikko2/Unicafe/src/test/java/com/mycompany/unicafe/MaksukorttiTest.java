package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti != null);
    }

    @Test
    public void saldoAlussaOikein() {

        assertEquals("saldo: 0.10", kortti.toString());
    }

    @Test
    public void rahanLatausKasvattaaSaldoaOikein() {
        kortti.lataaRahaa(990);

        assertEquals("saldo: 10.0", kortti.toString());
    }

    @Test
    public void rahanOttaminenToimii() {
        kortti.lataaRahaa(990);
        kortti.otaRahaa(500);

        assertTrue(kortti.saldo() == 500);
    }

    @Test
    public void saldoEiMuutuJosEiTarpeeksiRahaa() {
        kortti.otaRahaa(500);

        assertEquals("saldo: 0.10", kortti.toString());
    }

}
