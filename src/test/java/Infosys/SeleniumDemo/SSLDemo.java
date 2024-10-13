package Infosys.SeleniumDemo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SSLDemo {
	private WebDriver driver;
		@BeforeMethod
		@BeforeMethod
		@BeforeClass
		public void setUp() {
//====================================================== for firefox to accept privacy error ======================================================================================
			
			 ProfilesIni prof = new ProfilesIni();
			 FirefoxProfile ffProfile = prof.getProfile("Selenium");
			 ffProfile.setAcceptUntrustedCertificates(true);
			 ffProfile.setAssumeUntrustedCertificateIssuer(false);
			 driver = new FirefoxDriver();
//====================================================== for Chrome to accept privacy error ======================================================================================
			ChromeOptions co= new ChromeOptions();
			co.setAcceptInsecureCerts(true);
			driver = new ChromeDriver (co);

			driver.manage().window().maximize();
		}
		@Test
		public void openApplication() {
			driver.get("https://cacert.org/");
			String pageTitle = driver.getTitle();
			String expectedTitle = "Welcome to CAcert.org";
			AssertJUnit.assertEquals(pageTitle, expectedTitle);
		}
		@AfterMethod
		@AfterMethod
		@AfterClass
		public void tearDown() {
			driver.close();
		}
	}


