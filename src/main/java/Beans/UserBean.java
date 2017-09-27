package Beans;

import Models.User;
import Validators.UserValidator;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Controller for the User model
 * @author Michael
 */
@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean implements Serializable {
    
    // UserBean Variable(s)
    private static final long serialVersionUID = 1L;
    private User user = new User();

    //***Getters & Setters***//
    /**
     * Accessor for User
     * @return      User    - the session user
     */
    public User getUser() {
        return user;
    }
    /**
     * Mutator for User
     * @param       user    A user object
     */
    public void setUser(User user) {
        this.user = user;
    }
    
    //***Controller Method(s)***//
    public String registerAttempt() {
        if(UserValidator.register(user.getUsername(), user.getPassword()))
            return "index";
        else
            return "registration";
    }
    
    public String loginAttempt() {
        if(UserValidator.login(user.getUsername(), user.getPassword())) 
            return "home";
        else 
            return "index";
    }
    
} // UserBean.java