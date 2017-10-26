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
 
@ManagedBean(name = "tableBean")
@SessionScoped
public class TableBean implements Serializable{
    
    private List<Joke> jokes;
    
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

    public JokeDatabase getJokeDatabase() {
        return jokeDatabase;
    }

    public void setJokeDatabase(JokeDatabase jokeDatabase) {
        this.jokeDatabase = jokeDatabase;
    }
    
    
    
//    private List<Joke> allJokes;
//    private Joke selection;
//    private List<Joke> filtered;

    //***Getters & Setters***//
//    public List<Joke> getAllJokes() {
//        return allJokes;
//    }
//
//    public void setAllJokes(List<Joke> allJokes) {
//        this.allJokes = allJokes;
//    }
//    
//    public Joke getSelection() {
//        return selection;
//    }
//
//    public void setSelection(Joke selection) {
//        this.selection = selection;
//    }
//    
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
    
//    public void dummyvalues() {
//       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//       CharSequence cseq = "1989-10-10 10:10:10";
//       
//       List<Joke> dummylist = new ArrayList();
//       for(int i=1; i<10; i++) {
//           Joke joke = new Joke();
//           joke.setId(i);
//           joke.setJoke("test");
//           joke.setContext("test");
//           joke.setEdginess(5);
//           joke.setPunniness(5);
//           joke.setFunniness(5);
//           joke.setDateAdded(ZonedDateTime.parse(cseq, dtf));
//           dummylist.add(joke);
//       }
//       
//       this.allJokes = dummylist;
//       this.filtered = dummylist;
//    }
       
} // TableBean.java