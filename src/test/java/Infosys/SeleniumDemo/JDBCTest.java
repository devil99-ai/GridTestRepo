package Infosys.SeleniumDemo;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JDBCTest {

	WebDriver driver;
	Connection connection;
	Statement stmt;
	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void test() throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin", "root", "Souvik99@");
		stmt = connection.createStatement();
		stmt.execute("create table credentials (username varchar(20),password varchar(20))");
		stmt.execute("insert into credentials values('donhere','don@123'),('donhere2','don@123')");
		ResultSet rs = stmt.executeQuery("select * from credentials");
		System.out.println(rs);
	}

}
