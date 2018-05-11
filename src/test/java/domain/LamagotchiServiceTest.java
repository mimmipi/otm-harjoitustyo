package domain;


import lamagotchi.dao.FileUserDao;
import lamagotchi.dao.UserDao;
import lamagotchi.domain.LamagotchiService;
import lamagotchi.domain.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LamagotchiServiceTest {

    LamagotchiService lama;
    UserDao userdao;

    @Before
    public void setUp() {
        this.userdao = new FileUserDao("file");
        this.lama = new LamagotchiService(userdao);
        this.lama.createNewLama("lama");
    }

    @Test
    public void createNewLamaWorks() {
        this.lama.createNewLama("Los lama");
        assertEquals("Los lama", this.lama.getName());
    }

    @Test
    public void timePassesAgesRight() {
        int age = (int) this.lama.getAge();
        assertEquals(0, age);
        for (int i = 0; i < 10001; i++) {
            this.lama.timePasses();
        }
        age = (int) this.lama.getAge();

        assertEquals(10, age);
    }

    @Test
    public void timePassesSetsHungerRight() {
        int hunger = (int) this.lama.getHunger();
        assertEquals(1, hunger);

        for (int i = 0; i < 100; i++) {
            this.lama.timePasses();
        }
        hunger = (int) this.lama.getHunger();
        assertEquals(0, hunger);
    }

    @Test
    public void feedingLamaWorks() {
        int hunger = (int) this.lama.getHunger();
        assertEquals(1, hunger);
        for (int i = 0; i < 100; i++) {
            this.lama.timePasses();
        }
        hunger = (int) this.lama.getHunger();
        assertEquals(0, hunger);

        this.lama.feedLama();
        this.lama.feedLama();
        this.lama.feedLama();

        hunger = (int) this.lama.getHunger();
        assertEquals(1, hunger);
    }

    @Test
    public void sleepingLamaWorks() {
        int energy = (int) this.lama.getEnergy();
        assertEquals(1, energy);
        for (int i = 0; i < 100; i++) {
            this.lama.timePasses();
        }
        energy = (int) this.lama.getEnergy();
        assertEquals(0, energy);

        this.lama.sleepLama();
        this.lama.sleepLama();
        this.lama.sleepLama();

        energy = (int) this.lama.getEnergy();
        assertEquals(1, energy);
    }

    @Test
    public void playingWithLamaWorks() {
        int happiness = (int) this.lama.getHappiness();
        assertEquals(1, happiness);
        for (int i = 0; i < 100; i++) {
            this.lama.timePasses();
        }
        happiness = (int) this.lama.getHappiness();
        assertEquals(0, happiness);

        this.lama.playWithLama();
        this.lama.playWithLama();
        this.lama.playWithLama();

        happiness = (int) this.lama.getHappiness();
        assertEquals(1, happiness);
    }

    @Test
    public void washingLamaWorks() {
        int cleanliness = (int) this.lama.getDirty();
        assertEquals(1, cleanliness);
        for (int i = 0; i < 100; i++) {
            this.lama.timePasses();
        }
        cleanliness = (int) this.lama.getDirty();
        assertEquals(0, cleanliness);

        this.lama.washLama();
        this.lama.washLama();
        this.lama.washLama();

        cleanliness = (int) this.lama.getDirty();
        assertEquals(1, cleanliness);
    }

    @Test
    public void creatingNewUserWorks() {
        User user = new User("John", "fishes");
        this.lama.createNewUser("John", "fishes");
        assertEquals(user, userdao.findByName("John"));
    }

}
