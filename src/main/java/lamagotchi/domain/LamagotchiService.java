package lamagotchi.domain;

import lamagotchi.dao.LamagotchiDao;
import lamagotchi.dao.UserDao;

/**
 * Luokka toteuttaa pelin toiminnallisuuden
 *
 * @author piikkila
 */
public class LamagotchiService {
    
    private Lamagotchi lama;
    private UserDao userdao;
    private LamagotchiDao lamaDao;
    
    public LamagotchiService(LamagotchiDao lamaDao, UserDao userDao) {
        this.lamaDao = lamaDao;
        this.userdao = userDao;
        
    }
    
    public String getName() {
        return this.lama.getName();
    }
    
    public double getAge() {
        return this.lama.getAge();
    }

    /**
     * Metodi luo uuden Lamagotchi-olion
     */
    public void createNewLama(String name) {
        this.lama = new Lamagotchi(name);
        
    }
    
    public void timePasses() {
        if (this.lama.getHappiness() > 0.0001) {
            this.lama.setHappy(this.lama.getHappiness() - 0.0001);
        }
        
        if (this.lama.getDirty() > 0.0001) {
            this.lama.setDirty(this.lama.getDirty() - 0.00005);
        }
        
        if (this.lama.getEnergy() > 0.0001) {
            this.lama.setEnergy(this.lama.getEnergy() - 0.00001);
        }
        
        if (this.lama.getHunger() > 0.0001) {
            this.lama.setHunger(this.lama.getHunger() - 0.0001);
        }
        
        this.lama.setAge(this.lama.getAge() + 0.001);
    }

    /**
     * Metodi asettaa Lamagotchin likaisuuden täydeksi eli luvuksi 1
     */
    public void washLama() {
        if (this.lama.getDirty() + 0.35 <= 1) {
            this.lama.setDirty(this.lama.getDirty() + 0.35);
        } else {
            this.lama.setDirty(1);
        }
    }

    /**
     * Metodi asettaa Lamagotchin kylläisyyden täydeksi eli luvuksi 1
     */
    public void feedLama() {
        if (this.lama.getHunger() + 0.35 <= 1) {
            this.lama.setHunger(this.lama.getHunger() + 0.35);
        } else {
            this.lama.setHunger(1);
        }
    }

    /**
     * Metodi asettaa Lamagotchin energiatason täydeksi eli luvuksi 1
     */
    public void sleepLama() {
        if (this.lama.getEnergy() + 0.35 <= 1) {
            this.lama.setEnergy(this.lama.getEnergy() + 0.35);
        } else {
            this.lama.setEnergy(1);
        }
        
    }

    /**
     * Metodi asettaa Lamagotchin iloisuuden täydeksi eli luvuksi 1
     */
    public void playWithLama() {
        if (this.lama.getHappiness() + 0.35 <= 1) {
            this.lama.setHappy(this.lama.getHappiness() + 0.35);
        } else {
            this.lama.setHappy(1);
        }
        
    }

    /**
     * Metodi palauttaa Lamagotchin onnellisuuden
     *
     * @return Lamagotchin onnellisuus
     */
    public double getHappiness() {
        return this.lama.getHappiness();
    }
    
    public double getHunger() {
        return this.lama.getHunger();
    }
    
    public double getDirty() {
        return this.lama.getDirty();
    }
    
    public double getEnergy() {
        return this.lama.getEnergy();
    }
    
    public boolean login(String username) {
        return true;
    }
    
    public boolean createNewUser(String name, String password) {
        if (userdao.findByName(name) != null) {
            return false;
        }        
        User user = new User(name, password);
        userdao.create(user);
        return true;
    }
}
