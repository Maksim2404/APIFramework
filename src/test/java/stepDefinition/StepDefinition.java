package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.assertj.core.api.Assertions;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class StepDefinition extends Utils {

    RequestSpecification res;
    ResponseSpecification resSpec;
    Response response;
    TestDataBuild testDataBuild = new TestDataBuild();
    static String placeId;

    @Given("Add place payload {string} {string} {string}")
    public void add_place_payload(String name, String language, String address) throws IOException {

        res = given().spec(requestSpecification()).body(testDataBuild.addPlacePayload(name, language, address));
    }

    @When("User calls {string} with {string} http request")
    public void userCallsWithHttpRequest(String resource, String method) {

        /*constructor will be called with 'valueOf' resource you pass!*/
        APIResources resourceAPI = APIResources.valueOf(resource);
        System.out.println(resourceAPI.getResource());

        resSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();

        if (method.equalsIgnoreCase("POST"))
            response = res
                    .when()
                    .post(resourceAPI.getResource());
        else if (method.equalsIgnoreCase("GET"))
            response = res.when().get(resourceAPI.getResource());
    }

    @Then("The API call is success with status code {int}")
    public void the_api_call_is_success_with_status_code(Integer int1) {

        Assertions.assertThat(response.getStatusCode()).isEqualTo(200);
    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String keyValue, String expectedValue) {

        Assertions.assertThat(getJsonPath(response, keyValue)).isEqualTo(expectedValue);
    }

    @And("verify place_Id created maps to {string} using {string}")
    public void verifyPlace_IdCreatedMapsToUsing(String expectedName, String resource) throws IOException {

        placeId = getJsonPath(response, "place_id");

        res = given().spec(requestSpecification()).queryParam("place_id", placeId);

        userCallsWithHttpRequest(resource, "GET");

        String actualName = getJsonPath(response, "name");

        Assertions.assertThat(actualName).isEqualTo(expectedName);
    }

    @Given("Delete Place Payload")
    public void deletePlacePayload() throws IOException {

        res = given().spec(requestSpecification()).body(testDataBuild.deletePlacePayload(placeId));
    }
}
