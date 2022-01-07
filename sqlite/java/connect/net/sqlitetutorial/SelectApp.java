package net.sqlitetutorial;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 *
 * @author sqlitetutorial.net
 */
public class SelectApp {

    /**
     * Connect to the test.db database
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
     * select all rows in the warehouses table
     */
   public void selectAll(){
        String sql = "SELECT movie_name,lead_actor,lead_actress,year_of_Release,director_name FROM Movies";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("movie_name") +  "\t" + 
                                   rs.getString("lead_actor") + "\t" +
				   rs.getString("lead_actress") + "\t" +
				   rs.getInt("year_of_Release") + "\t" +
                                   rs.getString("director_name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
    

    public void getMovieName(String lead_actor){
               String sql = "SELECT movie_name "
                          + "FROM Movies WHERE lead_actor = ?";
        
        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){
            
            
            pstmt.setString(1,lead_actor);
            
            ResultSet rs  = pstmt.executeQuery();
            
            
            while (rs.next()) {
                System.out.println(rs.getString("movie_name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        SelectApp app = new SelectApp();
        app.selectAll();
	SelectApp abb = new SelectApp();
	abb.getMovieName("Akshay Kumar");
    }

}