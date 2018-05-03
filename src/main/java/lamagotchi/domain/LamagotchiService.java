package lamagotchi.domain;
/**
 * Luokka toteuttaa pelin toiminnallisuuden
 * @author piikkila
 */
public class LamagotchiService {

    private Lamagotchi lama;

    public LamagotchiService() {

    }

    /**
     * Metodi luo uuden Lamagotchi-olion
     */
    public void createNewLama(String name) {
        this.lama = new Lamagotchi(name);

    }

//    public void timePasses() {
//        if (this.hungry > 0) {
//            this.hungry--;
//        }
//        if (this.happy > 0) {
//            this.happy--;
//        }
//        if (this.dirty > 0) {
//            this.dirty--;
//        }
//        if (this.energy > 0) {
//            this.energy--;
//        }
//        this.age++;
//    }
    /**
     * Metodi asettaa Lamagotchin likaisuuden täydeksi eli luvuksi 1
     */
    public void washLama() {
        this.lama.setDirty(1);
    }

    /**
     * Metodi asettaa Lamagotchin kylläisyyden täydeksi eli luvuksi 1
     */
    public void feedLama() {
        this.lama.setHungry(1);
    }

    /**
     * Metodi asettaa Lamagotchin energiatason täydeksi eli luvuksi 1
     */
    public void sleepLama() {
        this.lama.setEnergy(1);
    }

    /**
     * Metodi asettaa Lamagotchin iloisuuden täydeksi eli luvuksi 1
     */
    public void playWithLama() {
        this.lama.setHappy(10);
    }
/**
 * Metodi palauttaa Lamagotchin onnellisuuden 
 * @return Lamagotchin onnellisuus
 */
    public double getHappiness() {
        return this.lama.getHappiness();
    }

}
