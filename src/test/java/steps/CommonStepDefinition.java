package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.RequestManager;
import utilities.ResponseManager;

public class CommonStepDefinition {

    private final RequestManager requestManager = new RequestManager();

    @Given("El usuario se autentica con el servidor")
    public void initAuth() {
        requestManager.initAuth();
    }

    @Then("Verificar StatusCode sea {int}")
    public void verifyStatusCode(int expectedStatusCode) {
        ResponseManager.verifyStatusCode(expectedStatusCode);
    }

    @And("Verificar ResponseTime sea menor a {int}ms")
    public void verifyResponseTime(int maxResponseTime) {
        ResponseManager.verifyResponseTime(maxResponseTime);
    }
}
