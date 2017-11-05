package Models;

import java.util.List;

/**
 * Model for a JokeRater User
 * @author Michael
 */
public class User {
    
    private String username;
    private String password;
    private String favorites;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getFavorites(){ return this.favorites; }
    
    public User() {
        this.username = "";
        this.password = "";
    }
    
} // User.java