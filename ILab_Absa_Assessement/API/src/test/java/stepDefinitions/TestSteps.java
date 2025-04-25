package stepDefinitions;

import Util.ConfigFileReader;
import com.sun.tools.jxc.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class TestSteps {

    private ConfigFileReader configFileReader;

    private static Response response;
    private static String jsonString;



    @Given("produce a list of all dog breeds")
    public void produce_a_list_of_all_dog_breeds() {
        RestAssured.baseURI = configFileReader.geBaseURL();
        RequestSpecification request = RestAssured.given();
        response = request.get(configFileReader.listofBreed());

        jsonString = response.asString();
        List<Map<String, String>> lists = JsonPath.from(jsonString).get();
        Assert.assertTrue(lists.size() > 0);
        throw new io.cucumber.java.PendingException();
    }

    @When("verify {string} breed is within the list")
    public void verify_breed_is_within_the_list(String retriever) {

            RestAssured.baseURI = configFileReader.geBaseURL();
            RequestSpecification request = RestAssured.given();
            response = request.get(configFileReader.listofBreed());
            jsonString = response.asString();
            List<Map<String, String>> lists = JsonPath.from(jsonString).get();

            for (Map<String, String> str : lists) {
                if (str.equals(retriever)) {

                    Assert.assertTrue(true);
                }
            }
        throw new io.cucumber.java.PendingException();
    }

    @Then("request to produce a list of sub-breeds")
    public void request_to_produce_a_list_of_sub_breeds_for() {
        // Write code here that turns the phrase above into concrete actions
        RestAssured.baseURI = configFileReader.geBaseURL();
        RequestSpecification request = RestAssured.given();
        response = request.get(configFileReader.subBreed());

        jsonString = response.asString();
        List<Map<String, String>> lists = JsonPath.from(jsonString).get("retriever");
        Assert.assertTrue(lists.size() > 0);
        throw new io.cucumber.java.PendingException();
    }

    @Then("produce a random image or link for the sub-breed {string}")
    public void produce_a_random_image_or_link_for_the_sub_breed(String subBreed) {
        // Write code here that turns the phrase above into concrete actions
        RestAssured.baseURI = configFileReader.geBaseURL();
        RequestSpecification request = RestAssured.given();
        response = request.get(configFileReader.randomBreedImage());

        jsonString = response.asString();
        Assert.assertTrue(jsonString.equals(subBreed));
        throw new io.cucumber.java.PendingException();
    }
}
