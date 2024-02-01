package utils;

import java.io.FileInputStream;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	WebDriver driver;
	WebDriverWait wait;

	public WebDriver webBrowserManager() throws Exception {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String browserProperties = prop.getProperty("Browser");
		
		String browserMaven = System.getProperty("browser");
		String browser = browserMaven!=null ? browserMaven : browserProperties;
		
		String url = prop.getProperty("URL");
		/*if(driver == null) {
			if(browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver();
				driver = new EdgeDriver();
			}else if(browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(options);
			}else if(browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver();
				driver = new FirefoxDriver();
			}else {
				driver = null;
			}
			driver.get(url);
			driver.manage().window().maximize();
		}*/
		
		//Selenium Grid
		/*DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("edge");
		driver = new RemoteWebDriver(new URL("http://192.168.1.116:4444"), cap);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		System.out.println(driver.getTitle());*/
		
		//BrowserStack
		MutableCapabilities capabilities = new MutableCapabilities();
		String userName = "xxxxxxxxxxxxxxxx", accessKey = "xxxxxxxxxxxxxxxxxxxx";
		driver = new RemoteWebDriver(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), capabilities);
		driver.get(prop.getProperty("URL"));
		
		return driver;
	}
	
	public WebDriverWait webDriverWaitManager() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		return wait;
	}
	
}
