package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class PostgresDBDriver implements DBDriver {
	String url = "jdbc:postgresql://localhost/postgres";
	
	
	private Connection connectDb() throws SQLException {
		Properties props = new Properties();
		props.setProperty("user","postgres");
		props.setProperty("password","postgres");
		return DriverManager.getConnection(url, props);
	}
	
	@Override
	public void runUpdateQuery(String query) throws SQLException {
		Connection conn = connectDb();
		PreparedStatement stmt  = conn.prepareStatement(query);
		stmt.executeUpdate();
		conn.close();
	}
}
