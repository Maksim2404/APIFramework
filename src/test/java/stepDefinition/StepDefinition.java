package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
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

    @Given("Add place payload {string} {string} {string}")
    public void add_place_payload(String name, String language, String address) throws IOException {

        res = given().spec(requestSpecification()).body(testDataBuild.addPlacePayload(name, language, address));
    }

    @When("User calls {string} with Post http request")
    public void user_calls_with_post_http_request(String resource) {

        APIResources resourceAPI = APIResources.valueOf(resource);
        System.out.println(resourceAPI.getResource());

        resSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();

        response = res
                .when()
                .post("/maps/api/place/add/json")
                .then()
                .spec(resSpec)
                .extract()
                .response();
    }

    @Then("The API call is success with status code {int}")
    public void the_api_call_is_success_with_status_code(Integer int1) {

        Assertions.assertThat(response.getStatusCode()).isEqualTo(200);
    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String keyValue, String expectedValue) {

        String resp = response.asString();
        JsonPath js = new JsonPath(resp);

        Object value = js.get(keyValue);
        if (value != null) {
            Assertions.assertThat(value.toString()).isEqualTo(expectedValue);
        } else {
            Assertions.fail("The key '" + keyValue + "' is not present in the response body or is null.");
        }
    }

    @When("User calls {string} with {string} http request")
    public void userCallsWithHttpRequest(String arg0, String arg1) {
    }
}
