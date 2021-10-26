package step;

import io.cucumber.java.en.And;

public class project02 extends StepValidationUtils {

    @And("Validate the schema {string}")
    public void validateTheSchema(String schemaName) {
        validationSchema(schemaName);
    }

}
