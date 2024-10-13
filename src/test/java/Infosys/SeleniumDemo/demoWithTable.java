package Infosys.SeleniumDemo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoWithTable {
	 WebDriver driver;
     String url = "https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/";
  
     @BeforeMethod
	@BeforeMethod
	public void setUp() {
         //Set the key/value property according to the browser you are using.
                  
         //Open browser instance
         driver = new ChromeDriver();
                         
         //Open the AUT
         driver.get(url);
         
         //Declare an implicit wait which is bounded to WebDriver instance
         driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
         driver.manage().window().maximize();
     }
  
     @Test
     public void test() throws InterruptedException {
             
         //Click on Offers Link
         JavascriptExecutor js=(JavascriptExecutor)driver;
         
         //Fetch the Account details table
         WebElement tblAccountDetails = driver.findElement(By.className("wp-block-table"));
         js.executeScript("arguments[0].scrollIntoView();", tblAccountDetails);
         //Fetch all the rows inside the Account details table using the tr tag and store it in rows list
         List<WebElement> rows = tblAccountDetails.findElements(By.tagName("td"));
         
         //Print the number of rows
         System.out.println("Number of rows: " + rows.size());
         
         //Iterate over all the rows
         for (WebElement row : rows) {
             //Find all the cols inside the particular row using the td tag
             List<WebElement> cols = row.findElements(By.xpath("//*[@id=\"post-12958\"]/div/figure/table/tbody"));
             
             //Iterate over all the columns inside the particular row
             for (WebElement col : cols) {
                 //Print the cell value
                 System.out.print("Column value: " + col.getText());
             }
         }
     }
  
     @AfterMethod
	@AfterMethod
	public void tearDown() {
         driver.close();
     }
 }
 
