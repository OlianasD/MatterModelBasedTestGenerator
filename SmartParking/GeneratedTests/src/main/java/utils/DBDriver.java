package utils;

import java.sql.SQLException;

public interface DBDriver {
	
	public void runUpdateQuery(String query) throws SQLException;
}
