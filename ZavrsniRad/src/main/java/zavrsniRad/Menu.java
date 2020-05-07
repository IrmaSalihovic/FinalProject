package zavrsniRad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Menu {

	public static final String URL_STRANICE="http://automationpractice.com/index.php";
	public static String xPathWoman ="//a[@title='Women']";
	public static String xPathSummerDresses="//a[@title='Summer Dresses']";
	public static String xPathDresses="//*[@id=\"block_top_menu\"]/ul/li[2]/a";
	public static String xPathButtonSummerDresses="//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[3]/a";
	
	public static void openHomePage (WebDriver driver) {
		driver.get(URL_STRANICE);
		driver.manage().window().maximize();
	}
	
	public static void mouseOverWomen (WebDriver driver) {
		WebElement woman= driver.findElement(By.xpath(xPathWoman));
		Actions action = new Actions (driver);
		action.moveToElement(woman).perform();
		
	}
	
	public static void clickSummerDresses (WebDriver driver) {
		WebElement summerDresses=driver.findElement(By.xpath(xPathSummerDresses));
		summerDresses.click();
		
	}
	
	public static void mouseOverDresses (WebDriver driver) {
		WebElement dresses=driver.findElement(By.xpath(xPathDresses));
		Actions action = new Actions (driver);
		action.moveToElement(dresses).perform();
	}
	
	public static void clickSummerDresses1 (WebDriver driver) {
		WebElement summerDresses=driver.findElement(By.xpath(xPathButtonSummerDresses));
		summerDresses.click();
	}
	
}
