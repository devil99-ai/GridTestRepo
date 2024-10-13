package Infosys.SeleniumDemo;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.Calendar;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest {
	WebDriver driver;
    String url = "http://localhost:8080/EDUBank/tellerLogin/";
   
    @BeforeMethod
	public void before() throws Exception {
      //Set the key/value property according to the browser you are using.
    WebDriverManager.firefoxdriver().setup();
           
      //Open browser instance
      driver = new FirefoxDriver();
              
      //Open the AUT
      driver.get(url);
      
      //Declare an implicit wait bounded to WebDriver instance
      driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        
    }
  
    
  
    @Test
    public void test() {
      //Enter username
      driver.findElement(By.id("tellerId")).sendKeys("T7302");
      
      //Enter password
      driver.findElement(By.id("password")).sendKeys("T7302*abc");
      
      //Click on Login button
      driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/button")).click();
      
      //Enter name
      driver.findElement(By.id("custName")).sendKeys("John");
          
      //Enter EmailId
      driver.findElement(By.id("email")).sendKeys("johnwin"+Calendar.getInstance().getTime().getTime()+"@gmail.com");;
      
      //Enter dateofBirth
      driver.findElement(By.id("dob")).sendKeys("21/10/1987");
      
      ///Find the security Question dropdown list and store it as a WebElement
      WebElement sectyq = driver.findElement(By.id("secQId"));
      
      //Pass the reference variable for sectyq as a parameter for the Select class
      Select secqdd = new Select(sectyq);
      
      //Use the select reference variable for selecting any option using index/value/visible text approach
      secqdd.selectByValue("210002");
      
      //Enter the security answer
      driver.findElement(By.id("secAns")).sendKeys("Chicago");
      
      //Click on Add Customer
      driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/form/button[1]")).click();
      
      //Click on Download Customer Details
      driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[4]/a")).click();
      
      // Fetch the number of opened windows
      Set<String> windowHandles = driver.getWindowHandles();
      System.out.println("Number of opened windows: " + windowHandles.size());
      
      Integer temp=0;
      
      String msg=null;
      
      //Iterate through all the available windows
      for (String string : windowHandles) {
        //Switch between windows using the string reference variable
        driver.switchTo().window(string);
        
        //Fetch the URL of the page post successful switch
        String title = driver.getTitle();
        
        //check whether the url post switch is the desired page
        if (!title.equals("Teller Home")) {
          temp = 1;
          msg="Window found.";
          break;
        } else {
          temp = 0;
        }
      }
   
      if (temp == 1) {
        
        System.out.println(msg);
      
        //Find some element from the switched page to verify that the switch is successful
        WebElement Bankname = driver.findElement(By.xpath("/html/body/div/span[1]"));
        System.out.println(Bankname.getText()+" Bank");
      }
      else if (temp == 0) {
        System.out.println("Desired Window not found.");
      }
    }
  
    @AfterMethod
	public void after() throws Exception{
      //Close the driver
      driver.close();
    }
  }