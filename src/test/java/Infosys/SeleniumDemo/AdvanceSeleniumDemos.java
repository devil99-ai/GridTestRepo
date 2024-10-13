package Infosys.SeleniumDemo;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AdvanceSeleniumDemos {
	WebDriver driver;
	
//	@BeforeClass
//	  @Parameters({"browser","URL"})
//	  public void Setup(@Optional("Firefox")String browser1,String url) {
//	      System.out.println("Browser:"+browser1);
//	      System.out.println("AUT Link: "+url);     
//	  }
//	  @Test
//	  public void test()  {
//	     //business logic 
//	  } 
//	  @Test(dataProvider="credentials")
//	  public void f(String username, String password) {
//		  System.out.println(username);
//		  System.out.println(password);
//		  
//	  }
//	  @DataProvider(name="credentials")
//	  public Object[][] getData(){
//		  Object[][] data = new Object[3][2];
//		  
//		  data[0][0]="Admin";
//		  data[0][1]="admin123";
//		  
//		  data[1][0]="user";
//		  data[1][1]="user123";
//		  
//		  data[2][0]="OtherUser";
//		  data[2][1]="Other123";
//		  
//		  return data;
//		  
//		  
//	  }
//========================================================================= data provider annotations ==========================================================================
//	@BeforeSuite	
//	@Parameters({ "browsername", "url" })
//	public void setup(@Optional("chrome")String browsername,String url) {	
//		driver= new ChromeDriver();
//		switch (browsername) {
//		case "IE":
//		//Code to initialize webdriver instance
//			driver.get(url);
//			break;
//		case "Firefox":
//			//Code to initialize webdriver instance
//			driver.get(url);
//			break;
//		case "chrome":
//			//Code to initialize webdriver instance
//			driver.get(url);
//			break;	
//		}	
//	}
//
//	  @AfterSuite
//	  public void tearDown() {
//		  driver.quit();	  
//	  }
//	  @DataProvider
//	  public Object[][]getData() {
//	      Object[][]data=new Object[2][2];
//	      data[0][0]="pgGru";
//	      data[0][1]="freezeray";
//	      data[1][0]="pgAlmacho";
//	      data[1][1]="freezeray";
//	      return data;	
//	  }
//	  @Test(dataProvider="getData")
//	  public void login(String username,String password) 
//	  {	 
//		   //Code to Login to the application
//			  driver.findElement(By.xpath("//*[@id=\'myNavbar\']/ul/li[4]/a")).click();
//			  driver.findElement(By.id("usernameLogin")).sendKeys(username);
//			  driver.findElement(By.id("passwordLogin")).sendKeys(password);
//			  driver.findElement(By.id("login")).click();
//	      
//	            try
//				{
//		         //verifying the presence of webelement
//				new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("topMenu2")));
//				System.out.println("login success");
//				}
//				catch(Exception e)
//				{
//					System.out.println("Login failure");
//					
//				}
//				driver.findElement(By.id("topMenu2")).click();
//				
//		  }
//=================================================================== depends on Methods annotations ==========================================================================	
	//import statement
//	    @Test
//	    public void login() 
//	    {
//	        System.out.println("Code to login into the AUT");
//	    }
//	   
//	   @Test(dependsOnMethods = { "dashboard" })
//	    public void logout() 
//	    {
//	        System.out.println("Logout from the application");
//	    }
//	   @Test(dependsOnMethods = { "login" })
//	    public void dashboard()
//	    {
//	        System.out.println("Dashboard Page");
//	    }
//======================================================================== priority annotations ================================================================================
	   // priority annotations
	   
	   
//	   @Test(priority = 2,enabled=true)
//	    public void test01() 
//	    {
//	        System.out.println("Inside Test01 Method");
//	    }
//	    @Test(priority = 0)
//	    public void test02() 
//	    {
//	        System.out.println("Inside Test02 Method");
//	    }
//	    @Test(priority = 1)
//	    public void test03()
//	    {
//	        System.out.println("Inside Test03 Method");
//	    }
//======================================================================= groups annotations ===================================================================================
	
	
//	@Test(groups = { "car", "ecar" })            
//    public void car() {
//        System.out.println("Car");
//    }
//   @Test(groups = { "car", "sedan" })
//    public void car1() {
//        System.out.println("Car1");
//    }
//   @Test(groups = { "car" })
//    public void car2() {
//        System.out.println("Car2");
//    }
//   @Test(groups = { "bike", "ebike" })
//   public void bike() {
//           System.out.println("Bike");
//   }
//   @Test(groups = { "bike" })
//   public void bike1() {
//   	System.out.println("Bike1");
//   }
//   @Test(groups = { "bike" })
//   public void bike2() {
//   	System.out.println("Bike2");
//   }
//}
	
	
//============================================================== Assertions =================================================================================================

	//String assertionString="demoforHardAssertion";
	  @Test
	  public void test2() {
		 AssertJUnit.assertEquals("demoforHardAssertion", assertionString);
		 System.out.println("After Assert equals");
		 AssertJUnit.assertTrue(assertionString.equals("demoforHardAssertions"));
		 System.out.println("After Assert true");
	  }
	  //soft assertion
	  String assertionString="demoforHardAssertion";
		@Test
		public void test() {
			//Soft assert Object
			SoftAssert softAssert=new SoftAssert();
			AssertJUnit.assertEquals("demoforHardAssertions", assertionString);
			System.out.println("After Assert equals");
			AssertJUnit.assertTrue(assertionString.equals("demoforHardAssertions"));
			System.out.println("After Assert true");
			softAssert.assertAll();
		}
}
	

		
	  

	 
