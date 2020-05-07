package zavrsniRad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SummerDresses {

	String summerDressesUrl="http://automationpractice.com/index.php?id_category=11&controller=category";
	WebElement dress, button,size,colour,addToCard,proceedToCheckout,name,number,check,proceedToCheckout1;
	
	public void clickFirstDress(WebDriver driver) {
		dress=driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img"));
		dress.click();
	}
	
	public void clickNumberOfDresses (WebDriver driver) {
		button=driver.findElement(By.xpath("//*[@id=\"quantity_wanted_p\"]/a[2]"));
		button.click();
	}
	
	public void setSizeM (WebDriver driver) {
		size=driver.findElement(By.id("group_1"));
		Select sizeM=new Select (size);
		sizeM.selectByIndex(1);
	}
	
	public void setColour(WebDriver driver) {
		colour=driver.findElement(By.id("color_14"));
		colour.click();
	}
	
	public void addToCard(WebDriver driver) {
		addToCard=driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span"));
		addToCard.click();
	}
	
	public void checkout (WebDriver driver) {
		proceedToCheckout=driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span"));
		proceedToCheckout.click();
	}
	
	public String nameDresses(WebDriver driver) {
		name=driver.findElement(By.xpath("//*[@id=\"product_5_24_0_0\"]/td[2]/p/a"));
		String ime=name.getText();
		return ime;
		}
	
	public String numberDresses (WebDriver driver) {
		number=driver.findElement(By.xpath("//*[@id=\"product_5_24_0_0\"]/td[5]/input[2]"));
		String broj=number.getAttribute("value");
		return broj;
	}
	
	public String checkTheColourAndSize (WebDriver driver) {
		check=driver.findElement(By.xpath("//*[@id=\"product_5_24_0_0\"]/td[2]/small[2]/a"));
		String velicinaIBoja=check.getText();
		return velicinaIBoja;
	}
	
	public void checkout1 (WebDriver driver) {
		proceedToCheckout1=driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span"));
		proceedToCheckout1.click();
	}
}
