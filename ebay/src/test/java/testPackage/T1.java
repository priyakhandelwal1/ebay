package testPackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import pomClasses.HeaderPage;
import pomClasses.Productpage;
import pomClasses.ShoppingCartPage;
import pomClasses.Signinpage;
import pomClasses.SpecificProductpage;

public class T1 {
	//Globally variables
	private WebDriver driverTest;
	private HeaderPage headerPage;
	private Signinpage signinpage;
	private Productpage productpage;
	private SpecificProductpage specificProductpage;
	private JavascriptExecutor js;
	private ShoppingCartPage shoppingCartPage;

	@Parameters("browser123")

	@BeforeTest
	public void launchBrowser(String browser)
	{System.out.println("BeforeTest to launch browser");

	if(browser.equals("chrome"))
	   {System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Downloads\\Velocity\\Selenium\\drivers\\chromedriver.exe");
	   driverTest= new ChromeDriver();
	   driverTest.manage().window().maximize();
	   driverTest.get("http://www.amazon.in/");}

//	if(browser.equals("firefox"))
//	{System.setProperty("webdriver.gecko.driver", "C:\\Users\\USER\\Downloads\\Velocity\\Selenium\\drivers\\geckodriver.exe");
//	driverTest= new FirefoxDriver();
//	driverTest.manage().window().maximize();
//	driverTest.get("http://www.amazon.in/");}

//	if(browser.equals("msedge"))
//	{System.setProperty("webdriver.msedgedriver.driver", "C:\\Users\\USER\\Downloads\\Velocity\\Selenium\\drivers\\msedgedriver.exe");
//	driverTest= new EdgeDriver();
//	driverTest.manage().window().maximize();
//	driverTest.get("http://www.amazon.in/");}
//	}

   @BeforeClass
	public void beforeclass()
	{System.out.println("BeforeClass to AllObject create and globally ref variables create");

	headerPage =new HeaderPage(driverTest);
	signinpage=new Signinpage(driverTest);
	productpage=new Productpage(driverTest);
	specificProductpage=new SpecificProductpage(driverTest);
	js=(JavascriptExecutor)driverTest;
	shoppingCartPage =new ShoppingCartPage(driverTest);}
		
	@BeforeMethod
	public void beforemethod() throws InterruptedException
	{System.out.println("BeforeMethod Annotation");

	//step 3 click on account list and click on sign in
	headerPage.clickonaccountntandlistandClickSignIn();

	// step 4 enter email,click on  continue btn ,enter password and click on sign in  btn
	signinpage.clickonemailormobno("9309227854");
	signinpage.clickoncontinuebtn();
	signinpage.clickonpasswordbtn("Shlok123");
	signinpage.clickonsigninbtn();}
		
		
	@Test(priority=0)
	public void tc01() throws InterruptedException
	{ System.out.println("Test Annotation");

	//5 Search product
	headerPage.clickonsearchbox("mobile");
	headerPage.clickonsearchbtn();

	//Step 6 select first product from display list
	productpage.clickonfirstResult();

	//step 7 shift driver focus to new window
	ArrayList<String> addr = new ArrayList<String>(driverTest.getWindowHandles());
	driverTest.switchTo().window(addr.get(1));

	//Step 8 take price of specific product and print
	String originalPrice= specificProductpage.getpriceOfProduct();
	System.out.println(originalPrice);
			
	//step 9  scroll down 
	js.executeScript("window.scrollBy(0,400)");

	//step 10 click on add to cart Btn
	Thread.sleep(2000);
	specificProductpage.clickonAdd2cart();
	Thread.sleep(2000);
	//specificProductpage.clickcloseBtnofCartPopup();

	//step 11  click on cart tab
	headerPage.clickonCartTab();

	//Step 12 take price of specific product and print From Cart 
	String cartProductPrice=shoppingCartPage.getPriceofProductInCart();
	System.out.println(cartProductPrice);



	//Step 13 Compare original product price and Cart Product Price
	if(originalPrice.equals(cartProductPrice))
	{System.out.println("Test Pass");}
	else
	{System.out.println("Test Fail");}

	//Step 14 go to drop down and select 0 for deleting the product
	shoppingCartPage.clickonDeleteBtnIncartandDeleteProduct();}
		
		
	@AfterMethod
	public void afterMthod() throws InterruptedException
	{System.out.println("After Method Annotation");
	headerPage.clickOnACListandClickSignOut();}

	@AfterClass
	public void afterClass()
	{System.out.println("AfterClass Annotation to make null all object ref");	
	driverTest =null;
	headerPage =null;
	signinpage =null;
	productpage =null;
	specificProductpage =null;
	js =null;
	shoppingCartPage =null;    }

	@AfterTest
	public void afterTest()
	{System.out.println();
	driverTest.quit();
	driverTest=null;
	System.gc();//Garbage Collector of unused objects
	}
				
		

	}
}
