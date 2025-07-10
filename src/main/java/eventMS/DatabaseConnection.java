package eventMS;

import java.sql.*;

public class DatabaseConnection {
	private static final String URL= "jdbc:postgesql://localhost:5432/eventdb";
	private static final String USER="postgres";
	private static final String PASSWORD="your_password";
    public static Connection getConnection() throws SQLException{
    	return DriverManager.getConnection(URL,USER,PASSWORD);
    	
    }

}
