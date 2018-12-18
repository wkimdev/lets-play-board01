import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import com.home.wkimdev.config.DBConfig;

public class DBConnectTest {
	
	private static final String testDriver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/springBoard?useSSL=false&amp;serverTimezone=UTC";
	private static final String user = "root";
	private static final String password = "1234";
	
	@Test
	public void testDbConnection() throws Exception {
		Class.forName(testDriver);
		try(Connection connection = DriverManager.getConnection(url, user, password)) {
			System.out.println(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
