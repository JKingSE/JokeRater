package Validators;

/**
 * Validator for the Joke model
 * @author Beltrán, John, Michael
 */
public class JokeValidator {

    public static boolean submitJoke(String joke, String poster, String context) {
        return MariaDB.submitJokeQuery(joke, poster, context);
    }
    
    public static boolean saveRatings(int id, int Funniness, int Punniness, int Edginess) {
        return MariaDB.saveRatingsQuery(id, Funniness, Punniness, Edginess);
    }
    
    public static boolean saveFlagged(int id, boolean flagged) {
        return MariaDB.saveFlaggedQuery(id, flagged);
    }
} // JokeValidator.java