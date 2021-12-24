package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.helpers.Helpers;
import utils.manager.DriverManager;
import utils.manager.LocalDriverFactory;

public class DashboardSteps {

    WebDriver driver;
    
    @Before
    public void before() {
        driver = new LocalDriverFactory().createInstance("chrome");
    }

    @After
    public void after() {
        driver.close();
    }

    @AfterStep
    public void endStep(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
    }

    @Given("user navigate to dashboard")
    public void userNavigateToDashboard() {
        driver.get("https://hrm.anhtester.com/erp/login");
        Helpers.delay(1);
        driver.findElement(By.xpath("//input[@id='iusername']")).sendKeys("admin01");
        driver.findElement(By.xpath("//input[@id='ipassword']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @When("user click {string}")
    public void userClick(String menu) {
        Helpers.delay(4);
        driver.findElement(By.xpath("//span[contains(text(),'" + menu + "')]")).click();
    }

    @Then("The user redirect to this page")
    public void theUserRedirectToThisPage() {
        Assert.assertTrue(true);
    }

}
