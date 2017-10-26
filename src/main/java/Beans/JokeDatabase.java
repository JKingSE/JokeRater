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
    }
    
    public List<Joke> createJokes(int size) {
        List<Joke> randomJokes = new ArrayList();
        for(int i = 0; i < size; i++) {
            randomJokes.add(new Joke(i, getRandomJoke(), getRandomPoster(), getRandomContext()));
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