import java.sql.Connection;

import java.sql.DriverManager;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.home.wkimdev.config.DBConfig;
import com.home.wkimdev.member.dao.MemberDAO;
import com.home.wkimdev.member.service.MemberService;

public class DBConnectTest {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private MemberService memberService;
	
	private static final String testDriver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/springBoard?useSSL=false&amp;serverTimezone=UTC";
	private static final String user = "root";
	private static final String password = "1234";
	
	//@Test
	public void testDbConnection() throws Exception {
		Class.forName(testDriver);
		try(Connection connection = DriverManager.getConnection(url, user, password)) {
			System.out.println(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getMemberIdList() {
		
		//System.out.println(memberDAO.testCall());
		System.out.println(memberDAO.memberFindAllId());
		//System.out.println(memberService.getMemberIdList());
	}
	
	//@Test
	public void getMemberInsert() {
		
	}
}
