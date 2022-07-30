
import java.util.Scanner;

public class Delete extends Base {
	
	// Process for Delete
	public Delete(String port, String databaseName, String userName, String password) {
		super(port, databaseName, userName, password);
	}

	// main method for Delete
	public void mainDelete() {
		Scanner in = new Scanner(System.in);
	
		boolean x = true;
		while(x) {
			System.out.println("\n---------------------[Delete]---------------------");
			System.out.println("\n(1) delete employee");
			System.out.println("(0) Exit");
			System.out.print("Enter option: ");
			int num = in.nextInt();
			Base.LoadingMessage();
			
			if(num == 1) {
				System.out.print("Enter employee ID: ");
				String id = in.next();
				if(checkID(id)) {
					String RP = randomPassword();
					System.out.println("you sure? Enter password => " + RP);
					System.out.print("=> ");
					String pass = readString();
					if(pass.equals(RP)) {
						delete("employee",id);
						System.out.println("\n#Done");
					}
					else
						System.out.println("\n*Message: password is wrong");
				}
				else 
					System.out.println("\n*Message: employee doesn't exist");
			}	
			else if(num == 0)
				x = false;
			else
				x = true;		
		}
	}
	
	
	// Process for Delete
	private void delete(String tableName, String whereCondtion) {
		try {
			String query = "delete from " + tableName + " where EID = " + whereCondtion;
			connect.prepareStatement(query).executeUpdate();
		}
		catch(Exception ex) { ex.getStackTrace(); }
	}

	// random password of 5-digit for delete , first digit A - Z , second to fifth digit 1000 - 9999 
	private String randomPassword() {
		int num = 1000 + (int)(Math.random() * 9000);
		char letter = (char)(65 + (int)(Math.random() * 26));
		String pass = String.valueOf(letter + "" + num);
		return pass;
	}
	
	// read String from user
	private String readString() {
		Scanner in = new Scanner(System.in);
		String txt  = in.nextLine();
		return txt;
	}

}
