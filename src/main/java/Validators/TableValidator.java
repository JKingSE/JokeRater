package Validators;

import Models.Joke;
import java.util.List;

/**
 *
 * @author Beltrán
 */
public class TableValidator {
    
    public static List<Joke> selectJokes() {
        return MariaDB.selectJokesQuery();
    }
    
} // TableValidator.java