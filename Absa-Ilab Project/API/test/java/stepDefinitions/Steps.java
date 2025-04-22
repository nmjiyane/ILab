package stepDefinitions;

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

public class Steps {

    private static final String BASE_URL = "https://dog.ceo/api";

    private static String token;
    private static Response response;
    private static String jsonString;
    //private static String bookId;



    @Given("get the list of all dog breeds")
    public void get_the_list_of_all_dog_breeds() {


        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        response = request.get("/breeds/list/all");

        jsonString = response.asString();
        List<Map<String, String>> lists = JsonPath.from(jsonString).get("retriever");
        Assert.assertTrue(lists.size() > 0);
        throw new io.cucumber.java.PendingException();
    }
    @When("verify the <retriever> on list of the breed")
    public boolean verify_the_retriever_on_list_of_the_breed(String retriever) {
        // Write code here that turns the phrase above into concrete actions

        if(retriever.equals("") || retriever == null)
        {
            RestAssured.baseURI = BASE_URL;
            RequestSpecification request = RestAssured.given();
            response = request.get("/breeds/list/all");
            jsonString = response.asString();
            List<Map<String, String>> lists = JsonPath.from(jsonString).get("retriever");

            for (Map<String, String> str : lists) {
                if (str.equals(retriever)) {

                    return  true; //string found
                }
            }
        }
            throw new io.cucumber.java.PendingException();
        }

    @Then("produce a list of sub-breeds for <retriever>")
    public void produce_a_list_of_sub_breeds_for_retriever() {
        // Write code here that turns the phrase above into concrete actions
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        response = request.get("/breeds/list/all");

        jsonString = response.asString();
        List<Map<String, String>> lists = JsonPath.from(jsonString).get("retriever");
        Assert.assertTrue(lists.size() > 0);
        throw new io.cucumber.java.PendingException();
    }
    @Then("produce a random image link for the sub-breed <golden>")
    public void produce_a_random_image_link_for_the_sub_breed_golden(String goldenRetriever) {
        // Write code here that turns the phrase above into concrete actions
        RestAssured.baseURI = "https://dog.ceo/api/breed/"+goldenRetriever;
        RequestSpecification request = RestAssured.given();
        response = request.get("/images/random");

        jsonString = response.asString();
        Assert.assertTrue(jsonString.equals(goldenRetriever));
        throw new io.cucumber.java.PendingException();
    }
}
