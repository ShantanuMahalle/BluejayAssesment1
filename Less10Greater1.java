import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Less10Greater1 {
//
	public void less10great() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/timecard", "root", "Shantanu@123");
			
			ps = con.prepareStatement("SELECT * FROM assignt WHERE `Time` - `Time Out`  "
					
					+ "GROUP BY `Position ID`,`Time`"
					
					);
			ps.clearWarnings();
		
			rs = ps.executeQuery();
			while (rs.next()) {

				System.out.print("Position ID" + rs.getString(1));
				System.out.println(" \tEmployee Name " + rs.getString(8));
			}
	} catch (Exception e) {
		System.out.println(e);
	} finally {
		// Step-5 Release the resources
		con.close();
		ps.close();
	
}
	}
}
