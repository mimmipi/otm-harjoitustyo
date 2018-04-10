
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
       assertEquals("lama",lama.getName());
      
     }
     
     @Test
     public void ikaAluksiOikein() {
         assertEquals(0.0, 0, lama.getAge());
     }
     
     @Test
     public void ajanKuluminenKasvattaaIkaaOikein() {
         for (int i=0; i<100; i++) {
             lama.timePasses();
             
             assertEquals(10, 10, lama.getAge());
         }
     }
     
     @Test 
     public void syottaminenToimii() {
         assertEquals(10,lama.getHunger());
         lama.timePasses();
         lama.timePasses();
         assertEquals(8, lama.getHunger());
         lama.feedLama();
         assertEquals(10, lama.getHunger());
     }
 }
