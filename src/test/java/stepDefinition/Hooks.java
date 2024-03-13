package stepDefinition;

import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {

    @Before("@DeletePlace")
    public void beforeScenario() throws IOException {

        /*write a code that will give you a place id and execute this code only when placeId is null*/

        StepDefinition stepDefinition = new StepDefinition();

        if (StepDefinition.placeId == null) {

            stepDefinition.add_place_payload("Maksim", "French", "1401 Iterate St");
            stepDefinition.userCallsWithHttpRequest("AddPlaceAPI", "POST");
            stepDefinition.verifyPlace_IdCreatedMapsToUsing("Maksim", "getPlaceAPI");
        }
    }
}
