
package lamagotchi.domain;
/**
 * Luokka edustaa järjestelmän käyttäjää
 * @author piikkila
 */
public class User {
    
    private String name;
    private String password;
    
    /**
     * Metodi luo uuden käyttäjän 
     * @param name Käyttäjän nimi
     * @param password salasana
     */
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getPassword() {
        return this.password;
    }

  @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof User)) {
            return false;
        }
        
        User other = (User) obj;
        return name.equals(other.name);
}
}
