package Infosys.SeleniumDemo;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FlipkartPageTesting {
	WebDriverWait wait;
	WebDriver driver;
	String urlFlipkart = "https://www.flipkart.com/";
	String urlAmazon = "https://www.amazon.com/";
	String urlDrop = "https://www.globalsqa.com/demo-site/select-dropdown-menu/";
	static Logger logger ;
	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		wait = new WebDriverWait(driver,Duration.ofSeconds(20)); 
		logger  = Logger.getLogger("FlipkartPageTesting.java");
		
	}
	@Test
	public void testingDropdownAndRadioButton() {
		BasicConfigurator.configure();
		PropertyConfigurator.configure("log4j.properties");
		driver.get(urlDrop);
		logger.info("url has opened");
		WebElement dropDown = driver.findElement(By.xpath("//*[@id=\"post-2646\"]/div[2]/div/div/div/p/select"));
		Select sc = new Select(dropDown);
		logger.info("dropdown feature came");
		sc.selectByIndex(35);
		logger.info("selected 35th country from the list");
	}
	@Test
	public void tableHandle() {
		driver.get("https://testsigma.com/blog/decision-table-testing/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement table = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/section[2]/div[1]/div[3]/div/div/div/figure[1]"));
		js.executeScript("arguments[0].scrollIntoView()", table);
		List<WebElement> rows = table.findElements(By.xpath("//*[@id=\"__next\"]/main/section[2]/div[1]/div[3]/div/div/div/figure[1]/table/tbody/tr"));
		System.out.println("number of rows"+rows.size());
		for (WebElement row:rows) {
			List<WebElement> cols = driver.findElements(By.xpath("//*[@id=\"__next\"]/main/section[2]/div[1]/div[3]/div/div/div/figure[1]/table/tbody/tr[2]/td"));
			for (WebElement col:cols) {
				System.out.println(col.getText());
			}
			
		}
		
	}
	@Test
	public void frameHandle() {
		driver.get("https://www.globalsqa.com/demo-site/frames-and-windows/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.findElement(By.xpath("//*[@id=\"iFrame\"]")).click();
		
		js.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath("//*[@id=\"post-2632\"]/div[2]")));
		driver.switchTo().frame(1);
		driver.findElement(By.xpath("//*[@id=\"portfolio_items\"]/div[1]/a/div/div/div[2]/div")).click();
		
		
	}
	@Test
	public void WindowsHandellerTest() {
		driver.get("https://demo.automationtesting.in/Windows.html");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		if(driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[1]/a")).isSelected()) {
			driver.findElement(By.xpath("//*[@id=\"Tabbed\"]/a/button")).click();
		}else {
			driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[1]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"Tabbed\"]/a/button")).click();
		}
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"Seperate\"]/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"Multiple\"]/button")).click();
		Set<String> WindowHandles = driver.getWindowHandles();
		String parent = driver.getWindowHandle();
		System.out.println(WindowHandles.size());
		Iterator<String> I1=WindowHandles.iterator();
		while(I1.hasNext()) {
			String child_window = I1.next();
			if(!WindowHandles.equals(child_window)) {
				driver.switchTo().window(child_window);
				System.out.println(driver.switchTo().window(child_window).getTitle());
			}
		}
		driver.switchTo().window(parent);
		Integer temp=0;
        
        String msg=null;
        
        //Iterate through all the available windows
        for (String string : WindowHandles) {
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
          //WebElement Bankname = driver.findElement(By.xpath("//*[@id=\"email\"]"));
          System.out.println(driver.getTitle()+" Bank");
        }
        else if (temp == 0) {
          System.out.println("Desired Window not found.");
        }
		
	}
	@Test
	public void HandleAlert() {
		driver.get("https://demo.automationtesting.in/Index.html");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("john@example.com");
		driver.findElement(By.xpath("//*[@id=\"enterimg\"]")).click();
		WebElement header = driver.findElement(By.xpath("//*[@id=\"header\"]/nav/div/div[2]/ul/li[4]/a"));
		WebElement alertTab = driver.findElement(By.xpath("//*[@id=\"header\"]/nav/div/div[2]/ul/li[4]/ul/li[1]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(header).perform();
		action.moveToElement(alertTab).click().build().perform();
		if(driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[1]/a")).isSelected()) {
			driver.findElement(By.xpath("//*[@id=\"OKTab\"]/button")).click();
		}else {
			driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[1]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"OKTab\"]/button")).click();
		}
		driver.switchTo().alert().accept();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a"))));
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"CancelTab\"]/button")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().dismiss();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"Textbox\"]/button")).click();
		driver.switchTo().alert().sendKeys("souvik");
		driver.switchTo().alert().accept();
	}
	@Test
	public void DragAndDropTest() throws IOException {
		driver.get("https://demo.automationtesting.in/Static.html");
		//WebElement dragElement = driver.findElement(By.xpath("//*[@id=\"angular\"]"));
		WebElement dropElement = driver.findElement(By.xpath("//*[@id=\"droparea\"]"));
		Actions action = new Actions(driver);
		//action.dragAndDrop(dragElement, dropElement).build().perform();
		List<WebElement> dragElements = driver.findElements(By.xpath("//*[@id=\"dragarea\"]"));
		for(WebElement drag:dragElements) {
			action.dragAndDrop(drag, dropElement).build().perform();
			
		//take screenshots	
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile,new File("src/test/java/screenshot.png"));
			
		
		}
	}
	@Test
	public void AjaxTest() throws InterruptedException {
		driver.get("https://demo.automationtesting.in/Index.html");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("john@example.com");
		driver.findElement(By.xpath("//*[@id=\"enterimg\"]")).click();
		WebElement header = driver.findElement(By.xpath("//*[@id=\"header\"]/nav/div/div[2]/ul/li[7]/a"));
		WebElement video = driver.findElement(By.xpath("//*[@id=\"header\"]/nav/div/div[2]/ul/li[7]/ul/li[2]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(header).perform();
		action.moveToElement(video).click().build().perform(); 
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"player\"]/div[7]/div[9]/div[1]"))));
		driver.findElement(By.xpath("//*[@id=\"player\"]/div[7]/div[9]/div[1]")).click();
		
	}
	@Test
	public void dynamicElementTests() {
		driver.get("https://indianexpress.com/");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"HP_TOP_NEWS\"]/div[2]/div/ul/li[1]/h3/a"))));
		String news = driver.findElement(By.xpath("//*[@id=\"HP_TOP_NEWS\"]/div[2]/div/ul/li[1]/h3/a")).getText();
		System.out.println(news);
		wait.until(ExpectedConditions.alertIsPresent());
		Actions action = new Actions(driver);
		driver.switchTo().alert().dismiss();
	}
	@Test
	public void ExcelTest() throws IOException, InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		String filePath = System.getProperty("C:\\Users\\svksh\\Downloads\\Cred.xlsx");
        
		//File input stream, which needs the input as the file location
		FileInputStream fileStream = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(fileStream);
		XSSFSheet sheet = workbook.getSheet("Credentials");
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		  for (int i = 1; i <= rowCount; i++) {
			  System.out.println(rowCount);
			    driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")) .sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
			    driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")) .sendKeys(sheet.getRow(i).getCell(1).getStringCellValue());
				driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
				String message =driver.findElement(By.xpath("///*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText();
				System.out.println(message);
//				driver.findElement(By.linkText("LogOut")).click();
			}
			                    }
	}


