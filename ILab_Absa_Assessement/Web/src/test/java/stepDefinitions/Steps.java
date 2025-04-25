package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProviders.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.Person;
import pageObjects.Table;

import java.util.concurrent.TimeUnit;

public class Steps {

    private Person person = new Person();
    private Table table = new Table();
    WebDriver driver;

    private ConfigFileReader configFileReader;

    @Given("Navigate to <link>")
    public void navigate_to_link(String url) {
        // Write code here that turns the phrase above into concrete actions
        System.setProperty(configFileReader.getDriverType(),configFileReader.getDriverPath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(configFileReader.geBaseURL()); //read URL FROM CONFIG
        throw new io.cucumber.java.PendingException();
    }

    @When("Validate that you are on the User List Table")
    public void validate_that_you_are_on_the_User_List_Table() {
        // Write code here that turns the phrase above into concrete actions
      table.checkTableIsDisplayed();
        throw new PendingException();
    }

    @Then("Click Add user")
    public void click_Add_user() {
        // Write code here that turns the phrase above into concrete actions

       table.clickButton();

        throw new io.cucumber.java.PendingException();
    }

    @Then("Add users with the details")
    public void add_users_with_the_details(String scenarioNo,String fname,String lname, String username,String password, String customer, String role,String email, String cellNo) {
        // Write code here that turns the phrase above into concrete actions

        person.enterDetails(fname,lname,username,password,customer,role,email,cellNo,scenarioNo);


        throw new io.cucumber.java.PendingException();
    }

}
