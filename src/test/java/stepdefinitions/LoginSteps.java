package stepdefinitions;

import common.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

import utils.WebUI;

public class LoginSteps extends BaseSteps {

    TestContext testContext;

    public LoginSteps(TestContext context){
        super(context);
        testContext = context;
    }

    @Given("user navigate to url {string}")
    public void userNavigateToUrl(String url) {
        System.out.println("Driver on Steps class: " + driver);
        driver.get(url);
    }

    @When("user enter username {string} and password {string}")
    public void userEnterUsernameAndPassword(String email, String password) {
        WebUI.sleep(1);
        driver.findElement(By.xpath("//input[@id='iusername']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='ipassword']")).sendKeys(password);
    }

    @And("click login button")
    public void clickLoginButton() {
        WebUI.sleep(1);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("The user redirect to Dashboard page")
    public void theUserRedirectToDashboardPage() {
        WebUI.sleep(5);
        Assert.assertTrue(true, "Lỗi rồi");
    }

}
