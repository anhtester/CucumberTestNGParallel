package stepdefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.helpers.Helpers;

public class DashboardSteps extends BaseStepDef {

    TestContext testContext;

    public DashboardSteps(TestContext context) {
        super(context);
        testContext = context;
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
        Helpers.delay(5);
        driver.findElement(By.xpath("//span[contains(text(),'" + menu + "')]")).click();
    }

    @Then("The user redirect to this page")
    public void theUserRedirectToThisPage() {
        Helpers.delay(3);
        Assert.assertTrue(true);
    }

}
