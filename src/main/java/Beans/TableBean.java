package Beans;

import Models.Joke;
import Validators.TableValidator;
import java.io.Serializable;
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
    
    @PostConstruct
    public void init() {
//        jokes = jokeDatabase.createJokes(10);
        jokes = TableValidator.selectJokes();
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