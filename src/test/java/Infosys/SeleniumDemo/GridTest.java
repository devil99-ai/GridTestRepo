package Infosys.SeleniumDemo;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import GridTestPOM.*;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class GridTest {
	 WebDriver driver;
	 File scrFile;
	 CheckOutAndOrderWebElement checkout;
	 Login_webElement login;
	 logout_Element logout;
		OtherElements others;
	 Payment_webElement pay;
		SignUp_webElement signUp;
		ExtentSparkReporter htmlReporter;
		ExtentReports extent;
		ExtentTest test1;
	 Add_products_element add;
	@BeforeSuite
	@Parameters({"browser","hubURL"})
	public void setup(String browserName, String url) throws MalformedURLException {
		DesiredCapabilities ds = null;
		add = new Add_products_element();
		checkout = new CheckOutAndOrderWebElement();
		login= new Login_webElement();
		logout= new logout_Element();
		others=new OtherElements();
		pay=new Payment_webElement();
		signUp = new SignUp_webElement();
		htmlReporter=new ExtentSparkReporter("C://Users//svksh//eclipse-workspace//SeleniumDemo//src//test//extentReport1.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		test1 = extent.createTest("medicare site automation", "test to validate workflow ");
		if(browserName.equals("chrome")) {
			ds = new DesiredCapabilities();
			ds.setBrowserName("internetExplorer");
			ds.setPlatform(Platform.LINUX);
		}
		else if(browserName.equals("firefox")) {
			ds = new DesiredCapabilities();
			ds.setBrowserName("firefox");
			ds.setPlatform(Platform.LINUX);
		}else {
			Assert.fail("Invalid browser name");
		}
		driver = new RemoteWebDriver(new URL(url), ds);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	@Test
	@Parameters({"applicationUrl"})
	public void applicationLaunch(String APPurl) throws InterruptedException, IOException{
		driver.get(APPurl);
		Thread.sleep(5000);
		if(!(driver.getTitle().contains("Medicare - Home"))) {
			Assert.fail("Invalid Application URL: Enter the correct URL in XML file");
			scrFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile,new File("src/test/java/homepage.png"));
		}else if((driver.getTitle().contains("Medicare - Home"))) {
			System.out.println("Successfully login");
		}
		
	}
	@Test(dependsOnMethods = "applicationLaunch")
	public void E2E_Testing() {
		driver.findElement(login.click_on_login_on_homepage).click();
		driver.findElement(login.fill_email).sendKeys("svkshrm@gmail.com");
		driver.findElement(login.fill_password).sendKeys("Souvik99@");
		driver.findElement(login.click_on_submit);
		if(driver.findElement(By.xpath("//*[@id=\"dropdownMenu1\"]")).getText()=="Souvik Sharma") {
			test1.pass("Successfully logged in");
		}else {
			test1.fail("failed to login");
		}
		driver.findElement(add.click_on_more_products).click();
		driver.findElement(add.product1).click();
		driver.findElement(add.continue_shopping_btn).click();
		driver.findElement(add.product2).click();
		driver.findElement(checkout.cick_on_checkout).click();
		driver.findElement(checkout.select_previous_address).click();
		driver.findElement(pay.fill_card_number).sendKeys("4888665112399000");
		driver.findElement(pay.fill_exp_month).sendKeys("08");
		driver.findElement(pay.fill_exp_year).sendKeys("2027");
		driver.findElement(pay.fill_cvv).sendKeys("228");
		driver.findElement(pay.pay_btn).click();
		String confirm=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]")).getText();
		if(confirm=="Your Order is Confirmed!!") {
			test1.pass("successfully oredered item");
		}else {
			test1.fail("failed to oreder");
		}
		driver.findElement(By.xpath("/html/body/div/div[1]/div/div[4]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"dropdownMenu1\"]")).click();
		driver.findElement(logout.click_on_logout).click();
		if(driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div")).getText()=="You have logged out successfully!") {
			test1.pass("successfully logged out");
		}else {
			test1.fail("failed to log out");
		}
	}
	@AfterTest
	public void closeDriver() {
		driver.close();
		extent.flush();
	}
	
}
