
import java.sql.*;
import java.util.Date;
import java.util.Scanner;

public class Program  {

	private static String port = "0";
	private static String databaseName = "0";
	private static String userName = "0";
	private static String password = "0";
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		boolean loop = true;
		while(loop) {
			System.out.println("\n==================================================");
			System.out.println("\t\tEdit database employee");
			System.out.println("==================================================");
			System.out.println("~~ Enter \"X\" for update connection info");
			System.out.println("(1) Select");
			System.out.println("(2) Update");
			System.out.println("(3) Insert");
			System.out.println("(4) Delete");
			System.out.println("(0) Exit");
			System.out.print("Enter option: ");
			String num = in.next();
			Base.LoadingMessage();
			
			if(num.equals("X"))
				updateConnection();
			else if(num.equals("1")) {
				Select select = new Select(port, databaseName, userName, password);
				select.mainSelect();
			}
			else if(num.equals("2")) {
				Update update = new Update(port, databaseName, userName, password);
				update.mainUpdate();
			}
			else if(num.equals("3")) { 
				Insert insert = new Insert(port, databaseName, userName, password);
				insert.mainInsert();
			}
			else if(num.equals("4")) {
				Delete delete = new Delete(port, databaseName, userName, password);
				delete.mainDelete();
			}
			else if(num.equals("0")) 
				loop = false;
			else
				loop = true;
		}	
		System.out.println("\n----------------------[Exit]----------------------\nProgram terminated");	
	}
	
	public static void updateConnection() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("\n=================[connection info]=================");
		System.out.print("Enter Port: ");
	    port = in.next();
		System.out.print("Enter database name: ");
		databaseName = in.next();
		System.out.print("Enter User name: ");
		userName = in.next();
		System.out.print("Enter password for Service: ");
	    password = in.next();
	}
}
