package zavrsniRad;


import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class MenuTest {
	
	WebDriver driver;
	
	 @BeforeClass
	  public void beforeClass() {
		 System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		 driver=new ChromeDriver();
		 Menu.openHomePage(driver);
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// WebDriverWait wait=new WebDriverWait(driver, 3);
	  }
	
  @Test (priority=1)
  public String test() {
	  Menu.mouseOverWomen(driver);
	  Menu.clickSummerDresses(driver);
	  String currentUrl=driver.getCurrentUrl();
	  String expectedUrl="http://automationpractice.com/index.php?id_category=11&controller=category";
	  
	  Assert.assertEquals(currentUrl, expectedUrl);
	  return currentUrl;
  }
  
  @Test (priority=2)
  public String test1 () {
	  Menu.mouseOverDresses(driver);
	  Menu.clickSummerDresses1(driver);
	  String currentUrl=driver.getCurrentUrl();
	  String expectedUrl="http://automationpractice.com/index.php?id_category=11&controller=category";
	  
	  Assert.assertEquals(currentUrl, expectedUrl);
	  return currentUrl;
  }
  
  @Test (priority=3)
  public void test2() {
	  String prva=test();
	  String druga=test1();
	  
	  Assert.assertTrue(prva.equals(druga));
  }
  
  @AfterClass
	public void afterTest() {
		driver.quit();
	}
 
  

}
