package lamagotchi.dao;

import lamagotchi.domain.User;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Luokka tallentaa käyttäjien tiedot tiedostoon ja hakee niitä tiedostosta
 *
 * @author piikkila
 */
public class FileUserDao implements UserDao {

    private List<User> users;
    private String file;

    public FileUserDao(String file)  {
        this.users = new ArrayList<>();
        this.file = file;
        load();
    }  
        private void load() {
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                User user = new User(parts[0], parts[1]);
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodi tallentaa tiedostoon käyttäjien nimet ja salasanat
     *
     */
    private void save() throws Exception {
        try (FileWriter writer = new FileWriter(new File(file))) {
            for (User user : users) {
                writer.write(user.getName() + ";" + user.getPassword() + "\n");
            }
        }
    }

    /**
     * Metodi palauttaa listan kaikista käyttäjistä
     *
     * @return lista käyttäjistä
     */
    @Override
    public List<User> getAll() {
        return users;
    }

    /**
     * Metodin avulla voi hakea käyttäjien joukosta nimen perusteella
     *
     * @param name Haettava käyttäjä
     * @return löydetty käyttäjä
     */
    public User findByName(String name) {
        return users.stream()
                .filter(u -> u.getName()
                .equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User create(User user) {
        users.add(user);
        try {
            save();
        } catch (Exception ex) {
            Logger.getLogger(FileUserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

}
