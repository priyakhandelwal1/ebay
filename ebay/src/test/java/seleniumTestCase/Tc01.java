package seleniumTestCase;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Tc01 {
	
public static void main(String[] args) throws InterruptedException {
	

	
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Downloads\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver= new ChromeDriver();



	driver.manage().window().maximize();
	Thread.sleep(1000);

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("http://www.ebay.com");

	WebElement signINBtn =driver.findElement(By.xpath("(//a[text()='Sign in'])[1]"));
	signINBtn.click();

	Thread.sleep(1000);
	WebElement userNameText =driver.findElement(By.xpath("//input[@id='userid']"));
	userNameText.sendKeys("priyatambi20@gmail.com");



	Thread.sleep(1000);
	WebElement continueINBtn =driver.findElement(By.xpath("//button[@id='signin-continue-btn']"));
	continueINBtn.click();

	Thread.sleep(1000);
	WebElement passwordText =driver.findElement(By.xpath("//input[@id='pass']"));
	passwordText.sendKeys("ebay@123");

	Thread.sleep(1000);
	WebElement signInBtn =driver.findElement(By.xpath("//button[@id='sgnBt']"));
	signInBtn.click();


	Thread.sleep(1000);
	WebElement searcHBOX =driver.findElement(By.xpath("//input[@type='text']"));
	searcHBOX.sendKeys("computer");

	Thread.sleep(1000);
	WebElement searchBtn =driver.findElement(By.xpath("//input[@type='submit']"));
	searchBtn.click();

	Thread.sleep(1000);
	//WebElement firstItem =driver.findElement(By.xpath("(//div[@class=\"s-item__title\"])[2]"));
	WebElement firstItem =driver.findElement(By.xpath("((//div[@id='mainContent']//span[@role='heading'])[2]"));
	searchBtn.click();

			}}
