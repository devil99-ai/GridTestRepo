package Infosys.SeleniumDemo;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class reportDemo {
	WebDriver d;
	@Test
	public void f() throws Exception {
		ExtentReports reports=new ExtentReports("extentreport.html");
		ExtentTest test=reports.startTest("Login test");  
		test.log(LogStatus.INFO,"Specifying the path of chromedriver");
		d=new ChromeDriver();
		test.log(LogStatus.INFO, "Launching chrome");
		d.get("http://10.82.180.36/Common/Login.aspx");
		test.log(LogStatus.INFO, "Opening the url");
		d.findElement(By.id("body_txtUserID")).sendKeys("donhere");
		test.log(LogStatus.INFO,"Sending username");
		d.findElement(By.name("ctl00$body$txtPassword")).sendKeys("don@12345");
		test.log(LogStatus.INFO,"Sending password");
		d.findElement(By.xpath("//*[@id=\"body_btnLogin\"]")).click();
		test.log(LogStatus.INFO, "Clicking on login button");
		if(d.getCurrentUrl().equals("http://10.82.180.36/Common/Login.aspx")) {
			test.log(LogStatus.FAIL,test.addScreenCapture(captureScreenshot())+"Login unsuccesful");
		}else {
			test.log(LogStatus.PASS,"Login successful");}
			reports.endTest(test);
			reports.close();
	}
	public String captureScreenshot() throws Exception {
		File src=((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
		File dest=new File("Screenshot.png");
		FileUtils.copyFile(src, dest);
		return dest.getAbsolutePath();
	}

}
