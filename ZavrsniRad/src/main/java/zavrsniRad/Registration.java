package zavrsniRad;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class Registration {

	String RegUrl = "http://automationpractice.com/index.php?controller=authentication&multi-shipping=0&display_guest_checkout=0&back=http%3A%2F%2Fautomationpractice.com%2Findex.php%3Fcontroller%3Dorder%26step%3D1%26multi-shipping%3D0";

	WebElement email, createAcc, gender, firstName, lastName, password, days, month, year, firstName1, lastName1,
			address, city, state, code, country, phone, alias, register, btn, signOut, signIn, existEmail,
			existPassword, btnSignIn;

	public void enterEmail(WebDriver driver, String mojEmail) {
		email = driver.findElement(By.id("email_create"));
		email.click();
		email.sendKeys(mojEmail);
	}

	public void create(WebDriver driver) {
		createAcc = driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span"));
		createAcc.click();
	}

	public void setGender(WebDriver driver) {
		gender = driver.findElement(By.id("id_gender2"));
		gender.click();
	}

	public void setFirstName(WebDriver driver, String mojeIme) {
		firstName = driver.findElement(By.id("customer_firstname"));
		firstName.click();
		firstName.sendKeys(mojeIme);
	}

	public void setLastName(WebDriver driver, String mojePrezime) {
		lastName = driver.findElement(By.id("customer_lastname"));
		lastName.click();
		lastName.sendKeys(mojePrezime);
	}

	public void setPassword(WebDriver driver, String mojPasvord) {
		password = driver.findElement(By.id("passwd"));
		password.click();
		password.sendKeys(mojPasvord);
	}

	public void setDays(WebDriver driver) {
		days = driver.findElement(By.id("days"));

		Select dan = new Select(days);
		dan.selectByValue("27");
	}

	public void setMonth(WebDriver driver) {
		month = driver.findElement(By.id("months"));

		Select mesec = new Select(month);
		mesec.selectByValue("7");
	}

	public void setYear(WebDriver driver) {
		year = driver.findElement(By.id("years"));

		Select godina = new Select(year);
		godina.selectByValue("1993");
	}

	public void setFirstName1(WebDriver driver, String mojeIme) {
		firstName1 = driver.findElement(By.id("firstname"));
		firstName1.click();
		firstName1.sendKeys(mojeIme);
	}

	public void setLastName1(WebDriver driver, String mojePrezime) {
		lastName1 = driver.findElement(By.id("lastname"));
		lastName1.click();
		lastName1.sendKeys(mojePrezime);
	}

	public void setAddress(WebDriver driver, String mojaAdresa) {
		address = driver.findElement(By.id("address1"));
		address.click();
		address.sendKeys(mojaAdresa);
	}

	public void setCity(WebDriver driver, String mojGrad) {
		city = driver.findElement(By.id("city"));
		city.click();
		city.sendKeys(mojGrad);
	}

	public void setState(WebDriver driver, int myState) {
		state = driver.findElement(By.id("id_state"));
		Select drzava = new Select(state);
		drzava.selectByIndex(myState);
	}

	public void setPostCode(WebDriver driver, double postanskiBroj) {
		code = driver.findElement(By.id("postcode"));
		code.click();
		int zip = (int) postanskiBroj;
		code.sendKeys(String.valueOf(zip));
	}

	public void setCountry(WebDriver driver) {
		country = driver.findElement(By.id("id_country"));
		Select drzava = new Select(country);
		drzava.selectByValue("21");
	}

	public void setPhone(WebDriver driver, String brTelefona) {
		phone = driver.findElement(By.id("phone_mobile"));
		phone.click();
		phone.sendKeys(brTelefona);
	}

	public void setAlias(WebDriver driver, String altAdresa) {
		alias = driver.findElement(By.id("alias"));
		alias.click();
		alias.sendKeys(altAdresa);
	}

	public void buttonReg(WebDriver driver) {
		register = driver.findElement(By.xpath("//*[@id=\"submitAccount\"]/span"));
		register.click();
	}

	public String btnReg(WebDriver driver) {
		btn = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));
		String ime = btn.getText();
		return ime;
	}

	public String btnSignOut(WebDriver driver) {
		signOut = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a"));
		String odjava = signOut.getText();
		return odjava;
	}

	public void signIn(WebDriver driver) {
		signIn = driver.findElement(By.xpath("//a[@title='Log in to your customer account']"));
		signIn.click();
	}

	public void signOut(WebDriver driver) {
		signOut = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a"));
		signOut.click();
	}

	public void ubaci30(WebDriver driver) throws IOException, InterruptedException {
		FileInputStream fis = new FileInputStream("src/test/resources/dok1.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		SoftAssert sa = new SoftAssert();

		for (int i = 5; i < 30; i++) {
			Row row = sheet.getRow(i);
			Cell cell;

			enterEmail(driver, row.getCell(0).getStringCellValue());
			create(driver);
			setFirstName(driver, row.getCell(1).getStringCellValue());
			setLastName(driver, row.getCell(2).getStringCellValue());
			setPassword(driver, row.getCell(3).getStringCellValue());
			setFirstName1(driver, row.getCell(4).getStringCellValue());
			setLastName1(driver, row.getCell(5).getStringCellValue());
			setAddress(driver, row.getCell(6).getStringCellValue());
			setCity(driver, row.getCell(7).getStringCellValue());
			setState(driver, i);
			setPostCode(driver, row.getCell(9).getNumericCellValue());
			setCountry(driver);
			setPhone(driver, row.getCell(11).getStringCellValue());
			setAlias(driver, row.getCell(12).getStringCellValue());
			buttonReg(driver);

			String imePrezime = row.getCell(1).getStringCellValue() + " " + row.getCell(2).getStringCellValue();
			sa.assertEquals(btnReg(driver), imePrezime);
			sa.assertEquals(btnSignOut(driver), "Sign out");
			Thread.sleep(1000);
			signOut(driver);
			driver.get(Menu.URL_STRANICE);
			signIn(driver);
		}

		sa.assertAll();

	}

	public void setExistEmail(WebDriver driver, String email) {
		existEmail = driver.findElement(By.id("email"));
		existEmail.sendKeys(email);
	}

	public void setExistPassword(WebDriver driver, String password) {
		existPassword = driver.findElement(By.id("passwd"));
		existPassword.sendKeys(password);
	}

	public void buttonSignIn(WebDriver driver) {
		btnSignIn = driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span"));
	}

}
