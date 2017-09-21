package Beans;

import Models.User;

/**
 * Controller for the User model
 * @author Michael
 */
public class UserBean {
    
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public String loginAttempt() {
        return "home";
    }
    
    
} // UserBean.java