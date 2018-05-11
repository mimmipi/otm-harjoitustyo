package lamagotchi.domain;

import lamagotchi.dao.UserDao;

/**
 * Luokka toteuttaa pelin toiminnallisuuden
 *
 * @author piikkila
 */
public class LamagotchiService {

    private Lamagotchi lama;
    private UserDao userdao;
    private User loggedIn;

    /**
     * Konstruktori luo uuden instanssin luokasta ja alustaa uudet Daot, joiden
     * avulla tiedot tallennetaan
     *
     * @param lamaDao tallettaa Lamagotchit
     * @param userDao tallettaa käyttäjätiedot
     */
    public LamagotchiService(UserDao userDao) {

        this.userdao = userDao;
    }

    /**
     * Metodi kirjaa käyttäjän sisään ja palauttaa true jos kirjautuminen
     * onnistuu
     */
    public boolean login(String name, String password) {
        User user = userdao.findByName(name);
        if (user == null) {
            return false;
        } else if (!user.getPassword().equals(password)) {
            return false;
        }
        loggedIn = user;
        return true;
    }

    public User getLoggedUser() {
        return loggedIn;
    }

    /**
     * Metodi palauttaa Lamagotchin nimen
     *
     * @return Lamagotchin nimi
     */
    public String getName() {
        return this.lama.getName();
    }

    /**
     * Metodi palauttaa Lamagotchin iän
     *
     * @return Lamagotchin ikä
     */
    public double getAge() {
        return this.lama.getAge();
    }

    /**
     * Metodi luo uuden Lamagotchi-olion
     */
    public void createNewLama(String name) {
        this.lama = new Lamagotchi(name, loggedIn);

    }

    /**
     * Metodi kuluttaa pelin aikaa eli vähentää onnellisuutta, puhtautta,
     * energisyyttä ja nälkää sekä vanhentaa Lamagotchia.
     */
    public void timePasses() {
        if (this.lama.getHappiness() > 0.0001) {
            this.lama.setHappy(this.lama.getHappiness() - 0.0001);
        }

        if (this.lama.getDirty() > 0.0001) {
            this.lama.setDirty(this.lama.getDirty() - 0.0005);
        }

        if (this.lama.getEnergy() > 0.0001) {
            this.lama.setEnergy(this.lama.getEnergy() - 0.0001);
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

    /**
     * Metodi palauttaa Lamagotchin kylläisyyden
     *
     * @return Lamagotchin kylläisyys
     */
    public double getHunger() {
        return this.lama.getHunger();
    }

    /**
     * Metodi palauttaa Lamagotchin puhtauden
     *
     * @return Lamagotchin puhtaus
     */
    public double getDirty() {
        return this.lama.getDirty();
    }

    /**
     * Metodi palauttaa Lamagotchin energisyyden
     *
     * @return Lamagotchin energisyys
     */
    public double getEnergy() {
        return this.lama.getEnergy();
    }

    /**
     * Metodi luo uuden käyttäjän peliin
     *
     * @param käyttäjänimi
     * @param salasana
     * @return palauttaa true jos käyttäjän luonti onnistuu, false jos
     * epäonnistuu
     */
    public boolean createNewUser(String name, String password) {
        if (userdao.findByName(name) != null) {
            return false;
        }
        User user = new User(name, password);
        userdao.create(user);
        return true;
    }
}
