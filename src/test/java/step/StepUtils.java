package step;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Method;

/**
 * Classe base resposável por reunir utilitários para serem utlizado nos requests
 *
 * @author dgrassato, juandepaiva
 * @lastUpdate 2021/10/06, juandepaiva
 * @since 2021/10/06
 */
abstract class StepUtils extends StepValidationUtils {

    public String paramValue;

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

    @And("Validate the schema {string}")
    public void validateTheSchema(String schemaName) {
        validationSchema(schemaName);
    }

    @Given("User calls {string} with GET http request")
    public void userCallsWithGETHttpRequest(String apiName) {
        response = requests.getRequestGivenApiName(apiName);
        validatableResponse = response.then();
    }


}
