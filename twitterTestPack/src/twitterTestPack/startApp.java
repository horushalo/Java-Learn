package twitterTestPack;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.*;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class startApp {

	private AppiumDriver driver;
	WebElement element;

	@Before
	public void setUp() throws MalformedURLException{

	File classpathRoot = new File(System.getProperty("user.dir"));
	File appDir = new File(classpathRoot, "/Twitter");
	File app = new File(appDir, "com.twitter.android-2.apk");

	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability(CapabilityType.BROWSER_NAME, ""); //Name of mobile web browser to automate. Should be an empty string if automating an app instead.
	capabilities.setCapability("platformName", "Android");
	capabilities.setCapability(CapabilityType.VERSION, "5.1.0");
	capabilities.setCapability("deviceName", "192.168.134.101:5555");
	capabilities.setCapability("app", app.getAbsolutePath());
	capabilities.setCapability("appPackage", "com.twitter.android");
	capabilities.setCapability("appActivity", ".StartActivity");
	driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
	
	@After
	public void aftertest() {
		driver.quit(); 
	}
	
	@Test  
    public void installLargeWidget() throws Exception {  

	   	System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
	   	
	   	driver.navigate().back();
	   	element = driver.findElement(By.name("Apps"));
	   	element.click();
	   	
	   	element = driver.findElement(By.name("Widgets"));
	   	element.click();
	   	
	   	boolean exit = false;
	   	while(!exit)
	   	{
	   		element = null;
	   		try
	   		{
	   			element = driver.findElement(By.name("Twitter (large)"));
	   		}
	   		catch (Exception ex){}
	   		if(element==null)
	   		{
	   			Dimension size = driver.manage().window().getSize();
		   		int startx = (int) (size.width * 0.8); 
		   		int endx = (int) (size.width * 0.20); 
		   		int starty = size.height / 2; 
		   		driver.swipe(startx, starty, endx, starty, 1000);
	   		}
	   		else exit = true;
	   	}	   	
	   	
	   	TouchAction action = new TouchAction(driver);
	   	action.longPress(element).release().perform();
	   	
	   	System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());

    }
	
	@Test
	public void invalid_LogIn() throws Exception {
		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
		
		element = driver.findElement(By.name("Log in"));
		element.click();
		
		List<WebElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
		textFieldsList.get(0).sendKeys("lol@mail.ru");
		textFieldsList.get(1).sendKeys("123456");
		
		element = driver.findElement(By.name("Log in"));
		element.click();
		
		Thread.sleep(3000);
		
		try
		{
			element = driver.findElement(By.name("Log in"));
			Assert.assertNotNull(element);
		}
		catch(Exception e){
			Assert.fail();
		}
		
		
		System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	}
	
}