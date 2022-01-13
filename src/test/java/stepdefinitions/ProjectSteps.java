package stepdefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ProjectSteps extends BaseStepDef{

    TestContext testContext;

    public ProjectSteps(TestContext context){
        super(context);
        testContext = context;
    }

    @Given("the user login to system")
    public void the_user_login_to_system() {
        driver.get("https://anhtester.com");
    }

    @When("user open the project page")
    public void user_open_the_project_page() {
        System.out.println("user_open_the_project_page");
    }

    @When("user click add project button")
    public void user_click_add_project_button() {
        System.out.println("user_click_add_project_button");

        Assert.assertTrue(true);
    }

    @Then("the add project dialog displays")
    public void the_add_project_dialog_displays() {
        System.out.println("the_add_project_dialog_displays");
    }

    @When("user enter data on form information")
    public void user_enter_data_on_form_information() {
        System.out.println("user_enter_data_on_form_information");
    }

    @When("click save button")
    public void click_save_button() {
        System.out.println("click_save_button");
    }

    @Then("the project just added on Project page")
    public void the_project_just_added_on_project_page() {
        System.out.println("the_project_just_added_on_project_page");
    }

}
