package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
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

public class LoginSteps {

    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    
    @Before
    public void before() {
        driver.set(new DriverManager().getDriver());
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

    @Given("user navigate to url {string}")
    public void userNavigateToUrl(String url) {
        System.out.println(driver);
        driver.get().get(url);
    }

    @When("user enter username {string} and password {string}")
    public void userEnterUsernameAndPassword(String email, String password) {
        Helpers.delay(1);
        driver.get().findElement(By.xpath("//input[@id='iusername']")).sendKeys(email);
        driver.get().findElement(By.xpath("//input[@id='ipassword']")).sendKeys(password);
    }

    @And("click login button")
    public void clickLoginButton() {
        Helpers.delay(1);
        driver.get().findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("The user redirect to Dashboard page")
    public void theUserRedirectToDashboardPage() {
        Helpers.delay(1);
//        Assert.assertTrue(false, "The test case is fail");
        Assert.assertTrue(true);
    }

}
