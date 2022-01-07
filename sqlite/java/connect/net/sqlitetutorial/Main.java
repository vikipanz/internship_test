package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://Assignment/sqlite/db/test.db";
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE Movies (\n"
                + "	movie_name TEXT NOT NULL,\n"
                + "	lead_actor TEXT NOT NULL,\n"
		+ "	lead_actress TEXT NOT NULL,\n"
		+ "	year_of_Release INTEGER NOT NULL,\n"
                + "	director_name TEXT NOT NULL\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        createNewTable();
    }

}
