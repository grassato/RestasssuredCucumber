package step;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Method;
import resources.Requests;


public class project01 extends StepValidationUtils {

    public String paramValue;

    public project01(Requests requests) {
        this.requests = requests;
    }


    @Given("an address code {string}")
    public void anAddressCode(String cep) {
        paramValue = cep;
    }

    @When("User calls {string} with {string} http request")
    public void user_calls_request_with_http_request(final String apiName, final String requestType) {

        response = requests.getRequest(apiName, Method.valueOf(requestType), paramValue);
        validatableResponse = response.then();
    }

    @Then("Status code is {int}")
    public void status_code_is(final Integer expectedCode) {
        System.out.println("Status Code: " + response.statusCode());
        verifyResponseStatusValue(expectedCode);

    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(final String value1, final String value2) {
        verifyResponseKeyValues(value1, value2);
    }

    @Given("User calls {string} with GET http request")
    public void userCallsWithGETHttpRequest(String apiName) {
        response = requests.getRequestGivenApiName(apiName);
        validatableResponse = response.then();
    }



}
