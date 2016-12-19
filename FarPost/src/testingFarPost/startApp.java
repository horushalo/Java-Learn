package testingFarPost;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import java.io.File;

import org.junit.*; // ����� �������� ��� ���� ������
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension; // ������ �� �����������
import org.openqa.selenium.WebElement; // ������ � ���-����������
import org.openqa.selenium.remote.CapabilityType; // ��� ����� ����������
import org.openqa.selenium.remote.DesiredCapabilities; // ��� ����� ��������� �� ����������
import io.appium.java_client.android.AndroidDriver; // ������� �������� �� �������
import io.appium.java_client.AppiumDriver; // ��� ������
import io.appium.java_client.TouchAction; // ����������� ��� ���������


public class startApp {

	private AppiumDriver driver; // �������������� ���� � ����� ������� �������, ����� ����������� ���
	WebElement element;
	
	@Before
	public void setUp() throws Exception {
		
		// ����������� ������ �� ����������� ����������
		File appDirRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(appDirRoot, "/farpost");
		File app = new File(appDir, "app-debug.apk");
				
		// ������� ����������
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, ""); // �� ��������� ������, �� ������ ����������, � �� ����
		capabilities.setCapability(CapabilityType.VERSION, "5.1.0"); // ������ ��������
		capabilities.setCapability(CapabilityType.PLATFORM, "Android"); // ��������� � ��� �������
		// ����������� �����������
		capabilities.setCapability("deviceName", "192.168.118.101:5555"); // ����� ����� ������� �� ��������
		capabilities.setCapability("app", app.getAbsolutePath()); // ��� �� ��������� (����� �� ���������� app)
		// ������ ����� � �������� ������������ - com.vbanthia.androidsampleapp.MainActivity
		capabilities.setCapability("appPackage", "com.vbanthia.androidsampleapp"); // ��� ������
		capabilities.setCapability("appActivity", ".MainActivity"); // ��� ��������
		// ������ ���� ���� ������ ��������� �������� ��� �������� �� �������, ����� �������� ��� ���������� � ������ �� ������ �������� ���������� �������
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
	
	// ������� ����� ���� �����. ���, ��������.
	
	
	@Test
	// ���������� � ��������� ������� ��� ���� ���
	// ��� ����� ��� ����� ����� ���� ����� � ������ ��������, � ���� ��� ������� ������ ������ �� Android SDK - uiautomatorviewer
	// ��������� ���������� � ��������� � ��������, ������� �� id ���������
	// ������ ���� - com.vbanthia.androidsampleapp:id/inputFieldLeft
	// ������ ���� - com.vbanthia.androidsampleapp:id/inputFieldRight
	// ����� ������������ - com.vbanthia.androidsampleapp:id/additionButton
	// ������� ������������� - com.vbanthia.androidsampleapp:id/resultTextView
	// ����� ������������� - com.vbanthia.androidsampleapp:id/resetButton
	public void simpleMath() throws Exception {
		// ����� �� ��������� ��� ������ �������, ������ �� ������� �� � element
		
		element = driver.findElement(By.id("com.vbanthia.androidsampleapp:id/inputFieldLeft"));
		element.sendKeys("2");
		
		element = driver.findElement(By.id("com.vbanthia.androidsampleapp:id/inputFieldRight"));
		element.sendKeys("2");
		
		element = driver.findElement(By.id("com.vbanthia.androidsampleapp:id/additionButton"));
		element.click();
		
		WebElement result = driver.findElement(By.id("com.vbanthia.androidsampleapp:id/resultTextView"));
		
		if (result.getText().equals("2.00 + 2.00 = 4.00")) {
			System.out.println("���������");
		} else {
			System.out.println("������");
		}


	}
	
	// ����������� ������������, ��������� ����������
	
	@After
	
	public void atTheEnd (){
		driver.close();
		driver.quit();
	}
	
}
