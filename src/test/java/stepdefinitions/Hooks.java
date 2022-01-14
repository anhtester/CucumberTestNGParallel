package stepdefinitions;

import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import report.AllureManager;

public class Hooks extends BaseStepDef {

    public Hooks(TestContext context) {
        super(context);
    }

    @Before
    public void beforeScenario() {
        System.out.println("Starting Driver: " + driver);
    }

    @After
    public void afterScenario(Scenario scenario) {
        //validate if scenario has failed then Screenshot
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot Failed");

            //Screenshot in Allure Report
            //AllureManager.saveScreenshotPNG(driver);
        }
        System.out.println("Stop Driver: " + driver);
        driver.quit();
    }

}
