package beans;
import Models.Joke;
import Validators.TableValidator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
 
@ManagedBean(name = "tableBean")
@SessionScoped
public class TableBean {
    
    private List<Joke> allJokes;
    private Joke selection;
    private List<Joke> filtered;

    //***Getters & Setters***//
    public List<Joke> getAllJokes() {
        return allJokes;
    }

    public void setAllJokes(List<Joke> allJokes) {
        this.allJokes = allJokes;
    }
    
    public Joke getSelection() {
        return selection;
    }

    public void setSelection(Joke selection) {
        this.selection = selection;
    }
    
    public List<Joke> getFiltered() {
        return filtered;
    }

    public void setFiltered(List<Joke> filtered) {
        this.filtered = filtered;
    }
    
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
    
    public void update(String view) {
        setAllJokes(TableValidator.selectJokes());
    }
   

    
    
    
    
    
    
}