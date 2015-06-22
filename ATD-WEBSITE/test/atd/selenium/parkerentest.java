package atd.selenium;

import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class parkerentest {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:8080";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl + "/ATD-WEBSITE/index.jsp");
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("klantje");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("klant");
		driver.findElement(By.xpath("//input[@value='aanmelden']")).click();
	}

	@Test
	public void testCsv() throws Exception {
		String csvFile = "test/atd/selenium/Inloggenuser.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] entry = line.split(cvsSplitBy);
				
			    driver.findElement(By.linkText("Parkeren")).click();
			    driver.findElement(By.id("datepicker_aankomst")).clear();
			    driver.findElement(By.id("datepicker_aankomst")).sendKeys("2015-06-23");
			    driver.findElement(By.id("datepicker_vertrek")).clear();
			    driver.findElement(By.id("datepicker_vertrek")).sendKeys("2015-06-25");
			    driver.findElement(By.name("run")).click();
			    driver.findElement(By.id("datepicker_aankomst")).clear();
			    driver.findElement(By.id("datepicker_aankomst")).sendKeys("2015-06-20");
			    driver.findElement(By.id("datepicker_vertrek")).clear();
			    driver.findElement(By.id("datepicker_vertrek")).sendKeys("2015-06-21");
			    driver.findElement(By.name("run")).click();
			    driver.findElement(By.id("datepicker_aankomst")).clear();
			    driver.findElement(By.id("datepicker_aankomst")).sendKeys();
			    driver.findElement(By.id("datepicker_vertrek")).clear();
			    driver.findElement(By.id("datepicker_vertrek")).sendKeys("2015-06-25");
			    driver.findElement(By.name("run")).click();
			    driver.findElement(By.id("datepicker_aankomst")).clear();
			    driver.findElement(By.id("datepicker_aankomst")).sendKeys("2015-06-23");
			    driver.findElement(By.id("datepicker_vertrek")).clear();
			    driver.findElement(By.id("datepicker_vertrek")).sendKeys();
			    driver.findElement(By.name("run")).click();

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
