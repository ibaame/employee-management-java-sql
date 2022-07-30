
import java.sql.*;

public class Base {

	protected Connection connect = null;
	protected Statement statement = null;
	protected PreparedStatement preparedStatement = null;
	protected ResultSet resultSet = null;
	
	// for connection with database 
	// info of database => port , database name , user name , password
	public Base() {};
	public Base(String port, String databaseName, String userName, String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost:" + port + "/" + databaseName, userName, password);
			statement = connect.createStatement();
		}
		catch(Exception ex) { ex.getStackTrace(); }
	}
	
	// Loading message
	public static void LoadingMessage() {
		System.out.println("Loading...");
	}
	
	// check id is exist or not
	protected boolean checkID(String id) {
		try {
			resultSet = statement.executeQuery("select * from employee");
			while(resultSet.next()) {			
				String idx = resultSet.getString("EID");
				if(id.equals(idx))
					return true;
			}
		}
		catch(Exception ex) { ex.getStackTrace(); }
		return false;
	}
	
}
