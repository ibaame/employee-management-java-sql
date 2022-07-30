
import java.util.Scanner;

public class Update extends Check{
	
	// for pass data to Check constructor
	public Update(String port, String databaseName, String userName, String password) {
		super(port, databaseName, userName, password);
	}

	// main method for update
	public void mainUpdate() {
		Scanner in = new Scanner(System.in);
		 
		boolean outerLoop = true;
		while(outerLoop) {
			System.out.println("\n---------------------[Update]---------------------");
			System.out.println("\n(1) update employee");
			System.out.println("(0) Exit");
			System.out.print("Enter option: ");
			int num = in.nextInt();
			Base.LoadingMessage();
			
			if(num == 1) {
				System.out.print("\nEnter employee ID: ");
				String id = in.next();
				String prviousID = id;
				int checkNowrong = 1;
				if(checkID(id)) {
					
					boolean innerLoop = true;
					while(innerLoop) {
						String nameColumn = "";
						String value = "";
						System.out.println("\nWhat yoru Change in ID " + id );
						System.out.println("(1) employee ID");
						System.out.println("(2) first name");
						System.out.println("(3) last name");
						System.out.println("(4) job title");
						System.out.println("(5) city");
						System.out.println("(6) birthday");
						System.out.println("(7) phone");
						System.out.println("(8) email");
						System.out.println("(0) exit (no update)");
						System.out.print("Enter option: ");
						int op = in.nextInt();
						
						if(op == 1) {
							nameColumn = "EID";
							System.out.print("Enter new ID: ");
							String EID = in.next();
							if(checkID(EID) == false) {
								value = qouteMark(EID);
								id = EID;
							}
							else
								System.out.println("\n*Message: ID is exist");
							
						}
						else if(op == 2) {
							nameColumn = "firstName";
							System.out.print("Enter first Name: ");
							value = qouteMark(in.next());
						}
						else if(op == 3) {
							nameColumn = "lastName";
							System.out.print("Enter last Name: ");
							value = qouteMark(in.next());
						}
						else if(op == 4) {
							nameColumn = "jobTitle";
							System.out.print("Enter job Title: ");
							value = qouteMark(in.next());
						}
						else if(op == 5) {
							nameColumn = "city";
							System.out.print("Enter city: ");
							value = qouteMark(in.next());
						}
						else if(op == 6) {
							checkNowrong = 0;
							nameColumn = "BOD";
							System.out.print("Enter birthday(0000-00-00): ");
							String date = in.next();
							if(checkDate(date)) {
								value = qouteMark(date);
								checkNowrong = 1;
							}
							else
								System.out.println("\n*Message: date is wrong, again.");
						}
						else if(op == 7) {
							checkNowrong = 0;
							nameColumn = "phone";
							System.out.print("Enter phone: ");
							String phone = in.next();
							if(checkPhone(phone) == false) {
								value = qouteMark(phone);
								checkNowrong = 1;
							}
							else
								System.out.println("\n*Message: phone number is exist, again.");
						}
						else if(op == 8) {
							checkNowrong = 0;
							nameColumn = "email";
							System.out.print("Enter email: ");
							String email = in.next();
							if(checkEmail(email) == false) {
								value = qouteMark(email);
								checkNowrong = 1;
							}
							else
								System.out.println("\n*Message: email is exist, again.");
						}
						else if(op == 0) {
							checkNowrong = 0;
							innerLoop = false;	
						}	
						else{
							checkNowrong = 0;
							innerLoop = true;	
						}
							
						// check if don't have any wrong in data if no wrong update , else no update
						if(checkNowrong == 1) {
							update("employee",nameColumn,prviousID,value);
							System.out.println("\n#Done");
						}
						prviousID = id;
					}
				}
				else
					System.out.println("\n*Message: employee dosen't exist");
			}	
			else if(num == 0)
				outerLoop = false;
			else
				outerLoop = true;			
		}
	}
	
	// Process for update
	private void update(String tableName, String column,String id ,  String value ) {
		try {
			String query = "update " + tableName + " set " + column + " = " + value + " where Eid = " + qouteMark(id);
			connect.prepareStatement(query).executeUpdate();
		}
		catch(Exception ex) { ex.getStackTrace(); }
	}
	
}

