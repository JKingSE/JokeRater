package Beans;

import Models.User;
import Validators.UserValidator;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Controller for the User model
 * @author Michael
 */
@ManagedBean(name = "userBean")
@SessionScoped

public class UserBean {
    
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
//    public String loginAttempt() {
//        if(UserValidator.login(user.getUsername(), user.getPassword())) return "home";
//        else return "index";
//    }
    
    
} // UserBean.java