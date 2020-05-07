package zavrsniRad;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class SummerDressesTest extends SummerDresses {
	
	WebDriver driver;
	
	@BeforeClass
	  public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.get(summerDressesUrl);
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  }
	
  @Test
  public void test() {
	  clickFirstDress(driver);
	  clickNumberOfDresses(driver);
	  setSizeM(driver);
	  setColour(driver);
	  addToCard(driver);
	  checkout(driver);
	  
	  SoftAssert sa = new SoftAssert();
	  sa.assertEquals(nameDresses(driver), "Printed Summer Dress");
	  sa.assertEquals(numberDresses(driver), "2");
	  sa.assertEquals(checkTheColourAndSize(driver), "Color : Blue, Size : M");
	  sa.assertAll();
	  checkout1(driver);
  }
  

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
