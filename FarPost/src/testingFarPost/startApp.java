package testingFarPost;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import java.io.File;

import org.junit.*; // набор ништяков для юнит тестов
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension; // работа по координатам
import org.openqa.selenium.WebElement; // работа с веб-элементами
import org.openqa.selenium.remote.CapabilityType; // тут живут капабилити
import org.openqa.selenium.remote.DesiredCapabilities; // тут живут стредства их назначения
import io.appium.java_client.android.AndroidDriver; // драйвер андроида из аппиума
import io.appium.java_client.AppiumDriver; // сам аппиум
import io.appium.java_client.TouchAction; // инструменты для тачскрина


public class startApp {

	private AppiumDriver driver; // инициализируем себе в класс драйвер аппиума, далее настраиваем его
	WebElement element;
	
	@Before
	public void setUp() throws Exception {
		
		// настраиваем аппиум на тестируемое приложение
		File appDirRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(appDirRoot, "/farpost");
		File app = new File(appDir, "app-debug.apk");
				
		// херачим капабилити
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, ""); // Не указываем ничего, мы тестим приложение, а не сайт
		capabilities.setCapability(CapabilityType.VERSION, "5.1.0"); // Версия андроида
		capabilities.setCapability(CapabilityType.PLATFORM, "Android"); // Платформа у нас андроид
		// настраиваем подключение
		capabilities.setCapability("deviceName", "192.168.118.101:5555"); // нужно чтобы попасть на эмулятор
		capabilities.setCapability("app", app.getAbsolutePath()); // что мы запускаем (берем из переменной app)
		// дампим пакет и получаем ланчактивити - com.vbanthia.androidsampleapp.MainActivity
		capabilities.setCapability("appPackage", "com.vbanthia.androidsampleapp"); // имя пакета
		capabilities.setCapability("appActivity", ".MainActivity"); // имя активити
		// делаем себе свой личный экземпляр драйвера для андроида из аппиума, сразу передаем ему капабилити и травим на аппиум согласно инструкции аппиума
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
	
	// каждому тесту свой класс. ура, товарищи.
	
	
	@Test
	// Напряжемся и попробуем сложить два плюс два
	// Для этого нам нужно найти поля ввода и кнопку сложения, в этом нам поможет сраный батник из Android SDK - uiautomatorviewer
	// Запускаем приложение в эмуляторе и тыкаемся, смотрим на id элементов
	// первое поле - com.vbanthia.androidsampleapp:id/inputFieldLeft
	// второе поле - com.vbanthia.androidsampleapp:id/inputFieldRight
	// кнопь слагательная - com.vbanthia.androidsampleapp:id/additionButton
	// полюшко результатовое - com.vbanthia.androidsampleapp:id/resultTextView
	// кнопь очистительная - com.vbanthia.androidsampleapp:id/resetButton
	public void simpleMath() throws Exception {
		// чтобы не обьявлять зря лишние обьекты, пихаем по очереди всё в element
		
		element = driver.findElement(By.id("com.vbanthia.androidsampleapp:id/inputFieldLeft"));
		element.sendKeys("2");
		
		element = driver.findElement(By.id("com.vbanthia.androidsampleapp:id/inputFieldRight"));
		element.sendKeys("2");
		
		element = driver.findElement(By.id("com.vbanthia.androidsampleapp:id/additionButton"));
		element.click();
		
		WebElement result = driver.findElement(By.id("com.vbanthia.androidsampleapp:id/resultTextView"));
		
		if (result.getText().equals("2.00 + 2.00 = 4.00")) {
			System.out.println("Нормально");
		} else {
			System.out.println("Ошибка");
		}


	}
	
	// заканчиваем тестирование, закрываем соединение
	
	@After
	
	public void atTheEnd (){
		driver.close();
		driver.quit();
	}
	
}
