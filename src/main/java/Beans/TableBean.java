package Beans;

import Models.Joke;
import Models.User;
import Validators.TableValidator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
 
@ManagedBean(name = "tableBean")
@SessionScoped
public class TableBean implements Serializable{
    
    private List<Joke> jokes;
    private Joke selection;
    
    @ManagedProperty(value = "#{jokeDatabase}")
    private JokeDatabase jokeDatabase;
    @ManagedProperty(value = "#{userBean}")
    private UserBean userBean;
    
    
    public void setUserBean(UserBean userbean) {
            this.userBean = userbean;
    }
    
    @PostConstruct
    public void init() {
//        jokes = jokeDatabase.createJokes(10);
        List<Joke> allJokes = TableValidator.selectJokes();
        List<Joke> favoritedJokes = new ArrayList();
        List<Joke> flaggedJokes = new ArrayList();
        List<Joke> regularJokes = new ArrayList();
        
        User user = userBean.getUser();
        
        List<String> favList = Arrays.asList(user.getFavorites().split(","));
        List<Integer> favInts = new ArrayList();
        
        for(String fav: favList) favInts.add(Integer.parseInt(fav));
        
        for(Joke aJoke: allJokes){
            if(aJoke.isFlagged()) flaggedJokes.add(aJoke);
            else if(favList.contains(aJoke.getId())) favoritedJokes.add(aJoke);
            else regularJokes.add(aJoke);
        }
        
        jokes.addAll(favoritedJokes);
        jokes.addAll(regularJokes);
        jokes.addAll(flaggedJokes);
        
        
    }
    
    public List<Joke> getJokes() {
        return this.jokes;
    }
    
    public void setJokes(List<Joke> jokes) {
        this.jokes = jokes;
    }

    public Joke getSelection() {
        return selection;
    }

    public void setSelection(Joke selection) {
        this.selection = selection;
    }
    
    public JokeDatabase getJokeDatabase() {
        return jokeDatabase;
    }

    public void setJokeDatabase(JokeDatabase jokeDatabase) {
        this.jokeDatabase = jokeDatabase;
    }
    
    
    

//    private List<Joke> filtered;

//    public List<Joke> getFiltered() {
//        return filtered;
//    }
//
//    public void setFiltered(List<Joke> filtered) {
//        this.filtered = filtered;
//    }
    
    //***Controller Method(s)***//
    /**
     * Listener for data table row selection
     * @param       event       - A row select event
     */
    public void rowSelect(SelectEvent event) {
        int id = ((Joke) event.getObject()).getId();
        FacesMessage msg = new FacesMessage("Joke Selected", Integer.toString(id));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void rowUnselect(UnselectEvent event) {
        int id = ((Joke) event.getObject()).getId();
        FacesMessage msg = new FacesMessage("Joke Unselected", Integer.toString(id));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
//    public void update(String view) {
//        this.allJokes = TableValidator.selectJokes();
//        this.filtered = resetFilter(view);
//    }
    
//    public List<Joke> resetFilter(String view) {
//        if(view.equals("All")) {
//            return allJokes;
//        } 
//        // else if ....
//        else {
//            return allJokes; // the catch-all
//        }
//    }
    
       
} // TableBean.java