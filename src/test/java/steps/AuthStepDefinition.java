package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import models.login.LoginResponse;
import org.junit.jupiter.api.Assertions;
import request.AuthRequest;
import utilities.ResponseManager;

public class AuthStepDefinition {
    private final AuthRequest authRequest = new AuthRequest();
    private String requestBodyPath;
    private LoginResponse loginResponse;

    @Given("Obtener requestBody de login con credenciales {string}")
    public void getRequestBody(String credentialType) {
        final var commonPath = "src/test/resources/requestsBody.dummyjson/%s.json";
        final var jsonName = switch (credentialType) {
            case "validas" -> "login";
            case "invalidas" -> "invalid";
            case "vacias" -> "empty";
            default -> "";
        };
        requestBodyPath = String.format(commonPath, jsonName);
    }

    @When("Llamar al requestLogin")
    public void callLoginRequest() {
        authRequest.login(requestBodyPath);

    }

    @And("Obtener requestBody de Login")
    public void getResponseBody() {
        loginResponse = ResponseManager.getResponseBody(LoginResponse.class);
    }

    @And("Verificar Id sea positivo")
    public void verifyIdPositive() {
        Assertions.assertTrue(loginResponse.id() > 0);
    }

    @And("Verificar longitud de accessToken y refreshToken sea igual a {int}")
    public void verifyLegthToken(int expectedLegth) {
        final var accessToken = loginResponse.accessToken();
        final var refreshToken = loginResponse.refreshToken();

        Assertions.assertAll(
                () -> Assertions.assertEquals(accessToken.length(), expectedLegth),
                () -> Assertions.assertEquals(refreshToken.length(), expectedLegth)
        );
    }
}
