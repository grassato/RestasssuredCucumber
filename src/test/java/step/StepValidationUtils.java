package step;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import resources.Requests;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

/**
 * Classe base resposável por reunir utilitários para serem utlizado na validação das asserções
 *
 * @author dgrassato
 * @lastUpdate 2021/10/06, juandepaiva
 * @since 2021/09/28
 */
abstract class StepValidationUtils {

    public static Response response;
    public static ValidatableResponse validatableResponse;
    public static JsonPath js;
    public Requests requests;

    public static JsonPath rawToJson(final Response response) {
        js = new JsonPath(response.body().asString());
        return js;
    }

    public static JsonPath getJson() {
        js = validatableResponse.extract().jsonPath();
        return js;
    }

    public void verifyResponseKeyValues(final String key, final String val) {
        js = getJson();

        String keyValue = js.getString(key);
        assertThat(keyValue, is(val));
    }

    public void verifyTrue(final boolean val) {
        assertTrue(val);
    }

    public void verifyFalse(final boolean val) {
        assertFalse(val);
    }

    public void verifyEmpty(final String val) {
        assertNotNull(val);
    }

    public void verifyResponseStatusValue(int expectedCode) {
        validatableResponse.statusCode(is(expectedCode));
    }

    public void validationSchema(String schemaName) {

        final String schemaPath = "contracts/".concat(schemaName).concat(".json");
        validatableResponse.body(matchesJsonSchemaInClasspath(schemaPath)).assertThat();

    }

}
