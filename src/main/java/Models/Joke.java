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
    private String poster;
    private String joke;
    private String classSection;
    private int professor; //References the professor's id who made the joke
    private boolean flagged;
    private String context;
    private int funniness;
    private int edginess;
    private int punniness;
    private int overallRating;
    private ZonedDateTime dateAdded;
    private int[] tags;

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getClassSection() {
        return classSection;
    }

    public void setClassSection(String classSection) {
        this.classSection = classSection;
    }

    public ZonedDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(ZonedDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    public int getProfessor() {
        return professor;
    }

    public void setProfessor(int professor) {
        this.professor = professor;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int getEdginess() {
        return edginess;
    }

    public void setEdginess(int edginess) {
        this.edginess = edginess;
    }

    public int getFunniness() {
        return funniness;
    }

    public void setFunniness(int funniness) {
        this.funniness = funniness;
    }

    public int getPunniness() {
        return punniness;
    }

    public void setPunniness(int punniness) {
        this.punniness = punniness;
    }

    public void setOverallRating(int overallRating){
        this.overallRating = overallRating;
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
    
    public Joke(int i, String randomJoke, String randomPoster, String randomContext, int overallRating, int funniness, int edginess, int punniness) {
        this.id = i;
        this.joke = randomJoke;
        this.poster = randomPoster;
        this.context = randomContext;
        this.classSection = "1";
        this.dateAdded = ZonedDateTime.now();
        this.professor = 1;
        this.flagged = false;
        this.edginess = edginess;
        this.funniness = funniness;
        this.punniness = punniness;
        this.overallRating = 15;
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