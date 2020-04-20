package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class PostgresConn {




	 private final static String url = "jdbc:postgresql://localhost/TestDB";
	    private final static String user = "postgres";
	    private final static String password = "j25";

	    /**
	     * Connect to the PostgreSQL database
	     *
	     * @return a Connection object
	     */
	    public static Connection connect() {
	        Connection conn = null;
	        try {
	            conn = DriverManager.getConnection(url, user, password);
	            System.out.println("Connected to the PostgreSQL server successfully.");
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }

	        return conn;
	    }

	    /**
	     * @param args the command line arguments
	     */
	    public static void main(String[] args) {
	        PostgresConn app = new PostgresConn();
	        app.connect();
	    }
}