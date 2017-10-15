package beans;
import Validators.JokeValidator;
import Validators.TableValidator;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
 
@ManagedBean(name = "tableBean")
@SessionScoped
public class TableBean {
    private String joke, context;
// insert getter setter here
//public ArrayList<TableBean> getJokes() {
//}
}