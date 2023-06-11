package application;

/*
 	Establish connection to Database MySQL.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Link {
	
	public Connection DBLink;

	public Connection getLink() throws ClassNotFoundException {
		String DBname = "DataHub";
		String DBUser = "root";
		String DBAccessKey = "@!HighRestriction562322";
		String URL = "jdbc:mysql://localhost/" + DBname;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			DBLink = DriverManager.getConnection(URL, DBUser, DBAccessKey);
			System.out.println("\nConnection Successful");
		}catch(SQLException e) {
			e.printStackTrace();
			
			System.out.println("Unable to estable connection, please"
					+ " check Class Link");
		}
		
		return DBLink;
	}
}
