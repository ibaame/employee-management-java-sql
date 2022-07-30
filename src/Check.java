
import java.util.Date;

public class Check extends Base {

	// for pass data to Base constructor
	public Check() {};
	public Check(String port, String databaseName, String userName, String password) {
		super(port, databaseName, userName, password);
	}
	
	// check phone number is exist or not
	protected boolean checkPhone(String phone) {
		try {
			resultSet = statement.executeQuery("select * from employee");
			
			while(resultSet.next()) {			
				String phonex = resultSet.getString("phone");
				if(phone.equals(phonex)) {
					return true;
				}	
			}
			
		}
		catch(Exception ex) { ex.getStackTrace(); }
		return false;
	}
	
	// check email is exist or not
	protected boolean checkEmail(String email) {
		try {
			resultSet = statement.executeQuery("select * from employee");
			while(resultSet.next()) {			
				String emailx= resultSet.getString("email");
				if(email.equals(emailx)){
					return true;
				}
			}
		}
		catch(Exception ex) { ex.getStackTrace(); }
		return false;
	}
	
	// check date or birth is true or not
	protected boolean checkDate(String date) {
		Date dateYear = new Date();
		int currentYear  = dateYear.getYear()+ 1900;
		char[] dateChar = date.toCharArray();
		if(dateChar.length == 10 && (dateChar[4] == '-' && dateChar[7] == '-') ) {
			String yearStr = String.valueOf(dateChar[0] + "" + dateChar[1] + "" + dateChar[2] + "" + dateChar[3]);
			String monthStr = String.valueOf(dateChar[5] + ""+ dateChar[6]);
			String dayStr = String.valueOf(dateChar[8]+ "" + dateChar[9]);
			int yearInt = Integer.parseInt(yearStr);
			int monthInt = Integer.parseInt(monthStr);
			int dayInt = Integer.parseInt(dayStr);
			
			if( (yearInt <= currentYear) && (monthInt >= 1 && monthInt <= 12) && (dayInt >= 1 && dayInt <= 31))
				return true;
			else
				return false;
		}	
		else 
			return false;	
	}
	
	// add quote mark for insert or update value type String
	protected String qouteMark(String value) {
		return "\"" + value + "\"";
	}
	
}
