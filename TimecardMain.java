
import java.sql.SQLException;
import java.util.Scanner;



public class TimecardMain {
	public static void status() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println();
		// To Display list of operation
		System.out.println("Choose the Option " + "\n1. Employee  who has worked for 7 consecutive days." 
		+ "\n2. who have less than 10 hours of time between shifts but greater than 1 hour "
				+ "         \n3. Employee Who has worked for more than 14 hours in a single shift" );
		int option = scanner.nextInt();
		if (option == 1) {
			Consecutive7Days c7 = new Consecutive7Days();
			c7.continue7days();
			} else if (option == 2) {
				Less10Greater1 lg = new Less10Greater1();
			lg.less10great();
		} else if (option == 3) {
              More14 mf = new More14();
              mf.morethan14();
		
		} else if (option > 3
				|| option <= 0) {
			System.out.println("Invalid Input Please Enter Correct Details"); // Invalid Credential 
			status();   
		}
	}
	public static void main(String[] args) throws SQLException {
		status();
	}
}

