# after running mysql, input the following: source C:/PATH_TO_SQL_FILE


DROP DATABASE IF EXISTS JokeRater;
CREATE DATABASE JokeRater;
USE JokeRater;
CREATE TABLE IF NOT EXISTS Users (Username VARCHAR(30) NOT NULL PRIMARY KEY, Password CHAR(32) NOT NULL, Favorite VARCHAR(300), Flagged VARCHAR(300));
CREATE TABLE IF NOT EXISTS Professors (ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, Name VARCHAR(100) NOT NULL);
CREATE TABLE IF NOT EXISTS Tags (ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, TagName VARCHAR(30));
CREATE TABLE IF NOT EXISTS Jokes (ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, Poster VARCHAR (100), Joke VARCHAR(900) NOT NULL, Class VARCHAR(20), Professor INT, Flagged BOOLEAN, Context VARCHAR(50), Funniness INT, Edginess INT, Punniness INT, Overall INT, TimeAdded TIMESTAMP);


INSERT INTO Users (Username, Password, Favorite, Flagged) VALUES ("root","77e24e94edf5b6e83257d657bfa990e2","1,","2,");
INSERT INTO Users (Username, Password, Favorite) VALUES ("admin", "4405b1214a555eb925d912f7151718a7","3,1,");

INSERT INTO Professors (Name) VALUES ("Martinez");
INSERT INTO Professors (Name) VALUES ("Malachowsky");

INSERT INTO Tags (TagName) VALUES ("SWEN-250");
INSERT INTO Tags (TagName) VALUES ("PUN");
INSERT INTO Tags (TagName) VALUES ("SO BAD");

INSERT INTO Jokes (Poster, Joke, Class, Professor, Flagged, Context, Funniness, Edginess, Punniness, Overall) VALUES ("Admin","What do genders and the Twin Towers have in common? There used to be two but now it's a touchy subject", "SWEN-250", 0, 1, "NONE", 5, 5, 0, 4);
INSERT INTO Jokes (Poster, Joke, Class, Professor, Flagged, Context, Funniness, Edginess, Punniness, Overall) VALUES ("Admin","I don't know I need to master regular rexpressions to operate this battleship. Well, it's Perl Harbor here.", "SWEN-250", 1, 1, "NONE", 2, 4, 3, 3);
INSERT INTO Jokes (Poster, Joke, Class, Professor, Flagged, Context, Funniness, Edginess, Punniness, Overall) VALUES ("root","What screams Insecure? http.", "SWEN-250", 0, 0, "NONE", 5, 0, 0, 5);
INSERT INTO Jokes (Poster, Joke, Class, Professor, Flagged, Context, Funniness, Edginess, Punniness, Overall) VALUES ("root","What's a pirate's favorite letter? R? No, the pirate's first love be the C", "SWEN-256", 1, 0, "NONE", 3, 3, 4, 3);
INSERT INTO Jokes (Poster, Joke, Class, Professor, Flagged, Context, Funniness, Edginess, Punniness, Overall) VALUES ("root","How many naraccists does it take to screw in a lightbulb? One, then the world revolves around them", "SWEN-256", 1, 0, "Presenter staring at teacher", 3, 0, 0, 2);
INSERT INTO Jokes (Poster, Joke, Class, Professor, Flagged, Context, Funniness, Edginess, Punniness, Overall) VALUES ("root","What's a pirate's favorite letter? R? No, the pirate's first love be the C", "SWEN-256", 1, 0, "NONE", 3, 3, 4, 3);
INSERT INTO Jokes (Poster, Joke, Class, Professor, Flagged, Context, Funniness, Edginess, Punniness, Overall) VALUES ("root","The other day I ran into my ex. Then I put it in reverse and ran over her again", "SWEN-256", 0, 0, "Ex-Wife Jokes", 4, 5, 1, 4);


