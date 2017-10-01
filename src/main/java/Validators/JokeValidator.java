/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validators;

/**
 *
 * @author Beltrán
 */
public class JokeValidator {

    public static boolean submitJoke (String joke, int id, String dateAdded) {
            return MariaDB.jokeQuery(joke, id, dateAdded);
        }
}
