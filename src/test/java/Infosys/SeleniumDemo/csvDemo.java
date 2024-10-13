package Infosys.SeleniumDemo;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.FileReader;
import java.io.FileWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class csvDemo {
		WebDriver driver;
		@BeforeMethod
		public void beforeMethod() {
		driver=new ChromeDriver();
		driver.get("https://cloud.openshot.org/apps/simple-editor/login");
		driver.manage().window().maximize();
			
		}
	  @Test
	  public void f() throws Exception {
		  CSVReader csvReader=new CSVReader(new FileReader("C:\\Users\\svksh\\OneDrive\\Documents\\credentials.csv"));
		  CSVWriter csvwriter = new CSVWriter(new FileWriter("C:\\Users\\svksh\\OneDrive\\Documents\\result.csv"));
		  String[] cols;
		  while((cols=csvReader.readNext())!=null) {
			  String uname=cols[0];
			  String pwd=cols[1];
			  System.out.println(uname+" "+pwd);
			  driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div[1]/input")).clear();
			  driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div[2]/input")).clear();
			  driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div[1]/input")).sendKeys(uname);
			  driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div[2]/input")).sendKeys(pwd);
			  driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/button")).click();
			  if(driver.getCurrentUrl().equals("https://cloud.openshot.org/apps/simple-editor/")) {
				  System.out.println("successful login");
				  String success[]= {uname, pwd,"Login Successful"};
				  csvwriter.writeNext(success);
				  
			  }
		  }
		  csvReader.close();
		  csvwriter.close();
	  }
	}



