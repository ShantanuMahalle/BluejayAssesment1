import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class More14 {
	
		public static void morethan14() throws SQLException {
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {

				Class.forName("com.mysql.jdbc.Driver");

				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/timecard", "root", "Shantanu@123");

				ps = con.prepareStatement(" SELECT * \r\n" + 
						"\r\n" + 
						"FROM assignt" + 
						"\r\n" + 
						"WHERE `Timecard Hours (as Time)` > 14 " + 
						"\r\n" + 
						"GROUP BY `Time`");
				ps.clearWarnings();
//SELECT * FROM assignt WHERE `Timecard Hours (as Time)` > 14 GROUP BY `Time`
				rs = ps.executeQuery();
				// System.out.println("**************************************************");
				while (rs.next()) {

					System.out.print("Position ID" + rs.getString(1));
				//	System.out.print("Position Status " + rs.getString(2));
					//System.out.print(" Time " + rs.getString(3));
					//System.out.println(" Time Out " + rs.getString(4));*/
			//		System.out.println(" Timecard Hours (as Time) " + rs.getString(5));
					/*System.out.println(" Pay Cycle Start Date " + rs.getString(6));*/
					//System.out.println(" Pay Cycle End Date" + rs.getString(7));
					System.out.println(" \tEmployee Name " + rs.getString(8));
					//System.out.println(" File Number" + rs.getString(9));
					System.out.println();
				}
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				con.close();
				rs.close();
				ps.close();
			}
		}
		
	}

