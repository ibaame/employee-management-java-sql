

import java.util.Scanner;

public class Select extends Base {

	// for pass data to Base constructor
	public Select(String port, String databaseName, String userName, String password) {
		super(port, databaseName, userName, password);
	}
	
	// main method for select
	public void mainSelect() {
		Scanner in = new Scanner(System.in);
	
		boolean loop = true;
		while(loop) {
			System.out.println("\n---------------------[Select]---------------------");
			System.out.println("\n(1) show all employee");
			System.out.println("(2) one employee");
			System.out.println("(0) Exit");
			System.out.print("Enter option: ");
			int num = in.nextInt();
			Base.LoadingMessage();
			
			if(num == 1) {
				select("employee", "*","all");
			}	
			else if(num == 2) {
				System.out.print("\nEnter employee ID: ");
				String id = in.next();
				select("employee", "*",id);
			}
			else if(num == 0)
				loop = false;
			else
				loop = true;	
		}
	}
	
	// Process for select
	private void select(String tableName, String columnsName , String whereCondtion ) {
		int check = 0;
		boolean pass = true;
		try{
			if(whereCondtion.equals("all")) {
				resultSet = statement.executeQuery(" select " + columnsName +  "  from " + tableName);
			}				
			else {
				if(checkID(whereCondtion))
					resultSet = statement.executeQuery(" select " + columnsName +  "  from " + tableName + " where Eid = " + Integer.parseInt(whereCondtion));
				else {
					System.out.println("\n*Message: ID not found");
					pass = false;
				}				
			}
				
			
			if(pass) {
				System.out.println("\n-----------------------------------------------------------------------------------------");
				System.out.println("ID	| name | job Title | city | brithday | phone | email");
				System.out.println("-----------------------------------------------------------------------------------------");
				while(resultSet.next()) {
					check = 1;
					int eid = resultSet.getInt("EID");
					String fname = resultSet.getString("firstName");
					String lname = resultSet.getString("lastName");
					String jobTitle = resultSet.getString("jobTitle");
					String city = resultSet.getString("city");
					String BOD  = resultSet.getString("BOD");
					String phone = resultSet.getString("phone");
					String email = resultSet.getString("email");
					System.out.println(eid + "	| " + fname + " " + lname + ", "+ jobTitle+", " + city + ", "+ BOD + ", " + phone+ ", " + email);
				}
				if(check == 0 )
					System.out.println("\n*Message: Database is empty");
				System.out.println("-----------------------------------------------------------------------------------------");
			}
		}
		catch(Exception ex) { System.out.println("\n*Message: info of connection is wrong, again."); }
	}
	
}

