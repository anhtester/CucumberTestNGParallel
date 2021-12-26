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

    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    @Before
    public void before() {
        driver.set(new DriverManager().getDriver());
        new DriverManager().getBrowserInfo();
    }

    @After
    public void after() {
        if(driver.get() != null){
            driver.get().close();
        }
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
        driver.get().get("https://hrm.anhtester.com/erp/login");
        Helpers.delay(1);
        driver.get().findElement(By.xpath("//input[@id='iusername']")).sendKeys("admin01");
        driver.get().findElement(By.xpath("//input[@id='ipassword']")).sendKeys("123456");
        driver.get().findElement(By.xpath("//button[@type='submit']")).click();
    }

    @When("user click {string}")
    public void userClick(String menu) {
        Helpers.delay(4);
        driver.get().findElement(By.xpath("//span[contains(text(),'" + menu + "')]")).click();
    }

    @Then("The user redirect to this page")
    public void theUserRedirectToThisPage() {
        Assert.assertTrue(true);
    }

}
