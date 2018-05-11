
import lamagotchi.domain.Lamagotchi;
import lamagotchi.domain.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LamagotchiTest {

    Lamagotchi lama;
    User user;
    
    @Before
    public void setUp() {
        user = new User("test", "user");
        lama = new Lamagotchi("lama", user);       
    }

    @Test
    public void konstruktoriAsettaaMittaritOikein() {
        String tiedot = lama.printInformation();

        assertEquals("Lamagotchi: lama\n" + "Ikä: 0.0\n" + "Virkeys: 1.0\n" + "Onnellisuus: 1.0\n" + "Hygienia: 1.0\n" + "Kylläisyys: 1.0\n", tiedot);
    }

    @Test
    public void konstruktoriNimiOikein() {
        assertEquals("lama", lama.getName());

    }

    @Test
    public void ikaAluksiOikein() {
        assertEquals(0.0, 0, lama.getAge());
    }



}
