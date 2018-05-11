package lamagotchi.dao;

import lamagotchi.domain.User;
import java.util.List;

/**
 * Luokka toimii käyttäjien tietoja tallentavan luokan interfacena
 *
 * @author piikkila
 */
public interface UserDao {

    User create(User user);

    User findByName(String name);

    List<User> getAll();
}
