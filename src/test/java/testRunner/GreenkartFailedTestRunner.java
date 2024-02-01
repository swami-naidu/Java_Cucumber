package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "@target/failed_scenarios.txt",
		glue = "stepDefinitions",
		monochrome = true,
		dryRun = false,
		plugin = {"html:target/cucumber.html",
				"json:target/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class GreenkartFailedTestRunner extends AbstractTestNGCucumberTests {

}
