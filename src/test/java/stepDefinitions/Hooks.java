package stepDefinitions;

import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {

	TestContextSetup testContextSetup;
	
	public Hooks(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}
	
	@After
	public void afterScenario() throws Exception {
		WebDriver driver = testContextSetup.testBase.webBrowserManager();
		driver.quit();
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario) throws Exception {
		System.out.println(scenario.isFailed());
		if(scenario.isFailed()) {
			WebDriver driver = testContextSetup.testBase.webBrowserManager();
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(source);
			scenario.attach(fileContent, "image/png", "image");
			
//			File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//			BufferedImage img = ImageIO.read(screen);
//			File fileTest = Paths.get(".").toAbsolutePath().normalize().toFile();
//			ImageIO.write(img, "png", new File(fileTest + "\\Screenshots\\" + "Test.png"));
//			byte[] fileContent = FileUtils.readFileToByteArray(fileTest);
//			scenario.attach(fileContent, "image/png", "image");
		}
	}
	
}
