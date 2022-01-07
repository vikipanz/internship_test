package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author sqlitetutorial.net
 */
public class InsertApp {

    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://Assignment/sqlite/db/test.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * Insert a new row into the warehouses table
     *
     * @param name
     * @param capacity
     */
    public void insert(String movie_name,String lead_actor,String lead_actress,Integer year_of_Release,String director_name) {
        String sql = "INSERT INTO Movies(movie_name,lead_actor,lead_actress,year_of_Release,director_name) VALUES(?,?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, movie_name);
            pstmt.setString(2, lead_actor);
            pstmt.setString(3, lead_actress);
            pstmt.setInt(4, year_of_Release);
	    pstmt.setString(5, director_name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        InsertApp app = new InsertApp();
        // insert three new rows
        app.insert("3-Idiots","Amir Khan","Kareena Kapoor",2009,"Rajkumar Hirani");
        app.insert("Golmaal","Ajay Devgan","Rimi Sen",2006,"Rohit Shetty");
        app.insert("Hera Pheri","Akshay Kumar","Tabu",2000,"Priyadarshan");
        app.insert("Dhol","Tushar Kapoor","Tanushree Dutta",2007,"Priyadarshan");
        
    }

}