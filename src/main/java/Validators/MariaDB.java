package Validators;

import Models.Joke;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * All Database queries flow through this class
 * @author Michael
 */
public class MariaDB {
    
    //***Values to be read from the config file***//
    private static String address;
    private static String port;
    private static String database;
    private static String username;
    private static String password;
    private static String joke;
    private static int id;
    private static boolean initialized = false;

    //***Getters & Setters***//
    public static String getAddress() {
        return address;
    }

    public static void setAddress(String address) {
        MariaDB.address = address;
    }

    public static String getPort() {
        return port;
    }

    public static void setPort(String port) {
        MariaDB.port = port;
    }

    public static String getDatabase() {
        return database;
    }

    public static void setDatabase(String database) {
        MariaDB.database = database;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        MariaDB.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        MariaDB.password = password;
    }
    
    //***Initialization***//
    public static boolean isInitialized() {
        return initialized;
    }

    public static void setInitialized(boolean initialized) {
        MariaDB.initialized = initialized;
    }
    
    public static void init() {
       // Ensures that init() is only executed once
        if(!initialized){
            // Initialize Properties & InputStream variables
            Properties prop = new Properties();
            InputStream input = null;

            try {   // Read the file
                String filename = "config.properties";
                input = MariaDB.class.getClassLoader().getResourceAsStream(filename);
                
                if(input == null){
                    System.out.println("Unable to find: " + filename);
                    return;
                }
                
                prop.load(input);
                setAddress(prop.getProperty("mysqlAddress"));
                setPort(prop.getProperty("mysqlPort"));
                setDatabase(prop.getProperty("dbName"));
                setUsername(prop.getProperty("dbUser"));
                setPassword(prop.getProperty("dbPass"));
                setInitialized(true);
            }   // end of try
            catch(IOException ex) {
                ex.printStackTrace();
            }   // end of catch
            finally { // Close the InputStream
                if(input != null) {
                    try {
                        input.close();
                    }
                    catch(IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }   // end of finally
        } 
    }
    
    
    //***Database Queries***//
    public static Connection connect(){
        init(); // Ensure class variables are set before attempting any connection
        Connection conn = null;
        // Build the driver string
        String driver = "jdbc:mariadb://";
        driver += getAddress() + ":";
        driver += getPort() + "/";
        driver += getDatabase();
        try {
            // you need to place the JDBC driver in WAR's /WEB-INF/lib and perform
            //      Class.forName("com.example.jdbc.Driver");
            // in your code before the first DriverManager#getConnection()
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(driver, getUsername(), getPassword());
        }   // end of try
        catch(SQLException | ClassNotFoundException ex ) {
            Logger.getLogger(MariaDB.class.getName()).log(Level.SEVERE, null, ex);
        }   // end of catch
        finally {
            return conn;
        }   // end of finally
    }
    public static boolean registerQuery(String username, String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = connect();
            // Pre-compile a SQL Statement to check DB for user info
                // Attributes: Username, Password
                // Table: users
            String query = "INSERT INTO Users (Username, Password) VALUES (?, ?)";
            // ps throws SQL exception if database access error occurs
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            return ps.executeUpdate() > 0;
        }   // end of try
        catch (SQLException ex) {
            Logger.getLogger(MariaDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }   // end of catch
        finally {
            closeResource(ps);
            closeResource(conn);
        }   // end of finally
    }
    public static boolean loginQuery(String username, String password){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = connect();
            // Pre-compile a SQL Statement to check DB for user info
            ps = conn.prepareStatement("SELECT Username, Password from Users where Username= ? and Password= ?");
            ps.setString(1, username);
            ps.setString(2, password);
            // store result set from query
            rs = ps.executeQuery();
            // if TRUE, userinfo has been found
            return rs.next();
        }   // end of try
        catch (SQLException ex) {
           Logger.getLogger(MariaDB.class.getName()).log(Level.SEVERE, null, ex);
           return false;
        }   // end of catch  
        finally {
            closeResource(rs);
            closeResource(ps);
            closeResource(conn);
        }   // end of finally
    }
    public static boolean submitJokeQuery(String joke, String poster, String context) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = connect();
            String query = "INSERT INTO Jokes (poster, joke, context) VALUES (?, ?, ?)";
            // ps throws SQL exception if database access error occurs
            ps = conn.prepareStatement(query);
            ps.setString(1, poster);
            ps.setString(2, joke);
            ps.setString(3, context);
            return ps.executeUpdate() > 0;
        }   // end of try
        catch (SQLException ex) {
            Logger.getLogger(MariaDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }   // end of catch
        finally {
            closeResource(ps);
            closeResource(conn);
        }   // end of finally
    }
    public static List<Joke> selectJokesQuery(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = connect();
            // Pre-compile a SQL Statement to check DB for user info
            ps = conn.prepareStatement("SELECT * FROM Jokes");
            rs = ps.executeQuery();
            return rs2jokelist(rs);
        }   // end of try
        catch (SQLException ex) {
           Logger.getLogger(MariaDB.class.getName()).log(Level.SEVERE, null, ex);
           return new ArrayList();
        }   // end of catch  
        finally {
            closeResource(rs);
            closeResource(ps);
            closeResource(conn);
        }   // end of finally
    }
    public static boolean saveRatingsQuery(int id, int Funniness, int Punniness, int Edginess) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = connect();
            String query = "UPDATE Jokes SET Funniness = ?, Punniness = ?, Edginess = ? WHERE ID = ?)";
            // ps throws SQL exception if database access error occurs
            ps = conn.prepareStatement(query);
            ps.setInt(1, Funniness);
            ps.setInt(2, Punniness);
            ps.setInt(3, Edginess);
            ps.setInt(4, id);
            return ps.executeUpdate() > 0;
        }   // end of try
        catch (SQLException ex) {
            Logger.getLogger(MariaDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }   // end of catch
        finally {
            closeResource(ps);
            closeResource(conn);
        }   // end of finally
    }
    
    //***Close Resources***//
    /**
     * Release the database resource
     * @param       resource        A database resource
     */
    private static void closeResource(Connection resource) {
        if (resource != null) {
            try {
                resource.close();
            } catch (SQLException e) { /* do nothing */ }
        }
    }
    /**
     * Release the database resource
     * @param       resource        A database resource
     */
    private static void closeResource(PreparedStatement resource) {
        if (resource != null) {
            try {
                resource.close();
            } catch (SQLException e) { /* do nothing */ }
        }
    }
    /**
     * Release the database resource
     * @param       resource        A database resource
     */
    private static void closeResource(ResultSet resource) {
        if (resource != null) {
            try {
                resource.close();
            } catch (SQLException e) { /* do nothing */ }
        }
    }
    
    //***Conversion Methods***//
    private static List<Joke> rs2jokelist(ResultSet rs) throws SQLException {
        List<Joke> jokes = new ArrayList();
        while(rs.next()) {
            Joke joke = new Joke();
            // ID - int
            joke.setId(rs.getInt(1));
            // Poster - varchar
            joke.setPoster(rs.getString(2));
            // Joke - varchar
            joke.setJoke(rs.getString(3));
            // Context - varchar
            joke.setContext(rs.getString(4));
            // Funniness - int
            joke.setFunniness(rs.getInt(5));
            // Edginess - int
            joke.setEdginess(rs.getInt(6));
            // Punniness - int
            joke.setPunniness(rs.getInt(7));
            // TimeAdded - timestamp
            joke.setDateAdded(ts2zdt(rs.getTimestamp(8)));
            jokes.add(joke);
        }
        return jokes;
    }
    private static ZonedDateTime ts2zdt(Timestamp ts) {
        return ZonedDateTime.ofInstant(ts.toInstant(), ZoneId.of("EST"));
    }
    
} // MariaDB.java