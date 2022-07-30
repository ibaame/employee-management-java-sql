
import java.util.Scanner;

public class Insert extends Check  {
	
	// for pass data to Check constructor
	public Insert(String port, String databaseName, String userName, String password) {
		super(port, databaseName, userName, password);
	}

	// main method for Insert
	public void mainInsert() {
		Scanner in = new Scanner(System.in);
		
		boolean loop = true;
		while(loop) {
			System.out.println("\n---------------------[Insert]---------------------");
			System.out.println("\n(1) insert employee");
			System.out.println("(0) Exit");
			System.out.print("Enter option: ");
			int num = in.nextInt();
			Base.LoadingMessage();
			
			if(num == 1) {
				insert("employee");
			}	
			else if(num == 0)
				loop = false;
			else
				loop = true;		
		}
	}
	
	// Process for insert
	private void insert(String tableName ) {
		Scanner in = new Scanner(System.in);
		String value = "";
		try {
			boolean loop = true;
			while(loop) {
				System.out.print("\nEnter ID: ");
				String ID = in.next();
				if(checkID(ID) == false) {
					value += qouteMark(ID) + ", ";
					loop = false;
				}			
				else
					System.out.println("\n*Message: ID is exist.");
			}
			
			// first name
			System.out.print("Enter first name: ");
			value += qouteMark(in.next()) + ", "; 	
			
			// last name
			System.out.print("Enter last name: ");
			value += qouteMark(in.next()) + ", "; 	
			
			// job title
			System.out.print("Enter job title: ");
			value += qouteMark(in.next()) + ", "; 
			
			// city
			System.out.print("Enter citu: ");
			value += qouteMark(in.next()) + ", "; 
			
			// birthday
			loop = true;
			while(loop) {
				System.out.print("Enter brithday(like: 0000-00-00): ");
				String date = in.next();
				if(checkDate(date)) {
					value += qouteMark(date) + ", "; 	
					loop = false;
				}
				else
					System.out.println("\n*Message: date is wrong, again.");				
			}
			
			// phone
			loop = true;
			while(loop) {
				System.out.print("Enter phone: ");
				String phone = in.next();	
				if(checkPhone(phone) == false) {
					value += qouteMark(phone) + ", "; 
					loop = false;
				}
				else
					System.out.println("\n*Message: phone number is exist, again.");		
			}
			 
			// email
			loop = true;
			while(loop) {
				System.out.print("Enter email: ");
				String email = in.next();	
				if(checkEmail(email) == false) {
					value += qouteMark(email) ; 
					loop = false;
				}
				else
					System.out.println("\n*Message: email is exist, again.");					
			}

			String query = "insert into " + tableName + " values (" + value + ");";
			connect.prepareStatement(query).executeUpdate();
			
			System.out.println("\n#Done");
		}
		catch(Exception ex){ ex.getStackTrace(); }
	}

	
}

