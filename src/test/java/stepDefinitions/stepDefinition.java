package stepDefinitions;

import POJO.Addplace;
import POJO.Location;
import Resources.TestDataBuild;
import Resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

public class stepDefinition extends Utils{

    RequestSpecification req;
    Response response;
    TestDataBuild td = new TestDataBuild();


    @Given("Add place payload")
    public void add_place_payload() {

        req = given().log().all().spec(requestSpecification())
                .body(td.addPayload());
    }

    @When("User call {string} with post http request")
    public void user_call_with_post_http_request(String string) {
        response = req
                .when().post("maps/api/place/add/json")
                .then().spec(responseSpecification()).extract().response();    }

    @Then("API call success with statuscode as {int}")
    public void api_call_success_with_as(Integer value) {
        int actual = response.getStatusCode();
        Assert.assertEquals(200,actual);
    }

    @Then("In response body {string} as {string}")
    public void in_response_body_as(String key, String value) {
        String resp = response.asString();
        JsonPath js = new JsonPath(resp);
       assertEquals(js.get(key).toString(),value);
    }

}
