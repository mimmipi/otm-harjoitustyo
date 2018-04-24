
import domain.Lamagotchi;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LamagotchiTest {

    Lamagotchi lama;

    @Before
    public void setUp() {
        lama = new Lamagotchi("lama");
    }

//
//     @Test
//     public void konstruktoriAsettaaMittaritOikein() {
//     Lamagotchi lama = new Lamagotchi("lama");
//     String tiedot = lama.printInformation();
//     
//     assertEquals("Lamagotchi: lama\n" + "Ikä: 0.0\n" + "Virkeys: 10\n" + "Onnellisuus: 10\n" + "Hygienia: 10\n" + "Energia: 10", tiedot);
//     }
//     
    @Test
    public void konstruktoriNimiOikein() {
        assertEquals("lama", lama.getName());

    }

    @Test
    public void ikaAluksiOikein() {
        assertEquals(0.0, 0, lama.getAge());
    }

    @Test
    public void ajanKuluminenKasvattaaIkaaOikein() {
        for (int i = 0; i < 100; i++) {
            lama.timePasses();

            assertEquals(10, 10, lama.getAge());
        }
    }

    @Test
    public void syottaminenToimii() {
        assertEquals(10, lama.getHunger());
        lama.timePasses();
        lama.timePasses();
        assertEquals(8, lama.getHunger());
        lama.feedLama();
        assertEquals(10, lama.getHunger());
    }

    @Test
    public void nukkuminenToimii() {
        assertEquals(10, lama.getEnergy());
        lama.timePasses();
        lama.timePasses();
        assertEquals(8, lama.getEnergy());
        lama.sleepLama();
        assertEquals(10, lama.getEnergy());
    }

    @Test
    public void leikkiminenToimii() {
        assertEquals(10, lama.getHappiness());
        lama.timePasses();
        lama.timePasses();
        lama.timePasses();
        lama.timePasses();
        lama.timePasses();
        assertEquals(5, lama.getHappiness());
        lama.playWithLama();
        assertEquals(10, lama.getHappiness());
    }

    @Test
    public void peseminenToimii() {
        assertEquals(10, lama.getDirty());
        lama.timePasses();
        lama.timePasses();
        lama.timePasses();
        lama.timePasses();
        lama.timePasses();
        assertEquals(5, lama.getDirty());
        lama.washLama();
        assertEquals(10, lama.getDirty());
    }
    
    @Test 
    public void tiedotTulostuuAlussaOikein() {
        assertEquals("Lamagotchi: " + "lama" + "\nIkä: " + 0.0 + "\nVirkeys: " + 10 + "\nOnnellisuus: " + 10
                + "\nHygienia: " + 10 + "\nEnergia: " + 10 + "\n", lama.printInformation());
    }

}
