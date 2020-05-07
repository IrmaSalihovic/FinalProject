package zavrsniRad;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class RegistrationTest extends Registration {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(RegUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void test() {
		enterEmail(driver, "irma943@gmail.com");
		create(driver);
		setGender(driver);
		setFirstName(driver, "Irma");
		setLastName(driver, "Salihovic");
		setPassword(driver, "irma1234567");
		setDays(driver);
		setMonth(driver);
		setYear(driver);
		setFirstName1(driver, "Irma");
		setLastName1(driver, "Salihovic");
		setAddress(driver, "Branka Momirova 142");
		setCity(driver, "Beograd");
		setState(driver, 11);
		setPostCode(driver, 11210d);
		setCountry(driver);
		setPhone(driver, "0611775746");
		setAlias(driver, "Boska Buhe 2/2");
		buttonReg(driver);

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(btnReg(driver), "Irma Salihovic");
		sa.assertEquals(btnSignOut(driver), "Sign out");
		sa.assertAll();
		
		signOut(driver);

	}

	@Test(priority = 2)
	public void test30Korisnika() throws IOException, InterruptedException {
		driver.navigate().to(Menu.URL_STRANICE);
		signIn(driver);

		ubaci30(driver);
	}

	@Test(priority = 3)
	public void logIn() {
		driver.navigate().to(Menu.URL_STRANICE);
		signIn(driver);
		setExistEmail(driver, "ahylden0@netlog.com");
		setExistPassword(driver, "kjdt03RCN");
		buttonSignIn(driver);
		SoftAssert sa = new SoftAssert();

		sa.assertEquals(btnReg(driver), "Wilmer Scuse");
		sa.assertEquals(btnSignOut(driver), "Sign out");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
