package sqlpackage;
import java.sql.*;
public class MSSQLConnect {
	

	
	    public static void main(String[] args) {
	        String url = "jdbc:sqlserver://localhost:1433;databaseName=TestDB;encrypt=false";//trustServerCertificate=true";
	        String username = "sa"; // or your DB username
	        String password = "dhanasree"; // your DB password

	        try {
	            // Load SQL Server JDBC driver
	            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

	            // Connect to the database
	            Connection conn = DriverManager.getConnection(url, username, password);
	            System.out.println("Connection successful!");

	            // Sample query
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery("SELECT * FROM Users");

	            while (rs.next()) {
	                System.out.println(rs.getInt("ID") + " - " + rs.getString("Name") + " - " + rs.getString("Email"));
	            }

	            // Close connections
	            rs.close();
	            stmt.close();
	            conn.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}


