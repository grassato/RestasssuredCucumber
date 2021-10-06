package step;

import io.cucumber.java.en.Given;
import resources.Requests;


public class ViaCep extends StepUtils {


    public ViaCep(Requests requests) {
        this.requests = requests;
    }

    @Given("an address code {string}")
    public void anAddressCode(String cep) {
        paramValue = cep;
    }

}
