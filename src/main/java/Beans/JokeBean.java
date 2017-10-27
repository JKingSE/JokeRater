/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;
import Models.Joke;
import Validators.JokeValidator;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
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
    @ManagedProperty(value="#{tableBean}")
    private TableBean tableBean;

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

    public TableBean getTableBean() {
        return tableBean;
    }

    public void setTableBean(TableBean tableBean) {
        this.tableBean = tableBean;
    }
    
    public String submitJokeAttempt() {
        if(JokeValidator.submitJoke(joke.getJoke(), userBean.getUser().getUsername(), joke.getContext())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Joke submitted", "PrimeFaces Rocks."));
            return "submit";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: Cannot submit joke", "Contact admin."));
            return "submit";
        }
    }
    
    public void setFlaggedStatus(){
        joke.setFlagged(!joke.isFlagged());
    }
    
    public boolean isFlagged(){
        return joke.isFlagged();
    }
    
    public void setRatings(int funniness, int edginess, int punniness){
        joke.setFunniness(funniness);
        joke.setEdginess(edginess);
        joke.setPunniness(punniness);
        joke.setOverallRating(funniness+edginess+punniness);
        saveRatingsAttempt();
    }
    
    public String saveRatingsAttempt(){
        Joke selection = tableBean.getSelection();
        boolean success = JokeValidator.saveRatings(selection.getId(), selection.getFunniness(), selection.getPunniness(), selection.getEdginess());
        if(success) {
            selection.setOverallRating((selection.getFunniness() + selection.getEdginess() + selection.getPunniness()) / 3);
            return "table.xhtml";
        }
        else    return "rate.xhtml";
    }
}
