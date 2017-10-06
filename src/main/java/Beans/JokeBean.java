/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;
import Models.Joke;
import Validators.JokeValidator;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
/**
 *
 * @author John King
 */
@ManagedBean(name = "jokeBean")
@RequestScoped
public class JokeBean {
    
    private Joke joke = new Joke();
    @ManagedProperty(value="#{userBean}")
    private UserBean userBean;

    public Joke getJoke() {
        return joke;
    }

    public void setJoke(Joke joke) {
        this.joke = joke;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }
    
    
    
    public String submitJokeAttempt() {
        if(JokeValidator.submitJoke(joke.getJoke(), userBean.getUser().getUsername(), joke.getContext())) {
            return "submit";
        } else {
            return "submit";
        }
    }
    
    public void setRatings(int funniness, int punniness, int edginess){
        joke.setFunniness(funniness);
        joke.setPunniness(punniness);
        joke.setEdginess(edginess);
        joke.setOverallRating();
        saveRatingsAttempt();
    }
    
    public void saveRatingsAttempt(){
        JokeValidator.saveRatings(joke.getId(), joke.getFunniness(), joke.getPunniness(), joke.getEdginess());
    }
}
