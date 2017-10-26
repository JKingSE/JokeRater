package Beans;

import Models.Joke;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Michael
 */

@ManagedBean (name = "jokeDatabase")
@SessionScoped
public class JokeDatabase {
    
    private final static String[] jokes;
    
    private final static String[] posters;
    
    private final static String[] contexts;
    
    private final static int[] overallRatings;
    private final static int[] edginess;
    private final static int[] funniness;
    private final static int[] punniness;
    
    static {
        jokes = new String[10];
        jokes[0] = "I can say that, I'm an adjunct";
        jokes[1] = "You could probably make a potato Turing complete";
        jokes[2] = "It's not like you work at McDonalds and suddenly they ask you to make guns";
        jokes[3] = "Regex... God's gift to programmers";
        jokes[4] = "It will never get that big";
        jokes[5] = "If you have to work in C, God forbid...";
        jokes[6] = "You can almost see the Java code sitting underneath it";
        jokes[7] = "Pharaohs love it, slaves love it, nobody is going to lose coverage";
        jokes[8] = "GDD, you're going to be software engineers eventually anyways, why not start that way";
        jokes[9] = "I'm edging but in real life";
        
        
        posters = new String[10];
        posters[0] = "Lutz";
        posters[1] = "Meneely";
        posters[2] = "Malachowsky";
        posters[3] = "Beltran";
        posters[4] = "Gilmour";
        posters[5] = "JFK III";
        posters[6] = "Colin";
        posters[7] = "Ian";
        posters[8] = "Herring";
        posters[9] = "Hawker";
        
        
        contexts = new String[10];
        contexts[0] = "Talking smack about Sweden";
        contexts[1] = "Talking about CS Theory";
        contexts[2] = "A student was suprised to be making military software on co-op";
        contexts[3] = "Hearing about 250 practicals";
        contexts[4] = "Grad school";
        contexts[5] = "Alloy sucks";
        contexts[6] = "Mishearing a conversation";
        contexts[7] = "Telling us how to get jobs";
        contexts[8] = "First day of performance in engineering seminar";
        contexts[9] = "Talking about Semaphores";
        
        overallRatings = new int[10];
        overallRatings[0] = 1;
        overallRatings[1] = 2;
        overallRatings[2] = 3;
        overallRatings[3] = 4;
        overallRatings[4] = 5;
        overallRatings[5] = 1;
        overallRatings[6] = 2;
        overallRatings[7] = 3;
        overallRatings[8] = 4;
        overallRatings[9] = 5;
        
        funniness = new int[10];
        funniness[0] = 1;
        funniness[1] = 2;
        funniness[2] = 3;
        funniness[3] = 4;
        funniness[4] = 5;
        funniness[5] = 1;
        funniness[6] = 2;
        funniness[7] = 3;
        funniness[8] = 4;
        funniness[9] = 5;
        
        edginess = new int[10];
        edginess[0] = 1;
        edginess[1] = 2;
        edginess[2] = 3;
        edginess[3] = 4;
        edginess[4] = 5;
        edginess[5] = 1;
        edginess[6] = 2;
        edginess[7] = 3;
        edginess[8] = 4;
        edginess[9] = 5;
        
        punniness = new int[10];
        punniness[0] = 1;
        punniness[1] = 2;
        punniness[2] = 3;
        punniness[3] = 4;
        punniness[4] = 5;
        punniness[5] = 1;
        punniness[6] = 2;
        punniness[7] = 3;
        punniness[8] = 4;
        punniness[9] = 5;
    }
    
    public List<Joke> createJokes(int size) {
        List<Joke> randomJokes = new ArrayList();
        for(int i = 0; i < size; i++) {
            randomJokes.add(new Joke(i, getRandomJoke(), getRandomPoster(), getRandomContext(), getRandomRating(), getRandomFunniness(), getRandomEdginess(), getRandomPunniness()));
        }
        return randomJokes;
    }
    
    private String getRandomJoke() {
        return jokes[(int) (Math.random() * 10)];
    }
    
    private String getRandomPoster() {
        return posters[(int) (Math.random() * 10)];
    }
    
    private String getRandomContext() {
        return contexts[(int) (Math.random() * 10)];
    }
    
    private int getRandomRating() {
        return overallRatings[(int) (Math.random() * 10)];
    }
    
    private int getRandomFunniness() {
        return funniness[(int) (Math.random() * 10)];
    }
    
    private int getRandomEdginess() {
        return edginess[(int) (Math.random() * 10)];
    }
    
    private int getRandomPunniness() {
        return punniness[(int) (Math.random() * 10)];
    }
    
    public List<String> getJokes() {
        return Arrays.asList(jokes);
    }
    
    public List<String> getPosters() {
        return Arrays.asList(posters);
    }
    
    public List<String> getContexts() {
        return Arrays.asList(contexts);
    }
    
} // JokeDatabase.java