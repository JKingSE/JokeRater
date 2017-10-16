/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import java.time.ZonedDateTime;
/**
 * Model for a joke
 * @author John King
 */
public class Joke {
    
    private int id;
    private String joke;
    private String poster;
    private String classSection;
    private ZonedDateTime dateAdded;
    private int professor; //References the professor's id who made the joke
    private boolean flagged;
    private String context;
    private int edginess;
    private int funniness;
    private int punniness;
    private int overallRating;
    private int[] tags;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    public void setStringAdded(ZonedDateTime dateAdded){
        this.dateAdded = dateAdded;
    }
    public ZonedDateTime getDateAdded(){
        return dateAdded;
    }
    public void setDateAdded(ZonedDateTime dateAdded) {
        this.dateAdded = dateAdded;
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
    
    public void setOverallRating(){
        this.overallRating = Math.round(funniness+punniness+edginess)/3;
    }
    public int getOverallRating(){
        return overallRating;
    }
    
    public Joke() {
        this.id = -1;
        this.joke = "";
        this.poster = "";
        this.classSection = "";
        this.dateAdded = ZonedDateTime.now();
        this.professor = -1; //References the professor's id who made the joke
        this.flagged = false;
        this.context = "";
        this.edginess = -1;
        this.funniness = -1;
        this.punniness = -1;
        this.overallRating = -1;
        this.tags = new int[0];
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
    
} // Joke.java