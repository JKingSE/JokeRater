/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import java.util.Date;
/**
 *
 * @author John King
 */
public class Joke {
    
    private String joke;
    private String poster;
    private String classSection;
    private Date dateAdded;
    private int professor; //References the professor's id who made the joke
    private boolean flagged;
    private String context;
    private int edginess;
    private int funniness;
    private int punniness;
    private int overallRating;
    private int[] tags;
    
    public Joke(){
        
    }
    
    public void save(){
        //Call this to save to the database
    }
    
    public void setJoke(String joke){
        this.joke = joke;
    }
    public String getJoke(){
        return joke;
    }
    
    public void setPoster(String poster){
        this.poster = poster;
    }
    public String getPoster(){
        return poster;
    }
    
    public void setClassSection(String classSection){
        this.classSection = classSection;
    }
    public String getClassSection(){
        return classSection;
    }
    
    public void setStringAdded(Date dateAdded){
        this.dateAdded = dateAdded;
    }
    public Date getDateAdded(){
        return dateAdded;
    }
    
    public void setProfessor(int professor){
        this.professor = professor;
    }
    public int getProfessor(){
        return professor;
    }
    
    public void setFlagged(boolean flagged){
        this.flagged = flagged;
    }
    public boolean isFlagged(){
        return flagged;
    }
    
    public void setContext(String context){
        this.context = context;
    }
    public String getContext(){
        return context;
    }
    
    public void setEdginess(int edginess){
        this.edginess = edginess;
    }
    public int getEdginess(){
        return edginess;
    }
    
    public void setFunniness(int funniness){
        this.funniness = funniness;
    }
    public int getFunniness(){
        return funniness;
    }
    
    public void setPunniness(int punniness){
        this.punniness = punniness;
    }
    public int getPunniness(){
        return punniness;
    }
    
    public void setOverallRating(int overallRating){
        this.overallRating = overallRating;
    }
    public int getOverallRating(){
        return overallRating;
    }
    
    public void setTags(int[] tags){
        int count = 0;
        for(int tag : tags){
            this.tags[count] = tag;
            count++;
        }
    }
    public int[] getTags(){
        return tags;
    }
}
