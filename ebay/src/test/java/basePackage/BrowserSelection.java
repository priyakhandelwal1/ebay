package basePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class BrowserSelection {
	//static WebDriver driver;

	public static WebDriver openChromeBrowser()
	{	System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Downloads\\Velocity\\Selenium\\drivers\\chromedriver.exe"); 
	   WebDriver driver = new ChromeDriver(); 
	   return driver;	} 
		

	public static WebDriver openFirefoxBrowser()
	{	System.setProperty("webdriver.gecko.driver", "C:\\Users\\USER\\Downloads\\Velocity\\Selenium\\drivers\\geckodriver.exe");
	   WebDriver driver = new FirefoxDriver(); 
	   return driver;	} 
		
		
	public static WebDriver openEdgeBrowser()
	{System.setProperty("webdriver.edge.driver", "C:\\Users\\USER\\Downloads\\Velocity\\Selenium\\drivers\\msedgedriver.exe");
	   WebDriver driver = new EdgeDriver(); 
	   return driver;	} 
		
	public static WebDriver openOperaBrowser()
	{	System.setProperty("webdriver.operadriver.driver", "C:\\Users\\USER\\Downloads\\Velocity\\Selenium\\drivers\\operadriver.exe");
	   WebDriver driver = new OperaDriver(); 
	   return driver;	} 

	}
}
