package stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.Person;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Steps {

    private Person person = new Person();
    WebDriver driver;

    @Given("Navigate to <link>")
    public void navigate_to_link(String url) {
        // Write code here that turns the phrase above into concrete actions
        System.setProperty("webdriver.chrome.driver","C:\\nathi\\Libs\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(person.getURL());
        throw new io.cucumber.java.PendingException();
    }

    @When("Validate that you are on the User List Table")
    public void validate_that_you_are_on_the_User_List_Table() {
        // Write code here that turns the phrase above into concrete actions

      boolean checkTable = Boolean.parseBoolean(String.valueOf(driver.findElement(By.className("smart-table table table-striped")).isDisplayed()));
      if((checkTable == true))
      {
          Assert.assertTrue(true);
      }else {
          Assert.assertTrue(false);
      }
        throw new PendingException();
    }

    @Then("Click Add user")
    public void click_Add_user() {
        // Write code here that turns the phrase above into concrete actions

        //click the add button
        driver.findElement(By.className("btn btn-link pull-right")).click();
        throw new io.cucumber.java.PendingException();
    }

    @Then("Add users with the details")
    public void add_users_with_the_details(String scenarioNo,String fname,String lname, String username,String password, String customer, String role,String email, String cellNo) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.name("FirstName")).sendKeys(fname);
        driver.findElement(By.name("LastName")).sendKeys(lname);

        //Ensure that User Name (*) is unique on each run
        if( checkCharacterorUsername(username) == true)
        {
            driver.findElement(By.name("UserName")).sendKeys(username);
        }
        else {
            System.out.println("Unwanted Character");
        }
        driver.findElement(By.name("Password")).sendKeys(password);
        driver.findElement(By.name("Customer")).sendKeys(customer);
        driver.findElement(By.name("role")).sendKeys(role);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("cell")).sendKeys(cellNo);


        //Ensure that your users are added to the list
        if(scenarioNo.equals("No1"))
        {
            String fname1 = String.valueOf(driver.findElement(By.className(" smart-table-data-cell")).getText().equals(fname));
            person.setFname(fname1);
        }else if(scenarioNo.equals("No2"))
        {
            String fname2 = String.valueOf(driver.findElement(By.className(" smart-table-data-cell")).getText().equals(fname));
            person.setFname(fname2);
        }
        else
        {
            System.out.println("Sorry users are NOT added to the list");
        }


        throw new io.cucumber.java.PendingException();
    }
    public boolean checkCharacterorUsername(String username)
    {
        String str = username;
        boolean checkChar = false;
        char targetChar = '*';

        int index = str.indexOf(targetChar);

        if (index != -1) {
            // Character found
            System.out.println("Character '" + targetChar + "' found at index: " + index);

            checkChar = true;
        } else {
            // Character not found
            System.out.println("Character '" + targetChar + "' not found.");
        }
        return checkChar;
    }
}
