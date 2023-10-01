import java.sql.Connection;//
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Consecutive7Days {
	public static void continue7days() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/timecard", "root", "Shantanu@123");

			ps = con.prepareStatement("SELECT *, MIN(FROM_DATE) AS FROM_DATE,\r\n" + 
					"       MAX(Time) AS TO_DATE, COUNT('A') AS LVALUE\r\n" + 
					"FROM (\r\n" + 
					"SELECT * ,\r\n" + 
					"    DATEDIFF(D, ROW_NUMBER() OVER(ORDER BY FROM_DATE), FROM_DATE) AS Diff\r\n" + 
					"FROM tblLeave) AS dt\r\n" + 
					"GROUP BY Time, Diff\r\n" + 
					"ORDER BY FROM_DATE");
			ps.clearWarnings();

			while (rs.next()) {

				System.out.print("Position ID" + rs.getString(1) + "\t");

				System.out.println(" Employee Name " + rs.getString(8));

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
