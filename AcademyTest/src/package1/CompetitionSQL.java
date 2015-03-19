package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CompetitionSQL {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/";
	static final String USER = "root";
	static final String PASS = "root";
	public void connectionTest(){
		Connection conn = null;
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			conn.close();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
		}
	}
	
}
